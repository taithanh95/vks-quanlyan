package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstAppealSearchDTO;
import com.bitsco.vks.models.LstAppealRequest;

import java.util.List;

public interface LstAppealRepository {
    List<LstAppealSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String appealid, String appealname);

    String save(LstAppealRequest req, String username);

    String delete(String appealid);
}
