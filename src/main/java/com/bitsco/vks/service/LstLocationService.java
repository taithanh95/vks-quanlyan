package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstLocationSearchDTO;
import com.bitsco.vks.entity.LstLocation;
import com.bitsco.vks.models.LstLocationRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface LstLocationService {
    List<LstLocationSearchDTO> search(LstLocationRequest lstLocationRequest, Pageable pageable);
    List<LstLocation> autocomplete(String query);
    List<LstLocation> autocomplete2(String query, Integer level);
    LstLocation getLocationById(String id);
    String insert(LstLocation ls);
    String update(LstLocation ls);
    String delete(LstLocation _spp);
    String getid(String locaid,Integer localevel);

    List<LstLocationSearchDTO> getFnFindTreeData(String locaid, String localevel, String sppid);
}
