package com.bitsco.vks.repository;

import com.bitsco.vks.dto.StatisticcRequestDTO;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface LstStatisticcRepository {

    List<LinkedCaseInsensitiveMap> getLst(int rowIndex, int pageSize, StatisticcRequestDTO req);

    String save(StatisticcRequestDTO req, String username);

    String delete(String statid);
}
