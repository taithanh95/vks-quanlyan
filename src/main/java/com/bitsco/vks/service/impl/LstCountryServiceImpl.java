package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstCountrySearchDTO;
import com.bitsco.vks.dto.LstNationSearchDTO;
import com.bitsco.vks.models.LstCountryRequest;
import com.bitsco.vks.repository.LstCountryRepository;
import com.bitsco.vks.service.LstCountryService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LstCountryServiceImpl implements LstCountryService {
    @Autowired
    private LstCountryRepository lstCountryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstCountrySearchDTO> search(LstCountryRequest lstCountryRequest, Pageable pageable) {
        return lstCountryRepository.search(pageable.getPageNumber(), pageable.getPageSize(),
                checkSortField(lstCountryRequest.getSortField()), checkSortOrder(lstCountryRequest.getSortOrder()),
                lstCountryRequest.getCounId(),lstCountryRequest.getCounName(),lstCountryRequest.getRemark());
    }

    @Override
    public String save(LstCountryRequest req, String username) {
        return lstCountryRepository.save(
                req.getAction(),
                req.getCounId(),
                req.getCounName(),
                req.getRemark(),
                username);
    }

    @Override
    public String delete(String counid) {
        return lstCountryRepository.delete(counid);
    }

    public String checkSortField(String SortField) {
        if (!Strings.isNullOrEmpty(SortField)) {
            return SortField;
        } else {
            return "counid";
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
    public List<LstCountrySearchDTO> getCountry(String query) {

        return lstCountryRepository.getCountry(query);
    }
}
