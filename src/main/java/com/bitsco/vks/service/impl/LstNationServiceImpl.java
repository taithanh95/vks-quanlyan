package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstNationSearchDTO;
import com.bitsco.vks.entity.LstSPP;
import com.bitsco.vks.models.LstNationRequest;
import com.bitsco.vks.repository.LstNationRepository;
import com.bitsco.vks.service.LstNationService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LstNationServiceImpl implements LstNationService {

    @Autowired
    private LstNationRepository lstNationRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstNationSearchDTO> search(LstNationRequest lstNationRequest, Pageable pageable) {
        return lstNationRepository.search(pageable.getPageNumber(), pageable.getPageSize(), checkSortField(lstNationRequest.getSortField()), checkSortOrder(lstNationRequest.getSortOrder()), lstNationRequest.getNatiId(), lstNationRequest.getName());
    }

    @Override
    public String save(LstNationRequest req, String username) {
        return lstNationRepository.save(
                req.getAction(),
                req.getNatiId(),
                req.getName(),
                req.getRemark(),
                username);
    }

    @Override
    public String delete(String natiid) {
        return lstNationRepository.delete(natiid);
    }

    public String checkSortField(String SortField) {
        if (!Strings.isNullOrEmpty(SortField)) {
            return SortField;
        } else {
            return "natiId";
        }
    }

    public String checkSortOrder(String SortOrder) {
        if (!Strings.isNullOrEmpty(SortOrder)) {
            return SortOrder;
        } else {
            return "ASC";
        }
    }

    @Override
    public List<LstNationSearchDTO> getNation( String query) {
        return lstNationRepository.getNation(query);
    }
}
