package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstRangerSearchDTO;
import com.bitsco.vks.entity.LstRanger;

import java.util.List;

public interface LstRangerRepository {
    List<LstRangerSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String rangid, String name, String addr, String tel, String fax, String sppId);
    List<LstRanger> autocomplete(String query, Integer level, Integer limit);
    String insert(LstRanger ls, String userId);
    String update(LstRanger ls, String userId);
    String delete(LstRanger _spp);
    String getid(String sppid, Integer spplevel);
    List<LstRangerSearchDTO> getFnFindTreeData(String id, String level, String sppid);
    List<LstRangerSearchDTO> getRangerBySppId(String sppid);
}
