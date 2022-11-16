package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstAgainstResultSearchDTO;

import java.util.List;

public interface LstAgainstResultRepository {
    List<LstAgainstResultSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String resultid, String resultname );

    String save(String action, String resultid, String resultname, String username);

    String delete(String resultid);
}
