package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.LstCode;
import com.bitsco.vks.entity.LstLaw;
import com.bitsco.vks.entity.LstLawGroup;
import com.bitsco.vks.entity.SppAccused;
import com.bitsco.vks.models.LstLawSearchRequest;
import com.bitsco.vks.models.SppAccusedSaveRequest;
import com.bitsco.vks.models.SppAccusedSearchRequest;
import com.bitsco.vks.repository.LstLawRepository;
import com.bitsco.vks.repository.PreventMeasuresRepository;
import com.bitsco.vks.repository.SppAccusedRepository;
import com.bitsco.vks.repository.SppViolantionDAO;
import com.bitsco.vks.service.SppAccusedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SppAccusedServiceImpl implements SppAccusedService {
    @Autowired
    private SppAccusedRepository sppAccusedRepository;
    @Autowired
    private LstLawRepository lstLawRepository;
    @Autowired
    private SppViolantionDAO sppViolantionDAO;
    @Autowired
    private PreventMeasuresRepository preventMeasuresRepository;

    @Override
    public List<SppAccused> search_bc(SppAccusedSearchRequest request, Pageable pageable) {
        return sppAccusedRepository.search_bc(pageable.getPageNumber(), pageable.getPageNumber(), request.sortField, request.sortOrder, request.regicode, request.sppid
                , request.casecode);
    }

    @Override
    @Transactional
    public String save(SppAccusedSaveRequest request, String userId) {
        String accuCode = sppAccusedRepository.insertUpdate(request.action, request.casecode, request.accused, request.address, request.locaid, request.regicode, request.spc, request.spp, request.police
                , request.army, request.customs, request.ranger, request.border, request.country, request.sppid, request.lawcode, request.phapnhan, userId);
        List<String> list = Arrays.asList("SppAccused.error.1416yoAccuseOnlyL3L4", "SppAccused.error.duplicateAccused", "SppAccused.error.accusedNoLaw");
        if (list.contains(accuCode)) return accuCode;
        if (request.accused.getLstViolantion() != null) {
            for (int i = 0; i < request.accused.getLstViolantion().size(); i++) {
                request.accused.getLstViolantion().get(i).setCaseCode(request.casecode);
                request.accused.getLstViolantion().get(i).setAccuCode(accuCode);
                sppViolantionDAO.save(request.accused.getLstViolantion().get(i));
            }
        }
        preventMeasuresRepository.delete(request.accused.getAccucode());
        if (request.accused.getLstPreventMeasures() != null) {
            request.accused.getLstPreventMeasures().forEach(dt -> {
                    dt.setAccucode(accuCode);
                    dt.setOption("I");
                    preventMeasuresRepository.insertOrUpdate(dt, "username");
               }
            );
        }
//        if (request.accused.getLstPreventMeasures() != null) {
//            for (int i = 0; i < request.accused.getLstPreventMeasures().size(); i++) {
//                request.accused.getLstPreventMeasures().get(i).setAccucode(accuCode);
//                request.accused.getLstPreventMeasures().get(i).setOption("I");
//                preventMeasuresRepository.insertOrUpdate(request.accused.getLstPreventMeasures().get(i), "username");
//            }
//        }
        return accuCode;
    }

    @Override
    public String delete(String code) {
        return sppAccusedRepository.delete(code);
    }

    @Override
    public List<LstLaw> findLawcodeByAccused(String accucode) {
        return sppAccusedRepository.findLawcodeByAccused(accucode);
    }

    @Override
    public List<LstLaw> searchLaw(LstLawSearchRequest request, Pageable pageable) {
        return lstLawRepository.sarchLaw(pageable.getPageNumber(), pageable.getPageSize(), request.sortField, request.sortOrder, request.law);
    }

    @Override
    public List<LstCode> getLstCode(String codeid) {
        return lstLawRepository.getLstCode(codeid);
    }

    @Override
    public List<LstLawGroup> getLstLawGroup(String codeid) {
        return lstLawRepository.getLstLawGroup(codeid);
    }

    @Override
    public List<String> findCaseCodeByArresteenId(String arresteeId) {
        return sppAccusedRepository.findAccusedCodeByArresteeId(arresteeId);
    }
}
