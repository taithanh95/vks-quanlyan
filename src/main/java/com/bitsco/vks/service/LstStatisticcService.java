package com.bitsco.vks.service;

import com.bitsco.vks.dto.StatisticcRequestDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface LstStatisticcService {
    List<LinkedCaseInsensitiveMap> getLst(Pageable page, StatisticcRequestDTO req);

    String save(StatisticcRequestDTO req, String username);

    String delete(String statid);
}
