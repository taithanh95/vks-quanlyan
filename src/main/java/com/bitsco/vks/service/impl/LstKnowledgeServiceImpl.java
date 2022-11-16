package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstKnowledgeSearchDTO;
import com.bitsco.vks.models.LstKnowledgeRequest;
import com.bitsco.vks.repository.LstKnowledgeRepository;
import com.bitsco.vks.service.LstKnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LstKnowledgeServiceImpl implements LstKnowledgeService {
    @Autowired
    private LstKnowledgeRepository lstKnowledgeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstKnowledgeSearchDTO> search(LstKnowledgeRequest lstKnowledgeRequest, Pageable pageable) {
            return lstKnowledgeRepository.search(pageable.getPageNumber(),
                    pageable.getPageSize(),
                    lstKnowledgeRequest.getSortField(),
                    lstKnowledgeRequest.getSortOrder(),
                    lstKnowledgeRequest.getLevelid(),
                    lstKnowledgeRequest.getLevelname());
    }

    @Override
    public String save(LstKnowledgeRequest req, String username) {
        return lstKnowledgeRepository.save(req.getAction(), req.getLevelid(), req.getLevelname(), username);
    }

    @Override
    public String delete(String levelid) {
        return lstKnowledgeRepository.delete(levelid);
    }
}
