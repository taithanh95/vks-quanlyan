package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstRangerSearchDTO;
import com.bitsco.vks.entity.LstRanger;
import com.bitsco.vks.models.LstRangerRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstRangerService {
    List<LstRangerSearchDTO> search(LstRangerRequest lstRangerRequest, Pageable pageable);
    List<LstRanger> autocomplete(String query);
    String insert(LstRanger ls);
    String update(LstRanger ls);
    String delete(LstRanger _spp);
    String getid(String sppid,Integer spplevel);
    List<LstRangerSearchDTO> getFnFindTreeData(String id, String level, String sppid);
    List<LstRangerSearchDTO> getRangerBySppId(String sppid);
}
