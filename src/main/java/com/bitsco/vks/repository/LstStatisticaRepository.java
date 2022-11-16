package com.bitsco.vks.repository;

import com.bitsco.vks.dto.StatisticaRequestDTO;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface LstStatisticaRepository {

    List<LinkedCaseInsensitiveMap> getLst(int rowIndex, int pageSize, StatisticaRequestDTO req);

    String save(StatisticaRequestDTO req, String username);

    String delete(String statid);
}
