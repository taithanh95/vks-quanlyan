package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstReligionSearchDTO;
import com.bitsco.vks.models.LstReligionRequest;
import com.bitsco.vks.repository.LstReligionRepository;
import com.bitsco.vks.service.LstReligionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LstReligionServiceImpl implements LstReligionService {

    @Autowired
    private LstReligionRepository lstReligionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstReligionSearchDTO> search(LstReligionRequest lstReligionRequest, Pageable pageable) {
        return lstReligionRepository.search(pageable.getPageNumber(), pageable.getPageSize(), lstReligionRequest.getSortField(), lstReligionRequest.getSortOrder(), lstReligionRequest.getId(),lstReligionRequest.getName(),lstReligionRequest.getNote());
    }

    @Override
    public String save(LstReligionRequest req, String username) {
        return lstReligionRepository.save(
                req.getAction(),
                req.getReligionid(),
                req.getReligionname(),
                req.getReligionnote(),
                username);
    }

    @Override
    public String delete(String religionid) {
        return lstReligionRepository.delete(religionid);
    }
}

