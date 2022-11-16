package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstKnowledgeSearchDTO;
import com.bitsco.vks.models.LstKnowledgeRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstKnowledgeService {
    List<LstKnowledgeSearchDTO> search(LstKnowledgeRequest lstKnowledgeRequest, Pageable pageable);

    String save(LstKnowledgeRequest req, String username);

    String delete(String levelid);
}
