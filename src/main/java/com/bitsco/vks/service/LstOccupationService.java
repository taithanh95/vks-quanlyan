package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstNationSearchDTO;
import com.bitsco.vks.dto.LstOccupationSearchDTO;
import com.bitsco.vks.models.LstOccupationRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstOccupationService {
    List<LstOccupationSearchDTO> search(LstOccupationRequest lstOccupationRequest, Pageable pageable);
    String insert(LstOccupationRequest req, String username);
    String delete(String occuid);

    List<LstOccupationSearchDTO> getOccupation(String query);
}
