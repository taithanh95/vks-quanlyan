package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstSPCSearchDTO;
import com.bitsco.vks.entity.LstCustoms;
import com.bitsco.vks.entity.LstSPC;

import java.util.List;

public interface LstSPCRepository {
    List<LstSPCSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String spcId, String name, String addr, String sppId);

    List<LstSPC> autocomplete(String query, Integer level, Integer limit);

    List<LstSPC> getFromSpp(String spcid);

    List<LstSPC> getFromSpp2022(String spcid);

    String insert(LstSPC req, String username);

    String update(LstSPC req, String username);

    String getid(String spcid, Integer spclevel);

    String delete(LstSPC req);

    List<LstSPC> getListSpc(String query);

    List<LstSPCSearchDTO> getFnFindTreeData(String spcid, String level, String sppid);

}
