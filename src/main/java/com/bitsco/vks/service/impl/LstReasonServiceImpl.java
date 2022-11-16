package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstReasonSearchDTO;
import com.bitsco.vks.entity.LstReason;
import com.bitsco.vks.models.LstReasonRequest;
import com.bitsco.vks.repository.LstReasonRepository;
import com.bitsco.vks.service.LstReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LstReasonServiceImpl implements LstReasonService {

    @Autowired
    private LstReasonRepository lstReasonRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstReasonSearchDTO> search(LstReasonRequest lstReasonRequest, Pageable pageable) {
        return lstReasonRepository.search(pageable.getPageNumber(), pageable.getPageSize(), lstReasonRequest.getSortField(), lstReasonRequest.getSortOrder(), lstReasonRequest.getReasonId(), lstReasonRequest.getReasonName(), lstReasonRequest.getDeciId());
    }

    @Override
    public List<LstReason> loadLstReason(String usefor, String applyfor, String deciid) {
        return  lstReasonRepository.loadLstReason(usefor, applyfor, deciid);
    }

    @Override
    public String save(LstReasonRequest req, String username) {
        return lstReasonRepository.save(
                req.getAction(),
                req.getReasonId(),
                req.getReasonName(),
                req.getDeciId(),
                username);
    }

    @Override
    public String delete(String reasonid) {
        return lstReasonRepository.delete(reasonid);
    }
}
