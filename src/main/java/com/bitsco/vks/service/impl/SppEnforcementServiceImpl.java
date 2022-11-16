package com.bitsco.vks.service.impl;

import com.bitsco.vks.models.SppEnforceDeleteRequest;
import com.bitsco.vks.models.SppEnforceSaveRequest;
import com.bitsco.vks.repository.SppEnforcementRepository;
import com.bitsco.vks.service.SppEnforcementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SppEnforcementServiceImpl implements SppEnforcementService {

    @Autowired
    private SppEnforcementRepository sppEnforcementRepository;

    @Override
    public String save(SppEnforceSaveRequest req, String username) {
        return sppEnforcementRepository.save(req, username);
    }

    @Override
    public String delete(SppEnforceDeleteRequest req) {
        return sppEnforcementRepository.delete(req.casecode, req.regicode, req.accucode, req.transcode, req.action);
    }
}
