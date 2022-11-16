package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstPartySearchDTO;
import com.bitsco.vks.entity.LstParty;
import com.bitsco.vks.models.LstInspectorSearchRequest;
import com.bitsco.vks.models.LstPartyRequest;

import java.util.List;

public interface LstPartyRepository {
    List<LstPartySearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String partyId,String partyName);

    String insertUpdate(LstParty req, String username);

    String delete(LstParty req);
}
