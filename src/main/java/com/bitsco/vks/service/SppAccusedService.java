package com.bitsco.vks.service;

import com.bitsco.vks.entity.LstCode;
import com.bitsco.vks.entity.LstLaw;
import com.bitsco.vks.entity.LstLawGroup;
import com.bitsco.vks.entity.SppAccused;
import com.bitsco.vks.models.LstLawSearchRequest;
import com.bitsco.vks.models.SppAccusedSaveRequest;
import com.bitsco.vks.models.SppAccusedSearchRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SppAccusedService {
    List<SppAccused> search_bc(SppAccusedSearchRequest request, Pageable pageable);
    String save(SppAccusedSaveRequest request, String userId);
    String delete(String code);
    List<LstLaw> findLawcodeByAccused(String accucode);
    List<LstLaw> searchLaw(LstLawSearchRequest request, Pageable pageable);
    List<LstCode> getLstCode(String codeid);
    List<LstLawGroup> getLstLawGroup(String codeid);
    List<String> findCaseCodeByArresteenId(String arresteeId);
}
