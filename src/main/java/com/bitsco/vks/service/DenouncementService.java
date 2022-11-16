package com.bitsco.vks.service;

import com.bitsco.vks.dto.*;
import io.swagger.models.auth.In;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DenouncementService {

    DenouncementDTO getDenouncementById(Long id, String sppId, String username);

    void updateDenouncement(DenouncementDTO denouncementDTO, String sppId, String username);

    List<DenouncementDTO> getLstDenounce(DenouncementDTO denouncementDTO, Pageable pageable);

    void createDenouncement(DenouncementDTO denouncementDTO, String username);

    void deleteData(DenouncementDTO denouncementDTO, String sppId, String username);

    List<DenouncedPersonDTO> denouncedPersonFindById(Long id);

    List<InvestigationActivityDTO> investigationActivityFindById(Long id);

    List<SettlementDecisionDTO> settlementDecisionFindById(Long id);

    List<VerificationInvestigationDTO> verificationInvestigationFindById(Long id);

    int countSetting(DenouncementDTO denouncementDTO);

    Integer getDefaultLevelShareInfoBySppId(String sppId);
}
