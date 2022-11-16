package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstSPCSearchDTO;
import com.bitsco.vks.entity.LstSPC;
import com.bitsco.vks.entity.LstSPP;
import com.bitsco.vks.models.LstSPCRequest;
import com.bitsco.vks.repository.LstSPCRepository;
import com.bitsco.vks.service.LstSPCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class LstSPCServiceImpl implements LstSPCService {
    @Autowired
    private LstSPCRepository lstSPCRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstSPCSearchDTO> search(LstSPCRequest lstSPCRequest,
                                        Pageable pageable) {
        return lstSPCRepository.search(pageable.getPageNumber(),
                pageable.getPageSize(),
                lstSPCRequest.getSortField(),
                lstSPCRequest.getSortOrder(),
                lstSPCRequest.getSpcId(),
                lstSPCRequest.getName(),
                lstSPCRequest.getAddr(),
                lstSPCRequest.getSppId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<LstSPC> autocomplete(String query) {
        return lstSPCRepository.autocomplete(query, null, 10);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LstSPC> getFromSpp(String spcid) {
        return lstSPCRepository.getFromSpp(spcid);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LstSPC> getFromSpp2022(String spcid) {
        return lstSPCRepository.getFromSpp2022(spcid);
    }

    @Override
    public String insert(LstSPC req, String username) {
        return lstSPCRepository.insert(req, username);
    }

    @Override
    public String update(LstSPC req, String username) {
        return lstSPCRepository.update(req, username);
    }

    @Override
    public String getid(String spcid, Integer spclevel) {
        return lstSPCRepository.getid(spcid, spclevel);
    }

    @Override
    public String delete(LstSPC req) {
        return lstSPCRepository.delete(req);
    }

    @Override
    public List<LstSPC> getListSpc(String query) {
        return lstSPCRepository.getListSpc(query);
    }

    @Override
    public List<LstSPCSearchDTO> getFnFindTreeData(String sppcode, String level, String sppid) {
        return lstSPCRepository.getFnFindTreeData(sppcode,level,sppid);
    }
}
