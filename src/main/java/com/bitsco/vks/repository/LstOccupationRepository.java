package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstNationSearchDTO;
import com.bitsco.vks.dto.LstOccupationSearchDTO;

import java.util.List;

public interface LstOccupationRepository {
    List<LstOccupationSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String occuId, String name, String branchJob);
    String insert(String action, String occuid, String name, String remark, String branchjob, String user);
    String delete(String occuid);

    List<LstOccupationSearchDTO> getOccupation(String query, Integer limit);
}
