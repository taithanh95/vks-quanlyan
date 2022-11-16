package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstLocationSearchDTO;
import com.bitsco.vks.entity.LstBorderGuards;
import com.bitsco.vks.entity.LstLocation;

import java.util.List;

public interface LstLocationRepository {
    List<LstLocationSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String locaid, String name, String remark, String sppid);
    List<LstLocation> autocomplete(String query, Integer level, Integer limit);
    LstLocation getLocationById(String id);
    String insert(LstLocation ls, String userId);
    String update(LstLocation ls, String userId);
    String delete(LstLocation _spp);
    String getid(String locaid, Integer localevel);

    List<LstLocationSearchDTO> getFnFindTreeData(String locaid, String localevel, String sppid);
}
