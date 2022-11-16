package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstBorderGuardsSearchDTO;
import com.bitsco.vks.dto.LstRuleSearchDTO;
import com.bitsco.vks.models.LstRuleRequest;

import java.util.List;

public interface LstRuleRepository {
    List<LstRuleSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String caseType, String userFor, String setUnit, String thoi_han_tu, String thoi_han_den);

    String save(LstRuleRequest req, String username);

    String delete(String caseType, String userFor);

}
