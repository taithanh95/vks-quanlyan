package com.bitsco.vks.service;

import com.bitsco.vks.dto.SppStatisticaDTO;
import com.bitsco.vks.entity.SppStaticcBegin;
import com.bitsco.vks.models.ProcessCaseStaticc;
import com.bitsco.vks.models.ProcessStaticcBeginRequest;
import com.bitsco.vks.models.SppStattisticaSaveRequest;

import java.util.List;

public interface SppStatisticaService {
    List<SppStatisticaDTO> search(String regicode, String centcode, String accucode, String lawcode, String userfor);
    List<SppStatisticaDTO> searchStaticcLawcodeUpdateInfo(String regicode, String centcode, String lawcode, String userfor);
    String insert(SppStattisticaSaveRequest req,String userid);
    String insertCaseStatis(ProcessCaseStaticc request, String userfor, String userid);
}
