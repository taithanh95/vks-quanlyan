package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstOfficeSearchDTO;

import com.bitsco.vks.entity.LstParty;
import com.bitsco.vks.models.LstOfficeRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstOfficeService {
    List<LstOfficeSearchDTO> search(LstOfficeRequest lstOfficeRequest, Pageable pageable);

    String insertUpdate(LstOfficeRequest req, String username);

    String delete(LstOfficeRequest req);
}
