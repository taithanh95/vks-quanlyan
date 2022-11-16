package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstPartySearchDTO;
import com.bitsco.vks.entity.LstParty;
import com.bitsco.vks.models.LstPartyRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstPartyService {
    List<LstPartySearchDTO> search(LstPartyRequest lstPartyRequest, Pageable pageable);

    String insertUpdate(LstParty req, String username);

    String delete(LstParty req);
}
