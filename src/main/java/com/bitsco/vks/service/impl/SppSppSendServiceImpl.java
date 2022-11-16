package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstTransferSearchDTO;
import com.bitsco.vks.entity.LstSPP;
import com.bitsco.vks.models.SppSppSendSaveRequest;
import com.bitsco.vks.models.SppSppSendSearchNameRequest;
import com.bitsco.vks.models.SppSppSendSearchRequest;
import com.bitsco.vks.repository.SppSppSendRepository;
import com.bitsco.vks.service.SppSppSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

@Service
public class SppSppSendServiceImpl implements SppSppSendService {

    @Autowired
    SppSppSendRepository sppSppSendRepository;

    @Override
    public List<LinkedCaseInsensitiveMap> search(SppSppSendSearchRequest req) {
        return sppSppSendRepository.search(req.rowIndex, req.pageSize, req);
    }

    @Override
    public List<LstSPP> getListSpp(SppSppSendSearchNameRequest req) {
        return sppSppSendRepository.getListSpp(req.transid, req.sppid, req.casecode, req.query, req.userfor);
    }

    @Override
    public String update(SppSppSendSaveRequest req, String userid) {
        return sppSppSendRepository.update(req, userid);
    }

    @Override
    public List<LstTransferSearchDTO> getListTransfer(String userforregis, String userfor, String sppid) {
        return sppSppSendRepository.getListTransfer(userforregis, userfor, sppid);
    }

    @Override
    public List<LinkedCaseInsensitiveMap> searchRequest(SppSppSendSearchRequest req) {
        return sppSppSendRepository.searchRequest(req.rowIndex, req.pageSize, req);
    }

    @Override
    public String insertRequest(String regicode, String centcode, String status, String sppid) {
        return sppSppSendRepository.insertRequest(regicode, centcode, status, sppid);
    }

    @Override
    public List<LstSPP> getListSppTinh(String req) {
        return sppSppSendRepository.getListSppTinh(req);
    }

    @Override
    public List<LstSPP> getListSppHuyen(String req) {
        return sppSppSendRepository.getListSppHuyen(req);
    }
}
