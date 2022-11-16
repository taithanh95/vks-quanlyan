package com.bitsco.vks.repository;

import com.bitsco.vks.entity.SppPenalty;
import com.bitsco.vks.models.SppCenPenaltySaveResponse;

import java.util.List;


public interface SppCenPenaltyRepositoy {
    List<SppPenalty> searchPenalty(String centcode, String lawcode, String accucode);

    List<SppPenalty> searchPenaltySpp(String centcode, String lawcode, String accucode);

    SppCenPenaltySaveResponse insertUpdCenPenalty(String regicode, String userId, String action, String accucode, String centcode, String lawcode, List<SppPenalty> list);

    SppCenPenaltySaveResponse insertUpdCenPenaltySpp(String regicode, String userId, String action, String accucode, String centcode, String lawcode, List<SppPenalty> list);

    String insUpdTotalCentPenaly(String accucode, String centcode, String regicode,String userId);

    String insUpdTotalCentPenalySpp(String accucode, String centcode, String regicode,String userId);
}
