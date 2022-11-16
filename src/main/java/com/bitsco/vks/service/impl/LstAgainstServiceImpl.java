package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstAgainstSearchDTO;
import com.bitsco.vks.models.LstAgainstRequest;
import com.bitsco.vks.repository.LstAgainstRepository;
import com.bitsco.vks.service.LstAgainstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LstAgainstServiceImpl implements LstAgainstService {
    @Autowired
    private LstAgainstRepository lstAgainstRepository;

    @Override
    public List<LstAgainstSearchDTO> search(LstAgainstRequest lstAgainstRequest, Pageable pageable) {
        return lstAgainstRepository.search(pageable.getPageNumber(),
                pageable.getPageSize(),
                lstAgainstRequest.getSortField(),
                lstAgainstRequest.getSortOrder(),
                lstAgainstRequest.getAgainstid(),
                lstAgainstRequest.getAgainstname(),
                lstAgainstRequest.getApplyfor(),
                lstAgainstRequest.getSetunit(),
                lstAgainstRequest.getThoihan_tu(),
                lstAgainstRequest.getThoihan_den());
    }

    @Override
    public String save(LstAgainstRequest req, String username) {
        return lstAgainstRepository.save(req,username);
    }

    @Override
    public String delete(String againstid) {
        return lstAgainstRepository.delete(againstid);
    }
}
