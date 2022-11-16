package com.bitsco.vks.service;

import com.bitsco.vks.entity.SppPenalty;
import com.bitsco.vks.models.SppCenPenaltySaveRequest;
import com.bitsco.vks.models.SppCenPenaltySaveResponse;
import com.bitsco.vks.models.SppCenPenalTotalSaveRequest;

import java.util.List;

public interface SppCenPenaltyService {
    List<SppPenalty> search(String centcode, String lawcode, String accucode,boolean isCheckspppenal);

    SppCenPenaltySaveResponse updateCenPenalty(SppCenPenaltySaveRequest req, String userid);

    String updateTotalCenPenalty(SppCenPenalTotalSaveRequest req, String userid);
}
