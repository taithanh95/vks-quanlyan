package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstBorderGuardsSearchDTO;
import com.bitsco.vks.entity.LstBorderGuards;

import java.util.List;

public interface LstBorderGuardsRepository {
    List<LstBorderGuardsSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String sppId, String name, String addr, String tel, String fax);
    String insert(LstBorderGuards ls, String userId);
    String update(LstBorderGuards ls, String userId);
    String delete(LstBorderGuards _spp);
    List<LstBorderGuards> autocomplete(String query, int level, int limit);
    String getid(String sppid, Integer spplevel);
    List<LstBorderGuardsSearchDTO> getFnFindTreeData(String id, String level, String sppid);
    List<LstBorderGuardsSearchDTO> getBorderGuardsBySppId(String sppid);
}
