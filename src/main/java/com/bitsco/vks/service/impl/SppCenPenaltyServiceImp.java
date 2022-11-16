package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.SppPenalty;
import com.bitsco.vks.models.SppCenPenaltySaveRequest;
import com.bitsco.vks.models.SppCenPenaltySaveResponse;
import com.bitsco.vks.models.SppCenPenalTotalSaveRequest;
import com.bitsco.vks.repository.SppCenPenaltyRepositoy;
import com.bitsco.vks.service.SppCenPenaltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SppCenPenaltyServiceImp implements SppCenPenaltyService {

    @Autowired
    public SppCenPenaltyRepositoy sppCenPenaltyRepositoy;

    @Override
    public List<SppPenalty> search(String centcode, String lawcode, String accucode, boolean isCheckspppenal) {
        return isCheckspppenal ? sppCenPenaltyRepositoy.searchPenaltySpp(centcode,lawcode,accucode)
                                : sppCenPenaltyRepositoy.searchPenalty(centcode,lawcode,accucode);
    }

    @Override
    public SppCenPenaltySaveResponse updateCenPenalty(SppCenPenaltySaveRequest req, String userid) {
        return req.isCheckspppenal()
                ? sppCenPenaltyRepositoy.insertUpdCenPenaltySpp(req.getRegicode(),userid,req.getAction(),req.getAccucode(), req.getCentcode(),req.getLawcode(), req.getListSppPenalty())
                : sppCenPenaltyRepositoy.insertUpdCenPenalty(req.getRegicode(),userid,req.getAction(),req.getAccucode(), req.getCentcode(),req.getLawcode(), req.getListSppPenalty());
    }

    @Override
    public String updateTotalCenPenalty(SppCenPenalTotalSaveRequest req, String userid) {
        return req.isCheckspppenal()
                ? sppCenPenaltyRepositoy.insUpdTotalCentPenalySpp(req.getAccucode(), req.getCentcode(), req.getRegicode(),userid)
                : sppCenPenaltyRepositoy.insUpdTotalCentPenaly(req.getAccucode(), req.getCentcode(), req.getRegicode(),userid);
    }
}
