package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstBorderGuardsSearchDTO;
import com.bitsco.vks.dto.LstRuleSearchDTO;
import com.bitsco.vks.models.LstBorderGuardsRequest;
import com.bitsco.vks.models.LstRuleRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstRuleService {
    List<LstRuleSearchDTO> search(LstRuleRequest lstRuleRequest, Pageable pageable);

    String save(LstRuleRequest req, String username);

    String delete(String caseType, String userFor);
}
