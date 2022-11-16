package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstTransferSearchDTO;
import com.bitsco.vks.models.LstTransferRequest;
import com.bitsco.vks.repository.LstTransferRepository;
import com.bitsco.vks.service.LstTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LstTransferServiceImpl implements LstTransferService {
    @Autowired
    private LstTransferRepository lstTransferRepository;

    @Override
    public List<LstTransferSearchDTO> search(LstTransferRequest lstTransferRequest, Pageable pageable) {
        return lstTransferRepository.search(pageable.getPageNumber(),
                pageable.getPageSize(),
                lstTransferRequest.getSortField(),
                lstTransferRequest.getSortOrder(),
                lstTransferRequest.getTransid(),
                lstTransferRequest.getTransname());
    }

    @Override
    public String save(LstTransferRequest req, String username) {
        return lstTransferRepository.save(
                req.getAction(),
                req.getTransid(),
                req.getTransname(),
                req.getFromto(),
                username);
    }

    @Override
    public String delete(String transid) {
        return lstTransferRepository.delete(transid);
    }
}
