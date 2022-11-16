package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.StatisticcRequestDTO;
import com.bitsco.vks.repository.LstStatisticcRepository;
import com.bitsco.vks.service.LstStatisticcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

@Service
public class LstStatisticcServiceImpl implements LstStatisticcService {

    @Autowired
    private LstStatisticcRepository lstStatisticcRepository;

    @Override
    public List<LinkedCaseInsensitiveMap> getLst(Pageable page, StatisticcRequestDTO req) {
        return lstStatisticcRepository.getLst(page.getPageNumber(), page.getPageSize(), req);
    }

    @Override
    public String save(StatisticcRequestDTO req, String username) {
        return lstStatisticcRepository.save(req, username);
    }

    @Override
    public String delete(String statid) {
        return lstStatisticcRepository.delete(statid);
    }

}
