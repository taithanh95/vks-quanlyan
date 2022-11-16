package com.bitsco.vks.service.impl;

import com.bitsco.vks.constant.GeneralModelStatus;
import com.bitsco.vks.constant.SettlementStatus;
import com.bitsco.vks.constant.ShareInfoLvl;
import com.bitsco.vks.dto.*;
import com.bitsco.vks.entity.*;
import com.bitsco.vks.mapper.*;
import com.bitsco.vks.repository.*;
import com.bitsco.vks.service.DenouncementService;
import com.bitsco.vks.utils.DataUtil;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DenouncementServiceImpl implements DenouncementService {

    private final ApParamRepository apParamRepository;

    private final DenouncementRepository denouncementRepository;

    private final DenouncementMapper denouncementMapper = Mappers.getMapper(DenouncementMapper.class);

    private final DenouncedPersonMapper denouncedPersonMapper = Mappers.getMapper(DenouncedPersonMapper.class);

    private final DenouncedPersonRepository denouncedPersonRepository;

    private final InvestigationActivityRepository activityRepository;

    private final InvestigationActivityMapper activityMapper = Mappers.getMapper(InvestigationActivityMapper.class);

    private final SettlementDecisionRepository settlementDecisionRepository;

    private final SettlementDecisionMapper settlementDecisionMapper = Mappers.getMapper(SettlementDecisionMapper.class);

    private final VerificationInvestigationRepository investigationRepository;

    private final VerificationInvestigationMapper investigationMapper = Mappers.getMapper(VerificationInvestigationMapper.class);

//    private final JwtToken jwtToken;

    public DenouncementServiceImpl(
            ApParamRepository apParamRepository,
            DenouncementRepository denouncementRepository,
            DenouncedPersonRepository denouncedPersonRepository,
            InvestigationActivityRepository activityRepository,
            SettlementDecisionRepository settlementDecisionRepository,
            VerificationInvestigationRepository investigationRepository) {
        this.apParamRepository = apParamRepository;
        this.denouncementRepository = denouncementRepository;
        this.denouncedPersonRepository = denouncedPersonRepository;
        this.activityRepository = activityRepository;
        this.settlementDecisionRepository = settlementDecisionRepository;
        this.investigationRepository = investigationRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public DenouncementDTO getDenouncementById(Long id, String sppId, String username) {
        Optional<Denouncement> optionalDenouncement = this.denouncementRepository.findByIdCustom(id);
        if (optionalDenouncement.isPresent()) {
            this.checkPermission(optionalDenouncement.get(), sppId, false, username);
            return this.denouncementMapper.entityToDtoFetchAll(optionalDenouncement.get());
        }
        log.error("Denouncement id = {} not found", id);
        throw new EntityNotFoundException();
    }

    @Override
    @Transactional
    public void updateDenouncement(DenouncementDTO denouncementDTO, String sppId, String username) {
        Denouncement denouncement = this.denouncementMapper.dtoToEntityFetch(denouncementDTO);
        this.checkPermission(denouncement, sppId, true, username);
        Optional<Denouncement> optionalDenouncement =
                this.denouncementRepository.findByIdCustom(denouncement.getId());
        if (optionalDenouncement.isPresent()) {
            denouncement.updateRecordInfo(username);
            denouncement.getDenouncedPeople()
                    .forEach(e -> e.updateRecordInfo(username));
            denouncement.getInvestigationActivities()
                    .forEach(e -> e.updateRecordInfo(username));
            denouncement.getVerificationInvestigations()
                    .forEach(e -> e.updateRecordInfo(username));
            denouncement.getSettlementDecisions()
                    .forEach(e -> e.updateRecordInfo(username));
            this.updateDenouncementStatus(denouncement);
            this.denouncementRepository.save(denouncement);
//            this.saveRelatedEntities(denouncement);
        } else {
            log.error("Denouncement id = {} not found", denouncement.getId());
            throw new EntityNotFoundException();
        }
    }

    private void updateDenouncementStatus(Denouncement denouncement) {
        List<SettlementDecision> decisionList = denouncement.getSettlementDecisions()
                .stream()
                .filter(e -> GeneralModelStatus.ACTIVE.getValue() == e.getStatus()).collect(Collectors.toList());
        if (!decisionList.isEmpty()) {
            SettlementDecision lastDecision = decisionList.stream().max(
                    (o1, o2) -> Long.valueOf((o1.getExecuteOrder() - o2.getExecuteOrder())).intValue())
                    .orElse(null);

            List<ApParam> apParams = this.apParamRepository
                    .findApParamsByParamCodeAndStatus("DECISION_TYPE_IDS", GeneralModelStatus.ACTIVE.getValue());
            String decisionId = lastDecision.getDecisionId();
            List<String> settledDecisionIds = apParams
                    .stream()
                    .filter(e -> String.valueOf(SettlementStatus.SETTLED.getValue()).equals(e.getParamName()))
                    .findFirst()
                    .flatMap(e -> Optional.of(Arrays.asList(e.getParamValue().split(","))))
                    .orElse(new ArrayList<>());
            List<String> suspendedDecisionIds = apParams
                    .stream()
                    .filter(e -> String.valueOf(SettlementStatus.SUSPENDED.getValue()).equals(e.getParamName()))
                    .findFirst()
                    .flatMap(e -> Optional.of(Arrays.asList(e.getParamValue().split(","))))
                    .orElse(new ArrayList<>());
            log.info("Settled settlement IDS: {}; Suspended settlement IDS: {};", settledDecisionIds, suspendedDecisionIds);
            if (settledDecisionIds.contains(decisionId)) {
                /*
                 * Đã giải quyết
                 * Có 1 trong 3 QĐ:
                 * QĐ Khởi tố
                 * QĐ Không khởi tố
                 * QĐ Tạm đình chỉ
                 */
                denouncement.setSettlementStatus(SettlementStatus.SETTLED.getValue());
            } else if (suspendedDecisionIds.contains(decisionId)) {
                /*
                 * Tạm đình chỉ
                 * Có QĐ tạm đình chỉ việc giải quyết nguồn tin về tội phạm
                 */
                denouncement.setSettlementStatus(SettlementStatus.SUSPENDED.getValue());
            } else {// Đang giải quyết
                Date currentDate = new Date();
                if (currentDate.compareTo(denouncement.getSettlementTerm()) > 0) {
                    /*
                     * Thời hạn Giải quyết < Ngày hiện tại
                     * Thì đổi trạng thái Đã quá hạn
                     */
                    denouncement.setSettlementStatus(SettlementStatus.OVERDUE.getValue());
                } else {
                    denouncement.setSettlementStatus(SettlementStatus.BEING_SETTLED.getValue());
                }
            }
        } else {
            if (("2".equals(denouncement.getIpnClassifiedNews()) && this.isForwarded(denouncement))) {
                // Phiếu chuyển tin thì chuyển trạng thái Đã giải quyết
                denouncement.setSettlementStatus(SettlementStatus.SETTLED.getValue());
            } else {
                // Đang giải quyết
                Date currentDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date thoiHanGiaiQuyet = denouncement.getSettlementTerm();
                thoiHanGiaiQuyet.setHours(0);
                thoiHanGiaiQuyet.setMinutes(0);
                thoiHanGiaiQuyet.setSeconds(0);
                if (currentDate.compareTo(thoiHanGiaiQuyet) > 0) {
                    /*
                     * Thời hạn Giải quyết < Ngày hiện tại
                     * Thì đổi trạng thái Đã quá hạn
                     */
                    denouncement.setSettlementStatus(SettlementStatus.OVERDUE.getValue());
                } else if (denouncement.getIpnEnactmentId() == null) {
                    denouncement.setSettlementStatus(SettlementStatus.NOT_BEING_SETTLED.getValue());
                } else {
                    denouncement.setSettlementStatus(SettlementStatus.BEING_SETTLED.getValue());
                }
            }
        }
    }

    private boolean isForwarded(Denouncement denouncement) {
        return denouncement.getFnCode() != null ||
                denouncement.getFnDate() != null ||
                denouncement.getFnTakenOverAgency() != null ||
                denouncement.getFnTakenOverUnit() != null;
    }

    @Override
    public List<DenouncementDTO> getLstDenounce(DenouncementDTO denouncementDTO, Pageable pageable) {
        List<DenouncementDTO> list = new ArrayList<>();
        try {
            List<Object[]> search = denouncementRepository.getLstDenounce(denouncementDTO, false, pageable);

            if (!DataUtil.isNullOrEmpty(search)) {
                for (Object[] obj : search) {
                    DenouncementDTO dto = new DenouncementDTO();
                    dto.setId(DataUtil.safeToLong(obj[0]));
                    dto.setSppId(DataUtil.safeToString(obj[1]));
                    dto.setShareInfoLevel(DataUtil.safeToInt(obj[2]));
                    dto.setDenouncementCode(DataUtil.safeToLong(obj[3]));
                    dto.setTakenOverDate(DataUtil.safeToDate(obj[4]));
                    dto.setRReporter(DataUtil.safeToString(obj[5]));
                    dto.setNameAccused(DataUtil.safeToString(obj[6]));
                    dto.setDecisionName(DataUtil.safeToString(obj[7]));
                    dto.setSettlementStatus(DataUtil.safeToInt(obj[8]));
                    dto.setCreateUser(DataUtil.safeToString(obj[12]));
                    dto.setRownum(DataUtil.safeToLong(obj[14]));
                    list.add(dto);
                }
            }

        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    @Transactional
    public void createDenouncement(DenouncementDTO denouncementDTO, String username) {
        Integer year = getYearInDate(denouncementDTO.getTakenOverDate());
        Denouncement denouncement = denouncementMapper.dtoToEntityFetch(denouncementDTO);
        denouncement.setCreateDate(new Date());
        denouncement.setCreateUser(username);
        denouncement.setDenouncementCode(denouncementRepository.getDenounceCodeInYear(year));
        denouncement.setStatus(GeneralModelStatus.ACTIVE.getValue());
        denouncement.setSettlementStatus(SettlementStatus.NOT_BEING_SETTLED.getValue());
        this.denouncementRepository.saveAndFlush(denouncement);
//        this.saveRelatedEntities(denouncement);
    }

    private Integer getYearInDate(Date date) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date);
        return calendar1.get(Calendar.YEAR);
    }

    @Override
    @Transactional
    public void deleteData(DenouncementDTO denouncementDelete, String sppId, String username) {
        Date currentDate = new Date();
        DenouncementDTO denouncementDTO = this.getDenouncementById(denouncementDelete.getId(), sppId, username);
        if (null != denouncementDTO.getId()) {
            Denouncement denouncement = this.denouncementMapper.dtoToEntityFetch(denouncementDTO);
            this.checkPermission(denouncement, sppId, true, username);
            denouncement.setStatus(GeneralModelStatus.INACTIVE.getValue());
            denouncement.setUpdateDate(currentDate);
            denouncement.setUpdateUser(denouncementDelete.getUpdateUser());
            this.denouncementRepository.saveAndFlush(denouncement);
            // danh sach nguoi bi to cao
            List<DenouncedPersonDTO> lstDenouncedPerson = denouncedPersonFindById(denouncementDelete.getId());
            if (!DataUtil.isNullOrEmpty(lstDenouncedPerson)) {
                for (DenouncedPersonDTO dto : lstDenouncedPerson) {
                    DenouncedPerson denouncedPerson = denouncedPersonMapper.dtoToEntity(dto);
                    denouncedPerson.setUpdateDate(currentDate);
                    denouncedPerson.setUpdateUser(denouncementDelete.getUpdateUser());
                    denouncedPerson.setStatus(GeneralModelStatus.INACTIVE.getValue());
                    denouncedPersonRepository.save(denouncedPerson);
                }
            }
            // danh sach cqdt tien hanh
            List<InvestigationActivityDTO> activityDTOS = investigationActivityFindById(denouncementDelete.getId());
            if (!DataUtil.isNullOrEmpty(activityDTOS)) {
                for (InvestigationActivityDTO dto : activityDTOS) {
                    InvestigationActivity activity = activityMapper.dtoToEntity(dto);
                    activity.setUpdateDate(currentDate);
                    activity.setUpdateUser(denouncementDelete.getUpdateUser());
                    activity.setStatus(GeneralModelStatus.INACTIVE.getValue());
                    activityRepository.save(activity);
                }
            }
            // danh sach quyet dinh giai quyet
            List<SettlementDecisionDTO> settlementDecisionDTOS = settlementDecisionFindById(denouncementDelete.getId());
            if (!DataUtil.isNullOrEmpty(settlementDecisionDTOS)) {
                for (SettlementDecisionDTO dto : settlementDecisionDTOS) {
                    SettlementDecision settlementDecision = settlementDecisionMapper.dtoToEntity(dto);
                    settlementDecision.setUpdateDate(currentDate);
                    settlementDecision.setUpdateUser(denouncementDelete.getUpdateUser());
                    settlementDecision.setStatus(GeneralModelStatus.INACTIVE.getValue());
                    settlementDecisionRepository.save(settlementDecision);
                }
            }
            // danh sach dieu tra xac minh
            List<VerificationInvestigationDTO> investigationDTOS = verificationInvestigationFindById(denouncementDelete.getId());
            if (!DataUtil.isNullOrEmpty(investigationDTOS)) {
                for (VerificationInvestigationDTO dto : investigationDTOS) {
                    VerificationInvestigation verificationInvestigation = investigationMapper.dtoToEntity(dto);
                    verificationInvestigation.setUpdateDate(currentDate);
                    verificationInvestigation.setUpdateUser(denouncementDelete.getUpdateUser());
                    verificationInvestigation.setStatus(GeneralModelStatus.INACTIVE.getValue());
                }
            }

        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<DenouncedPersonDTO> denouncedPersonFindById(Long id) {

        Optional<List<DenouncedPerson>> denouncedPerson = this.denouncedPersonRepository.findByIdCustom(id);
        if (denouncedPerson.isPresent()) {

            return this.denouncedPersonMapper.entityToDtoListFetchAll(denouncedPerson.get());

        }
        return new ArrayList<>();
    }

    @Override
    public List<InvestigationActivityDTO> investigationActivityFindById(Long id) {
        Optional<List<InvestigationActivity>> activities = this.activityRepository.findByIdCustom(id);
        if (activities.isPresent()) {

            return this.activityMapper.entityToDtoListFetchAll(activities.get());

        }
        return new ArrayList<>();
    }

    @Override
    public List<SettlementDecisionDTO> settlementDecisionFindById(Long id) {
        Optional<List<SettlementDecision>> settlementDecisions = this.settlementDecisionRepository.findByIdCustom(id);
        if (settlementDecisions.isPresent()) {
            return this.settlementDecisionMapper.entityToDtoListFetchAll(settlementDecisions.get());
        }
        return new ArrayList<>();
    }

    @Override
    public List<VerificationInvestigationDTO> verificationInvestigationFindById(Long id) {
        Optional<List<VerificationInvestigation>> investigations = this.investigationRepository.findByIdCustom(id);
        if (investigations.isPresent()) {
            return this.investigationMapper.entityToDtoListFetchAll(investigations.get());
        }
        return new ArrayList<>();
    }

    @Override
    public int countSetting(DenouncementDTO denouncementDTO) {
        int rowCount = 0;
        List<Object[]> list = new ArrayList<>();
        list = denouncementRepository.getLstDenounce(denouncementDTO, true, null);
        if (!DataUtil.isNullOrEmpty(list)) {
            for (Object[] a : list) {
                rowCount = DataUtil.safeToInt(a[0]);
            }
        }
        return rowCount;
    }

    private void saveRelatedEntities(Denouncement denouncement) {
        List<DenouncedPerson> denouncedPeople = denouncement.getDenouncedPeople();
        if (denouncedPeople != null) {
            denouncedPeople.forEach(e -> {
                e.setDenouncementId(denouncement.getId());
                this.denouncedPersonRepository.saveAndFlush(e);
            });
        }
        List<InvestigationActivity> investigationActivities = denouncement.getInvestigationActivities();
        if (investigationActivities != null) {
            investigationActivities.forEach(e -> {
                e.setDenouncementId(denouncement.getId());
                this.activityRepository.saveAndFlush(e);
            });
        }
        List<VerificationInvestigation> verificationInvestigations = denouncement.getVerificationInvestigations();
        if (verificationInvestigations != null) {
            verificationInvestigations.forEach(e -> {
                e.setDenouncementId(denouncement.getId());
                this.investigationRepository.saveAndFlush(e);
            });
        }
        List<SettlementDecision> settlementDecisions = denouncement.getSettlementDecisions();
        if (settlementDecisions != null) {
            settlementDecisions.forEach(e -> {
                e.setDenouncementId(denouncement.getId());
                this.settlementDecisionRepository.saveAndFlush(e);
            });
        }
    }

    private void checkPermission(Denouncement denouncement, String sppId, boolean isUpdate, String username) {
        if (sppId == null)
            throw new AccessDeniedException("Thông tin đơn vị chưa được cung cấp");
        if (!sppId.equals(denouncement.getSppId())) {
            throw new AccessDeniedException("Người dùng không có quyền truy cập tin báo thuộc đơn vị khác");
        }
        if (isUpdate) {
            if (!username.equals(denouncement.getCreateUser()) &&
                    denouncement.getShareInfoLevel() != ShareInfoLvl.INTERNAL.getValue()) {
                throw new AccessDeniedException("Người dùng không có quyền cập nhật tin báo");
            }
        } else {
            if (!username.equals(denouncement.getCreateUser()) &&
                    denouncement.getShareInfoLevel() != ShareInfoLvl.INTERNAL.getValue() &&
                    denouncement.getShareInfoLevel() != ShareInfoLvl.PROTECTED.getValue()) {
                throw new AccessDeniedException("Người dùng không có quyền xem tin báo");
            }
        }

    }

    @Override
    public Integer getDefaultLevelShareInfoBySppId(String sppId) {
        return denouncementRepository.getDefaultLevelShareInfoBySppId(sppId);
    }
}
