package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.LstSigner;
import com.bitsco.vks.repository.LstSignerRepository;
import com.bitsco.vks.service.LstSignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LstSignerServiceImpl implements LstSignerService {
    @Autowired
    private LstSignerRepository lstSignerRepository;

    @Override
    public List<LstSigner> autocomplete(String query, String polid, String officeid, String sppid, int limit) {
        return lstSignerRepository.autocomplete(query, polid, officeid, sppid, limit);
    }
}
