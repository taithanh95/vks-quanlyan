package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstCountrySearchDTO;
import com.bitsco.vks.dto.LstNationSearchDTO;

import java.util.List;

public interface LstCountryRepository {
    List<LstCountrySearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String counId, String counName, String remark);

    String save(String action, String counid, String counname, String remark, String username);

    String delete(String counid);

    List<LstCountrySearchDTO> getCountry(String query);
}
