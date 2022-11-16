package com.bitsco.vks.repository;

import com.bitsco.vks.entity.SppPropoAssignEntity;

public interface SppPropoAssignRepository {
    String insertUpdate(String action, String sppId, SppPropoAssignEntity bean);
    String delete(String inspcode, String regicode, String casecode);
}
