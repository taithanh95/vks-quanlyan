package com.bitsco.vks.service;

import com.bitsco.vks.entity.LstDecisionEntity;
import com.bitsco.vks.entity.SppAccused;
import com.bitsco.vks.entity.SppDecision;
import com.bitsco.vks.models.SppAccusedSearchRequest;
import com.bitsco.vks.models.SppDecisionSearchRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppDecisionService {
    String insertUpdate(String action, SppDecision _obj, String userid, String sppid);
    String insertUpdateAcc(String action, SppDecision _obj, String userid, String sppid);
    List<SppDecision> search(SppDecisionSearchRequest request, Pageable pageable);
    List<LstDecisionEntity> searchDecitypeHS(String applyfor, String userfor);

    String delete(SppDecision decision);
    String deleteAcc(String decicode);
    List<LstDecisionEntity> search_gh(String usefor, String applyfor, String deciid);

    LinkedCaseInsensitiveMap getDeciDetail(String decicode);
}
