package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstRuleSearchDTO;
import com.bitsco.vks.models.LstRuleRequest;
import com.bitsco.vks.repository.LstRuleRepository;
import com.bitsco.vks.service.LstRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LstRuleServiceImpl implements LstRuleService {
    @Autowired
    private LstRuleRepository lstRuleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstRuleSearchDTO> search(LstRuleRequest lstRuleRequest, Pageable pageable) {
        return lstRuleRepository.search(pageable.getPageNumber(),
                pageable.getPageSize(),
                lstRuleRequest.getSortField(),
                lstRuleRequest.getSortOrder(),
                lstRuleRequest.getCaseType(),
                lstRuleRequest.getUserFor(),
                lstRuleRequest.getSetUnit(),
                lstRuleRequest.getThoi_han_tu(),
                lstRuleRequest.getThoi_han_den());
    }

    @Override
    public String save(LstRuleRequest req, String username) {
        return lstRuleRepository.save(req, username);
    }

    @Override
    public String delete(String caseType, String userFor) {
        return lstRuleRepository.delete(caseType, userFor);
    }
}
