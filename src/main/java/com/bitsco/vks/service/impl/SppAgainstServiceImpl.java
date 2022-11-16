package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.SppAgainstDTO;
import com.bitsco.vks.entity.SppAgainst;
import com.bitsco.vks.models.*;
import com.bitsco.vks.repository.SppAgainstRepository;
import com.bitsco.vks.repository.SppDecisionRepository;
import com.bitsco.vks.service.SppAgainstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

@Service
public class SppAgainstServiceImpl implements SppAgainstService {
    @Autowired
    private SppAgainstRepository repository;

    @Autowired
    private SppDecisionRepository sppDecisionRepository;

    @Override
    public List<SppAgainst> searchByRegicode(SppAgainstSearchRegiRequest request, Pageable pageable) {
        return repository.searchByRegicode(pageable.getPageNumber(), pageable.getPageSize(), request.sortField, request.sortOrder, request.regicode, request.userfor, request.sppid);
    }

    @Override
    public List<SppAgainst> searchcase(SppAgainstSearchCaseRequest request, Pageable pageable) {
        return repository.searchcase(pageable.getPageNumber(), pageable.getPageSize(), request.sortField, request.sortOrder, request.casecode, request.userfor, request.sppid);
    }

    @Override
    public SppAgainstSaveResponse insertUpdate(SppAgainstSaveRequest request, String userid) {
        return repository.insertUpdate(request.action, request.sppAgainst, userid);
    }

    @Override
    public String delete(SppAgainstDeleteRequest request) {
        return repository.delete(request.sppAgainst, request.sppid);
    }

    @Override
    public List<SppAgainst> loadLstAgainsts(String id) {
        return repository.loadLstAgainsts(id);
    }

    @Override
    public List<SppAgainst> loadLstAgainstResult(String id) {
        return repository.loadLstAgainstResult(id);
    }

    @Override
    public List<SppAgainst> getAgacase(String againstcode) {
        return repository.getAgacase(againstcode);
    }

    @Override
    public List<LinkedCaseInsensitiveMap> isCheckTrans(String regicode) {
        return sppDecisionRepository.isCheckTrans(regicode);
    }

    @Override
    public Integer isCheckDisable(String regicode) {
        return repository.isCheckDisable(regicode);
    }

    @Override
    public List<SppAgainstDTO> searchForUpdateResult(SppAgainstSearchCaseRequest request, Pageable pageable) {
        return repository.searchForUpdateResult(pageable.getPageNumber(), pageable.getPageSize(), request.sortField, request.sortOrder, request.casecode, request.sppid);
    }

    @Override
    public SppAgainstSaveResponse updateResult(SppAgainstSaveRequest request, String userid) {
        return repository.updateResult(request.action, request.sppAgainst, userid);
    }
}
