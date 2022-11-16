package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.StatisticaRequestDTO;
import com.bitsco.vks.repository.LstStatisticaRepository;
import com.bitsco.vks.service.LstStatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

@Service
public class LstStatisticaServiceImpl implements LstStatisticaService {

    @Autowired
    private LstStatisticaRepository lstStatisticaRepository;

    @Override
    public List<LinkedCaseInsensitiveMap> getLst(Pageable page, StatisticaRequestDTO req) {
        return lstStatisticaRepository.getLst(page.getPageNumber(), page.getPageSize(), req);
    }

    @Override
    public String save(StatisticaRequestDTO req, String username) {
        return lstStatisticaRepository.save(req, username);
    }

    @Override
    public String delete(String statid) {
        return lstStatisticaRepository.delete(statid);
    }
}
