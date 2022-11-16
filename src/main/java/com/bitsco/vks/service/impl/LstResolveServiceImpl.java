package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstResolveSearchDTO;
import com.bitsco.vks.models.LstResolveRequest;
import com.bitsco.vks.repository.LstResolveRepository;
import com.bitsco.vks.service.LstResolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LstResolveServiceImpl implements LstResolveService {
    @Autowired
    private LstResolveRepository lstResolveRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstResolveSearchDTO> search(LstResolveRequest lstResolveRequest, Pageable pageable) {
        return lstResolveRepository.search(pageable.getPageNumber(),
                pageable.getPageSize(),
                lstResolveRequest.getSortField(),
                lstResolveRequest.getSortOrder(),
                lstResolveRequest.getResolid(),
                lstResolveRequest.getResolname(),
                lstResolveRequest.getState());
    }

    @Override
    public String save(LstResolveRequest req, String username) {
        return lstResolveRepository.save(
                req.getAction(),
                req.getResolid(),
                req.getResolname(),
                req.getState(),
                username);
    }

    @Override
    public String delete(String resolid) {
        return lstResolveRepository.delete(resolid);
    }
}
