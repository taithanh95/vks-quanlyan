package com.bitsco.vks.repository;

import com.bitsco.vks.entity.SppPenalty;
import com.bitsco.vks.models.SppJudgementSaveResponse;

import java.util.List;

public interface SppJudgementRepository {
    List<SppPenalty> searchPenalty(String regicode, String centcode, String accucode);

    List<SppPenalty> searchPenatltySPP(String regicode, String centcode, String accucode);

    SppJudgementSaveResponse insertUpdJudgementSpp(String regicode, String userId, String action, String accucode, String centcode, List<SppPenalty> list);

    SppJudgementSaveResponse insertUpdJudgement(String regicode, String userId, String action, String accucode, String centcode,List<SppPenalty> list);


}
