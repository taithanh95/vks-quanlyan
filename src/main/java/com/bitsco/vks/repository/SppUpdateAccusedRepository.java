package com.bitsco.vks.repository;

import com.bitsco.vks.entity.LstInspector;
import com.bitsco.vks.entity.SppAccused;

import java.util.List;

public interface SppUpdateAccusedRepository {
    String insertDelete(List<SppAccused> sppAccusedsDeleted, List<SppAccused> sppAccusedsInserted, List<LstInspector> lstInspectorsDeleted
            , List<LstInspector> lstInspectorsInserted, String for_type);
}
