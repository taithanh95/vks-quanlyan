package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.SppAppeal;
import com.bitsco.vks.models.SppAppealSaveRequest;
import com.bitsco.vks.models.SppAppealSaveResponse;
import com.bitsco.vks.models.SppAppealSearchCaseRequest;
import com.bitsco.vks.models.SppAppealSearchRequest;
import com.bitsco.vks.repository.SppAppealRepository;
import com.bitsco.vks.service.SppAppealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SppAppealServiceImpl implements SppAppealService {

    @Autowired
    private SppAppealRepository sppAppealRepository;

    @Override
    public List<SppAppeal> searchByRegicode(SppAppealSearchRequest request, Pageable pageable) {
        return sppAppealRepository.searchByRegicode(pageable.getPageNumber(), pageable.getPageSize(), request.sortField, request.sortOrder, request.regicode, request.userfor, request.sppid );
    }

    @Override
    public List<SppAppeal> searchByCase(SppAppealSearchCaseRequest request, Pageable pageable) {
        return sppAppealRepository.searchByCase(pageable.getPageNumber(), pageable.getPageSize(), request.sortField, request.sortOrder, request.casecode, request.userfor, request.sppid );
    }

    @Override
    public SppAppealSaveResponse insertUpdate(SppAppealSaveRequest request, String userid) {
        return sppAppealRepository.insertUpdate(request.action, request.sppAppeal, request.sppid, userid);
    }

    @Override
    public String delete(String code) {
        return sppAppealRepository.delete(code);
    }

    @Override
    public List<SppAppeal> lstAppeals(String query) {
        return sppAppealRepository.lstAppeals(query);
    }

    @Override
    public List<SppAppeal> getAppealAcc(String appecode) {
        return sppAppealRepository.getAppealAcc(appecode);
    }
}
