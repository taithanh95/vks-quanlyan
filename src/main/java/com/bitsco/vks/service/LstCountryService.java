package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstCountrySearchDTO;
import com.bitsco.vks.dto.LstNationSearchDTO;
import com.bitsco.vks.models.LstCountryRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstCountryService {
    List<LstCountrySearchDTO> search(LstCountryRequest lstCountryRequest, Pageable pageable);

    String save(LstCountryRequest req, String username);

    String delete(String counid);

    List<LstCountrySearchDTO> getCountry(String query);
}
