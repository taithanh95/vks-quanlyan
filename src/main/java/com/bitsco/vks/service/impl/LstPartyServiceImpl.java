package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstPartySearchDTO;
import com.bitsco.vks.entity.LstParty;
import com.bitsco.vks.models.LstPartyRequest;
import com.bitsco.vks.repository.LstPartyRepository;
import com.bitsco.vks.service.LstPartyService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LstPartyServiceImpl implements LstPartyService {

    @Autowired
    private LstPartyRepository lstPartyRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstPartySearchDTO> search(LstPartyRequest lstPartyRequest, Pageable pageable) {
        return lstPartyRepository.search(pageable.getPageNumber(), pageable.getPageSize(), checkSortField(lstPartyRequest.getSortField()), checkSortOrder(lstPartyRequest.getSortOrder()), lstPartyRequest.getPartyId(), lstPartyRequest.getPartyName());
    }

    public String checkSortField(String SortField) {
        if (!Strings.isNullOrEmpty(SortField)) {
            return SortField;
        } else {
            return "partyid";
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
    public String insertUpdate(LstParty req, String username) {
        return lstPartyRepository.insertUpdate(req, username);
    }

    @Override
    public String delete(LstParty req) {
        return lstPartyRepository.delete(req);
    }
}
