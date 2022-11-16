package com.bitsco.vks.service;

import com.bitsco.vks.models.SppEnforceDeleteRequest;
import com.bitsco.vks.models.SppEnforceSaveRequest;


public interface SppEnforcementService {
    String save(SppEnforceSaveRequest req, String username);

    String delete(SppEnforceDeleteRequest req);

}
