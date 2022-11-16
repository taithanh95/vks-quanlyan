package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstPolSearchDTO;
import com.bitsco.vks.entity.LstPol;
import com.bitsco.vks.models.LstPolRequest;
import com.bitsco.vks.repository.LstPolRepository;
import com.bitsco.vks.service.LstPolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LstPolServiceImpl implements LstPolService {
    @Autowired
    private LstPolRepository lstPolRepository;

    @Override
    public List<LstPolSearchDTO> search(LstPolRequest lstPolRequest, Pageable pageable) {
        return lstPolRepository.search(pageable.getPageNumber(), pageable.getPageSize(), lstPolRequest.getSortField(), lstPolRequest.getSortOrder(), lstPolRequest.getPolId(), lstPolRequest.getName(), lstPolRequest.getAddr(), lstPolRequest.getDirector()
        );
    }

    @Override
    public List<LstPolSearchDTO> getAll() {
        return lstPolRepository.getAll();
    }
    @Override
    public String insertUpdate(LstPol req, String username) {
        return lstPolRepository.insertUpdate(req, username);
    }
    @Override
    public String delete(LstPol req) {
        return lstPolRepository.delete(req);
    }
}
