package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstConclusionAutoCompleteDTO;
import com.bitsco.vks.dto.LstConclusionSearchDTO;
import com.bitsco.vks.models.LstConclusionRequest;
import com.bitsco.vks.repository.LstConclusionRepository;
import com.bitsco.vks.service.LstConclusionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LstConclusionServiceImpl implements LstConclusionService {
    @Autowired
    private LstConclusionRepository lstConclusionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstConclusionSearchDTO> search(LstConclusionRequest lstConclusionRequest, Pageable pageable) {
        return lstConclusionRepository.search(pageable.getPageNumber(),
                pageable.getPageSize(),
                lstConclusionRequest.getSortField(),
                lstConclusionRequest.getSortOrder(),
                lstConclusionRequest.getConcid(),
                lstConclusionRequest.getConcname(),
                lstConclusionRequest.getUserfor(),
                lstConclusionRequest.getStatus());
    }

    @Override
    public List<LstConclusionAutoCompleteDTO> autocomplete(String query, String usefor) {
        return lstConclusionRepository.autocomplete(query,usefor);
    }

    @Override
    public LstConclusionSearchDTO getConclu(String concid) {
        return lstConclusionRepository.getConclu(concid);
    }

    @Override
    public String save(LstConclusionRequest req, String username) {
        return lstConclusionRepository.save(
                req.getAction(),
                req.getConcid(),
                req.getConcname(),
                req.getUserfor(),
                req.getStatus(),
                username);
    }

    @Override
    public String delete(String concid) {
        return lstConclusionRepository.delete(concid);
    }
}
