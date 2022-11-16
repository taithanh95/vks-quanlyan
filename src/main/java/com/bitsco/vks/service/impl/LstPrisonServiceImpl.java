package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstPrisonSearchDTO;
import com.bitsco.vks.entity.LstPrison;
import com.bitsco.vks.models.LstPrisonRequest;
import com.bitsco.vks.repository.LstPrisonRepository;
import com.bitsco.vks.service.LstPrisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LstPrisonServiceImpl implements LstPrisonService {
    @Autowired
    private LstPrisonRepository lstPrisonRepository;

    @Override
    public List<LstPrisonSearchDTO> search(LstPrisonRequest lstPrisonRequest, Pageable pageable) {
        return lstPrisonRepository.search(pageable.getPageNumber(), pageable.getPageSize(), lstPrisonRequest.getSortField(), lstPrisonRequest.getSortOrder(), lstPrisonRequest.getPrisonid(), lstPrisonRequest.getName(), lstPrisonRequest.getAddr(), lstPrisonRequest.getPtype(), lstPrisonRequest.getSppid()
        );
    }

    @Override
    public String insertUpdate(LstPrison req, String username) {
        return lstPrisonRepository.insertUpdate(req, username);
    }
    @Override
    public String delete(LstPrison req) {
        return lstPrisonRepository.delete(req);
    }
}
