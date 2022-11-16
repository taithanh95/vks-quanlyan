package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.*;
import com.bitsco.vks.models.*;
import com.bitsco.vks.repository.SppCaseRepository;
import com.bitsco.vks.service.SppCaseService;
import com.bitsco.vks.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

@Service
public class SppCaseServiceImpl implements SppCaseService {
    @Autowired
    private SppCaseRepository sppCaseRepository;

    @Override
    public List<SppCase> doSearch(UpdateInfoRequest request) {
        if (request.accused == null)
            request.accused = new SppAccused();
        if (request.sppcase == null)
            request.sppcase = new SppCase();
        if (request.centence == null)
            request.centence = new SppCentence();
        if (request.register == null)
            request.register = new SppRegister();
        return sppCaseRepository.searchUpdateInfo1(request.sppId, request.rowIndex, request.pageSize, request.sortField, request.sortOrder, request.sppcase, request.accused, request.register, request.centence, request.sppcase.getUserfor());
    }

    @Override
    public String insert(SppCaseInsertRequest request) {
        return request.withWarn? sppCaseRepository.insertwithwarn(request.sppcase, request.isTachvu, request.sppId, request.userId) : sppCaseRepository.insert(request.sppcase, request.isTachvu, request.sppId, request.userId);
    }
    @Override
    public String update(SppCaseInsertRequest request) {
        return sppCaseRepository.updatewithwarn(request.sppcase, request.sppId, request.userId);
    }
    @Override
    public List<LinkedCaseInsensitiveMap> searchCaswlaw(UpdateInfoSearchRequest request, Pageable pageable) {
        return sppCaseRepository.searchCaswlaw(pageable.getPageNumber(), pageable.getPageSize(), request.sortField, request.sortOrder, request.casecode, request.userfor);
    }

    @Override
    public String getTransidByCase(String casecode, String usefor, String sppid) {
        return sppCaseRepository.getTransidByCase(casecode, usefor, sppid);
    }

    @Override
    public List<LstLaw> searchLawByCase(String casecode, String userfor) {
        return sppCaseRepository.searchLawByCase(casecode,userfor);
    }

    @Override
    public String updateCaselawcodewithwarn(UpdateCaseLawWithWarnRequest request, String userId) {
        return sppCaseRepository.updateCaselawcodewithwarn(request.sppCase, request.lstLaw, userId, request.sppId);
    }

    @Override
    public ProcessSppCaseResponse insertUpdateDeleteCaseLaw(ProcessCaseLawRequest request, String username) {
        return sppCaseRepository.insertUpdateDeleteCaseLaw(request.sppCase, request.action, request.lawCode, username, request.sppId,request.userfor);
    }

    @Override
    public ProcessSppCaseResponse deleteCaseLawUpdateInfo(ProcessCaseLawRequest request, String username) {
        return sppCaseRepository.deleteCaseLawUpdateInfo(request.sppCase, Constants.DML_DELETE, request.lawCode, username,request.userfor);
    }

    @Override
    public String delete(String casecode, String username) {
        return sppCaseRepository.delete(casecode, username);
    }

    @Override
    public List<SppStaticcBegin> searchCaseStatic(String casecode, String lawcode) {
        return sppCaseRepository.searchCaseStatic(casecode, lawcode);
    }

    @Override
    public List<CaseHeroin> searchHeroin(String casecode, String lawcode) {
        return sppCaseRepository.searchHeroin(casecode, lawcode);
    }

    @Override
    public List<CaseExhibit> searchExhibit(String casecode, String lawcode) {
        return sppCaseRepository.searchExhibit(casecode, lawcode);
    }

    @Override
    public String insertStaticcBegin(ProcessStaticcBeginRequest request, String userid) {
        return sppCaseRepository.insertStaticcBegin(request.casecode, request.lawcode, request.lstStaticcBegin, userid);
    }

    @Override
    public String insertCaseHeroin(ProcessCaseHeroinRequest request, String userid) {
        return sppCaseRepository.insertCaseHeroin(request.casecode, request.lawcode, request.heroin, userid);
    }

    @Override
    public String updateCaseHeroin(ProcessCaseHeroinRequest request, String userid) {
        return sppCaseRepository.updateCaseHeroin(request.casecode, request.lawcode, request.heroin, userid);
    }

    @Override
    public String insertCaseExhibit(ProcessCaseExhibitRequest request, String userid) {
        return sppCaseRepository.insertCaseExhibit(request.casecode, request.lawcode, request.lstCaseExhibit, userid);
    }

    @Override
    public List<SppInvestment> searchInvestment(String casecode) {
        return sppCaseRepository.searchInvestment(casecode);
    }

    @Override
    public LinkedCaseInsensitiveMap getSppCaseByCaseCode(String casecode) {
        return sppCaseRepository.getSppCaseByCasecode(casecode);
    }

    @Override
    public List<LinkedCaseInsensitiveMap> searchListCaseLaw(SppCaseLawSearchRequest req) {
        return sppCaseRepository.searchListCaseLaw(req.getCasecode(),req.getLaw(),
                req.pageindex,req.pagesize,req.getSortField(),req.getSortOrder());
    }

}
