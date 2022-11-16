package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstDecisionSearchDTO;
import com.bitsco.vks.entity.LstDecisionEntity;
import com.bitsco.vks.models.LstDecisionRequest;
import com.bitsco.vks.models.LstDecisionSaveRequest;
import com.bitsco.vks.repository.LstDecisionRepository;
import com.bitsco.vks.service.LstDecisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

@Service
public class LstDecisionServiceImpl implements LstDecisionService {
    @Autowired
    private LstDecisionRepository lstDecisionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstDecisionSearchDTO> search(LstDecisionRequest lstDecisionRequest, Pageable pageable) {
        return lstDecisionRepository.search(pageable.getPageNumber(), pageable.getPageSize(),
                lstDecisionRequest.getSortField(), lstDecisionRequest.getSortOrder(),
                lstDecisionRequest.getId(), lstDecisionRequest.getName(), lstDecisionRequest.getApplyFor(),
                lstDecisionRequest.getUserFor(), lstDecisionRequest.getStatus(), lstDecisionRequest.getApplyFinish(), lstDecisionRequest.getDeciType());

    }

    @Override
    public List<LstDecisionSearchDTO> getListApplyForTBTG(Pageable pageable, String search, String sortFields, String sortOrder) {
        return lstDecisionRepository.getListApplyForTBTG(pageable.getPageNumber(), pageable.getPageSize(), search, sortFields, sortOrder);
    }

    @Override
    public List<LstDecisionEntity> searchForHS(String usefor, String applyfor, String decitype) {
        return lstDecisionRepository.searchForHS(usefor, applyfor, decitype);
    }

    @Override
    public LinkedCaseInsensitiveMap getDecisionById(String deciid) {
        return lstDecisionRepository.getDecisionById(deciid);
    }

    @Override
    public List<LstDecisionSearchDTO> autocomplete(String query) {
        return lstDecisionRepository.autocomplete(query);
    }

    @Override
    public String save(LstDecisionSaveRequest req, String username) {
        return lstDecisionRepository.save(req, username);
    }

    @Override
    public String delete(String deciid) {
        return lstDecisionRepository.delete(deciid);
    }

    @Override
    public List<LstDecisionSearchDTO> findTreeData(String deciid, String decilevel) {
        return lstDecisionRepository.getFnFindTree(decilevel,deciid);
    }
}
