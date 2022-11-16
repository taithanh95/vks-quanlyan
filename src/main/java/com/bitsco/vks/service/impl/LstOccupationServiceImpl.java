package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstNationSearchDTO;
import com.bitsco.vks.dto.LstOccupationSearchDTO;
import com.bitsco.vks.models.LstOccupationRequest;
import com.bitsco.vks.repository.LstOccupationRepository;
import com.bitsco.vks.service.LstOccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LstOccupationServiceImpl implements LstOccupationService {
    @Autowired
    private LstOccupationRepository lstOccupationRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstOccupationSearchDTO> search(LstOccupationRequest lstOccupationRequest, Pageable pageable) {
        return lstOccupationRepository.search(pageable.getPageNumber(), pageable.getPageSize(), lstOccupationRequest.getSortField(), lstOccupationRequest.getSortOrder(), lstOccupationRequest.getOccuId(), lstOccupationRequest.getName(), lstOccupationRequest.getBranchJob());
    }

    @Override
    @Transactional
    public String insert(LstOccupationRequest req, String username) {
        return lstOccupationRepository.insert(
                req.getAction(),
                req.getOccuId(),
                req.getName(),
                req.getRemark(),
                req.getBranchJob(),
                username);
    }

    @Override
    public String delete(String occuid) {
        return lstOccupationRepository.delete(occuid);
    }

    @Override
    public List<LstOccupationSearchDTO> getOccupation(String query) {
        return lstOccupationRepository.getOccupation(query, 100);
    }
}
