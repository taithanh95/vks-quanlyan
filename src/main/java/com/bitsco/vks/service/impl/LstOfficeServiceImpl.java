package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstOfficeSearchDTO;
import com.bitsco.vks.models.LstOfficeRequest;
import com.bitsco.vks.repository.LstOfficeRepository;
import com.bitsco.vks.repository.LstPartyRepository;
import com.bitsco.vks.service.LstOfficeService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LstOfficeServiceImpl implements LstOfficeService {

    @Autowired
    private LstOfficeRepository lstOfficeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstOfficeSearchDTO> search(LstOfficeRequest lstOfficeRequest, Pageable pageable) {
        return lstOfficeRepository.search(pageable.getPageNumber(), pageable.getPageSize(), checkSortField(lstOfficeRequest.getSortField()), checkSortOrder(lstOfficeRequest.getSortOrder()), lstOfficeRequest.getOfficeId(), lstOfficeRequest.getOfficeName(), lstOfficeRequest.getSetLevel());
    }
    public String checkSortField(String SortField) {
        if (!Strings.isNullOrEmpty(SortField)) {
            return SortField;
        } else {
            return "officeid";
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
    public String insertUpdate(LstOfficeRequest req, String username) {
        return lstOfficeRepository.insertUpdate(req, username);
    }

    @Override
    public String delete(LstOfficeRequest req) {
        return lstOfficeRepository.delete(req);
    }
}
