package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstNationSearchDTO;
import com.bitsco.vks.models.LstNationRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstNationService {
    List<LstNationSearchDTO> search(LstNationRequest lstNationRequest, Pageable pageable);

    String save(LstNationRequest req, String username);

    String delete(String natiid);

    List<LstNationSearchDTO> getNation(String query);
}
