package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstSPCSearchDTO;
import com.bitsco.vks.entity.LstSPC;
import com.bitsco.vks.models.LstSPCRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstSPCService {
    List<LstSPCSearchDTO> search(LstSPCRequest lstSPCRequest, Pageable pageable);

    List<LstSPC> autocomplete(String query);

    List<LstSPC> getFromSpp(String spcid);

    List<LstSPC> getFromSpp2022(String spcid);

    String insert(LstSPC req, String username);

    String update(LstSPC req, String username);

    String getid(String spcid, Integer spclevel);

    String delete(LstSPC req);

    List<LstSPC> getListSpc(String query);

    List<LstSPCSearchDTO> getFnFindTreeData(String spcid, String level, String sppid);

}
