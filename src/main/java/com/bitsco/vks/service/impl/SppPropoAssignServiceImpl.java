package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.SppPropoAssignEntity;
import com.bitsco.vks.models.SppPropoAssignSaveRequest;
import com.bitsco.vks.repository.LstInspectorRepository;
import com.bitsco.vks.repository.SppPropoAssignRepository;
import com.bitsco.vks.service.SppPropoAssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SppPropoAssignServiceImpl implements SppPropoAssignService {
    @Autowired
    private SppPropoAssignRepository sppPropoAssignRepository;

    @Override
    public String insertUpdate(String action, SppPropoAssignSaveRequest request) {
        return sppPropoAssignRepository.insertUpdate(action, request.sppId, request.sppPropoAssign);
    }

    @Override
    public String delete(String inspcode, String regicode, String casecode) {
        return sppPropoAssignRepository.delete(inspcode, regicode, casecode);
    }
}
