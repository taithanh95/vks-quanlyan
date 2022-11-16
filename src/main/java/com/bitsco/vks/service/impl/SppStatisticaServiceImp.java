package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.SppStatisticaDTO;
import com.bitsco.vks.models.ProcessCaseStaticc;
import com.bitsco.vks.models.SppStattisticaSaveRequest;
import com.bitsco.vks.repository.SppStatisticaRepository;
import com.bitsco.vks.service.SppStatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SppStatisticaServiceImp implements SppStatisticaService {

    @Autowired
    public SppStatisticaRepository sppStatisticaRepository;

    @Override
    public List<SppStatisticaDTO> search(String regicode, String centcode, String accucode, String lawcode, String userfor) {
        return sppStatisticaRepository.search(regicode, centcode, accucode, lawcode, userfor);
    }

    @Override
    public String insert(SppStattisticaSaveRequest req, String userid) {
        return sppStatisticaRepository.insertUpdateInfo(req, userid);
    }

    @Override
    public String insertCaseStatis(ProcessCaseStaticc request, String userfor, String userid) {
        return sppStatisticaRepository.insertCaseStatis(request.regicode, request.centcode, request.lawcode, request.lstStaticcBegin, userfor, userid);
    }

    @Override
    public List<SppStatisticaDTO> searchStaticcLawcodeUpdateInfo(String regicode, String centcode, String lawcode, String userfor) {
        return sppStatisticaRepository.searchStaticcLawcodeUpdateInfo(regicode, centcode, lawcode, userfor);
    }
}
