package com.bitsco.vks.repository;

import com.bitsco.vks.dto.SppStatisticaDTO;
import com.bitsco.vks.entity.SppStaticcBegin;
import com.bitsco.vks.models.SppStattisticaSaveRequest;

import java.util.List;

public interface SppStatisticaRepository {

    List<SppStatisticaDTO> search(String regicode, String centcode, String accucode, String lawcode, String userfor);

    List<SppStatisticaDTO> searchStaticcLawcodeUpdateInfo(String regicode, String centcode, String lawcode, String userfor);

    String insertUpdateInfo(SppStattisticaSaveRequest req, String userid);

    String insertCaseStatis(String regicode, String centcode, String lawcode, List<SppStaticcBegin> lstStaticcBegin, String userfor, String userid);
}
