package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstKnowledgeSearchDTO;

import java.util.List;

public interface LstKnowledgeRepository {
    List<LstKnowledgeSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String levelid, String levelname);

    String save(String action, String levelid, String levelname, String username);

    String delete(String levelid);
}
