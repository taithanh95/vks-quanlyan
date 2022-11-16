package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstConclusionAutoCompleteDTO;
import com.bitsco.vks.dto.LstConclusionSearchDTO;

import java.util.List;

public interface LstConclusionRepository {
    List<LstConclusionSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String concid, String concname, String userfor, String status);

    List<LstConclusionAutoCompleteDTO> autocomplete (String query, String userfor);

    LstConclusionSearchDTO getConclu (String concid);

    String save(String action, String concid, String concname, String userfor, String status, String username);

    String delete(String concid);
}
