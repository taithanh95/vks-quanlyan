package com.bitsco.vks.service;

import com.bitsco.vks.entity.SppPropoAssignEntity;
import com.bitsco.vks.models.SppPropoAssignSaveRequest;

public interface SppPropoAssignService {
    String insertUpdate(String action, SppPropoAssignSaveRequest request);
    String delete(String inspcode, String regicode, String casecode);
}
