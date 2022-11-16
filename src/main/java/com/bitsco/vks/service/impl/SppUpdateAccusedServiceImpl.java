package com.bitsco.vks.service.impl;

import com.bitsco.vks.models.SppUpdateAccusedInsertDeleteRequest;
import com.bitsco.vks.repository.SppUpdateAccusedRepository;
import com.bitsco.vks.service.SppUpdateAccusedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SppUpdateAccusedServiceImpl implements SppUpdateAccusedService {
    @Autowired
    private SppUpdateAccusedRepository sppUpdateAccusedRepository;

    @Override
    public String insertUpdate(SppUpdateAccusedInsertDeleteRequest request) {
        return sppUpdateAccusedRepository.insertDelete(request.sppAccusedsDeleted, request.sppAccusedsInserted, request.lstInspectorsDeleted
        , request.lstInspectorsInserted, request.for_type);
    }
}
