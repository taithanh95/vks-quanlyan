package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstNationSearchDTO;

import java.util.List;

public interface LstNationRepository {
    List<LstNationSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String natiId, String name);

    String save(String action, String natiid, String name, String remark, String username);

    String delete(String natiid);

    List<LstNationSearchDTO> getNation(String query);
}

