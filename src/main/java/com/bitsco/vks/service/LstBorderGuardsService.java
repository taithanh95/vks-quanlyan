package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstBorderGuardsSearchDTO;
import com.bitsco.vks.entity.LstBorderGuards;
import com.bitsco.vks.models.LstBorderGuardsRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstBorderGuardsService {
    List<LstBorderGuardsSearchDTO> search(LstBorderGuardsRequest lstBorderGuardsRequest, Pageable pageable);
    String insert(LstBorderGuards ls);
    String update(LstBorderGuards ls);
    String delete(LstBorderGuards _spp);
    List<LstBorderGuards> autocomplete(String query);
    String getid(String sppid,Integer spplevel);
    List<LstBorderGuardsSearchDTO> getFnFindTreeData(String id, String level, String sppid);
    List<LstBorderGuardsSearchDTO> getBorderGuardsBySppId(String sppid);
}
