package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.*;
import com.bitsco.vks.models.LookupRequest;
import com.bitsco.vks.repository.LookupRepository;
import com.bitsco.vks.service.LookupService;
import com.bitsco.vks.utils.ArrayListCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LookupServiceImpl implements LookupService {
    @Autowired
    private LookupRepository lookupRepository;

    @Override
    public List<SppRegister> searchRegister(LookupRequest request) {
        return lookupRepository.searchRegister(request);
    }

    @Override
    public List<SppRegister> lookupRegister(String casecode) {
        List<SppRegister> lst = new ArrayList<>();
        lst = lookupRepository.lookupRegister(casecode);
        if (!ArrayListCommon.isNullOrEmpty(lst)) {
            Collections.reverse(lst);
        }
        return lst;
    }

    @Override
    public List<SppDecision> searchDecision(LookupRequest request) {
        return lookupRepository.searchDecision(request);
    }

    @Override
    public List<SppDecision> lookupDecision(LookupRequest request) {
        return lookupRepository.lookupDecision(request);
    }

    @Override
    public List<SppAgainst> searchAgainst(LookupRequest request) {
        return lookupRepository.searchAgainst(request);
    }

    @Override
    public List<SppAgainst> lookupAgainst(LookupRequest request) {
        return lookupRepository.lookupAgainst(request);
    }

    @Override
    public List<SppAppeal> searchAppeal(LookupRequest request) {
        return lookupRepository.searchAppeal(request);
    }

    @Override
    public List<SppAppeal> lookupAppeal(LookupRequest request) {
        return lookupRepository.lookupAppeal(request);
    }

    @Override
    public List<SppAccused> searchAccused(LookupRequest request) {
        return lookupRepository.searchAccused(request);
    }

    @Override
    public List<SppAccused> lookupAccused(LookupRequest request) {
        return lookupRepository.lookupAccused(request);
    }

    @Override
    public List<LstLaw> searchLaw(LookupRequest request) throws Exception {
        return lookupRepository.searchLaw(request);
    }

    @Override
    public List<LstInspector> lookupInspector(LookupRequest request) throws Exception {
        return lookupRepository.lookupInspector(request);
    }

    public List<SppPenalty> searchPenalty(LookupRequest request) {
        return lookupRepository.searchPenalty(request);
    }

    @Override
    public List<SppSpcPol> searchTransfer(LookupRequest request) {
        return lookupRepository.searchTransfer(request);
    }

    public List<SppCentence> lookupCentence(LookupRequest request) throws Exception {
        return lookupRepository.lookupCentence(request);
    }

    @Override
    public List<SppCentence> listCentence(LookupRequest request) throws Exception {
        return lookupRepository.listCentence(request);
    }

    @Override
    public List<SppSpcPol> lookupTransfer(LookupRequest request) {
        return lookupRepository.lookupTransfer(request);
    }

    @Override
    public List<LstLaw> listCentLaw(LookupRequest request) throws Exception {
        return lookupRepository.listCentLaw(request);
    }

    @Override
    public List<SppStatistica> listStatistica(LookupRequest request) throws Exception {
        return lookupRepository.listStatistica(request);
    }

    @Override
    public List<SppStatisticc> listStatisticc(LookupRequest request) throws Exception {
        return lookupRepository.listStatisticc(request);
    }
}
