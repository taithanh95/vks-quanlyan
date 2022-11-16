package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstResolveSearchDTO;

import java.util.List;

public interface LstResolveRepository {
    List<LstResolveSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String resolid, String resolname, String state);

    String save(String action, String resolid, String resolname, String state, String username);

    String delete(String resolid);
}
