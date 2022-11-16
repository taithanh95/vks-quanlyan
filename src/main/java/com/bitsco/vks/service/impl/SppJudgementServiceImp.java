package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.SppPenalty;
import com.bitsco.vks.models.SppJudgementSaveRequest;
import com.bitsco.vks.models.SppJudgementSaveResponse;
import com.bitsco.vks.repository.SppJudgementRepository;
import com.bitsco.vks.service.SppJudgementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SppJudgementServiceImp implements SppJudgementService {

    @Autowired
    private SppJudgementRepository sppJudgementRepository;

    @Override
    public List<SppPenalty> search(String regicode, String centcode, String accucode, boolean isCheckSppPenal) {
        return isCheckSppPenal ? sppJudgementRepository.searchPenatltySPP(regicode,centcode,accucode)
                        : sppJudgementRepository.searchPenalty(regicode,centcode,accucode);
    }

    @Override
    public SppJudgementSaveResponse updateJudgement(SppJudgementSaveRequest req, String userid) {
        return req.isCheckspppenal()
                ? sppJudgementRepository.insertUpdJudgementSpp(req.getRegicode(),userid,req.getAction(),req.getAccucode(), req.getCentcode(), req.getListSppPenalty())
                : sppJudgementRepository.insertUpdJudgement(req.getRegicode(),userid,req.getAction(),req.getAccucode(), req.getCentcode(), req.getListSppPenalty());
    }
}
