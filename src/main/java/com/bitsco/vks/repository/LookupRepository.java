package com.bitsco.vks.repository;

import com.bitsco.vks.entity.*;
import com.bitsco.vks.models.LookupRequest;

import java.util.List;

public interface LookupRepository {
    List<SppRegister> searchRegister(LookupRequest request);

    List<SppRegister> lookupRegister(String casecode);

    List<SppDecision> searchDecision(LookupRequest request);

    List<SppDecision> lookupDecision(LookupRequest request);

    List<SppAgainst> searchAgainst(LookupRequest request);

    List<SppAgainst> lookupAgainst(LookupRequest request);

    List<SppAppeal> searchAppeal(LookupRequest request);

    List<SppAppeal> lookupAppeal(LookupRequest request);

    List<SppAccused> searchAccused(LookupRequest request);

    List<SppAccused> lookupAccused(LookupRequest request);

    List<LstLaw> searchLaw(LookupRequest request) throws Exception;

    List<LstInspector> lookupInspector(LookupRequest request) throws Exception;

    List<SppPenalty> searchPenalty(LookupRequest request);

    List<SppSpcPol> searchTransfer(LookupRequest request);

    List<SppCentence> lookupCentence(LookupRequest request) throws Exception;

    List<SppCentence> listCentence(LookupRequest request) throws Exception;

    List<SppSpcPol> lookupTransfer(LookupRequest request);

    List<LstLaw> listCentLaw(LookupRequest request) throws Exception;

    List<SppStatistica> listStatistica(LookupRequest request) throws Exception;

    List<SppStatisticc> listStatisticc(LookupRequest request) throws Exception;
}
