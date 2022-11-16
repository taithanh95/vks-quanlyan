package com.bitsco.vks.service;

import com.bitsco.vks.entity.SppPenalty;
import com.bitsco.vks.models.SppJudgementSaveRequest;
import com.bitsco.vks.models.SppJudgementSaveResponse;

import java.util.List;

public interface SppJudgementService {
    List<SppPenalty> search(String regicode, String centcode, String accucode, boolean isCheckSppPenal);

    SppJudgementSaveResponse updateJudgement(SppJudgementSaveRequest req, String userid);
}
