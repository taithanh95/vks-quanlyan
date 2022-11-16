package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstTransferSearchDTO;
import com.bitsco.vks.entity.LstSPP;
import com.bitsco.vks.models.*;
import com.bitsco.vks.repository.SppSppReveiceRepository;
import com.bitsco.vks.repository.SppSppSendRepository;
import com.bitsco.vks.service.SppSppReveiceService;
import com.bitsco.vks.service.SppSppSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

@Service
public class SppSppReveiceServiceImpl implements SppSppReveiceService {

    @Autowired
    SppSppReveiceRepository sppSppReveiceRepository;

    @Override
    public List<LinkedCaseInsensitiveMap> search(SppSppReveiceSearchRequest req) {
        return sppSppReveiceRepository.search(req.rowIndex, req.pageSize,req);
    }

    @Override
    public String update(SppSppReveiceSaveRequest req, String userid) {
        return sppSppReveiceRepository.update(req, userid);
    }

    @Override
    public List<LstTransferSearchDTO> getTransferByTransId(String transid) {
        return sppSppReveiceRepository.getTransferByTransId(transid);
    }
}
