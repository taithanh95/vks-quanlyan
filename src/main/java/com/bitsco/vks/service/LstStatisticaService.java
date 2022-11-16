package com.bitsco.vks.service;

import com.bitsco.vks.dto.StatisticaRequestDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface LstStatisticaService {
    List<LinkedCaseInsensitiveMap> getLst(Pageable page, StatisticaRequestDTO req);

    String save(StatisticaRequestDTO req, String username);

    String delete(String statid);
}
