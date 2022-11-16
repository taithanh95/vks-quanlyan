package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstDecitypeSearchDTO;
import com.bitsco.vks.entity.LstDecitype;
import com.bitsco.vks.models.LstDecitypeRequest;
import com.bitsco.vks.repository.LstDecitypeRepository;
import com.bitsco.vks.repository.LstLocationRepository;
import com.bitsco.vks.service.LstDecitypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LstDecitypeServiceImpl implements LstDecitypeService {
    @Autowired
    private LstDecitypeRepository lstDecitypeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstDecitypeSearchDTO> search(LstDecitypeRequest lstDecitypeRequest, Pageable pageable) {
        return lstDecitypeRepository.search(pageable.getPageNumber(), pageable.getPageSize(), lstDecitypeRequest.getSortField(), lstDecitypeRequest.getSortOrder(), lstDecitypeRequest.getDecitypeId(), lstDecitypeRequest.getName());
    }

    @Override
    public List<LstDecitype> searchDecitypeAccu(String usefor) {
        return lstDecitypeRepository.searchDecitypeAccu(usefor);
    }

    @Override
    public String save(LstDecitypeRequest req, String username) {
        return lstDecitypeRepository.save(
                req.getAction(),
                req.getDecitypeId(),
                req.getName(),
                username);
    }

    @Override
    public String delete(String decitypeid) {
        return lstDecitypeRepository.delete(decitypeid);
    }

    @Override
    public List<LstDecitype> getLst() {
        return lstDecitypeRepository.getLstDecitype();
    }
}
