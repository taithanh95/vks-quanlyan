package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstAppealSearchDTO;
import com.bitsco.vks.models.LstAppealRequest;
import com.bitsco.vks.repository.LstAppealRepository;
import com.bitsco.vks.service.LstAppealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LstAppealServiceImpl implements LstAppealService {
    @Autowired
    private LstAppealRepository lstAppealRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstAppealSearchDTO> search(LstAppealRequest lstAppealRequest, Pageable pageable) {
        return lstAppealRepository.search(pageable.getPageNumber(),
                pageable.getPageSize(),
                lstAppealRequest.getSortField(),
                lstAppealRequest.getSortOrder(),
                lstAppealRequest.getAppealid(),
                lstAppealRequest.getAppealname());
    }

    @Override
    public String save(LstAppealRequest req, String username) {
        return lstAppealRepository.save(req, username);
    }

    @Override
    public String delete(String appealid) {
        return lstAppealRepository.delete(appealid);
    }
}
