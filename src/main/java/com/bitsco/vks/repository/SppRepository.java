package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstSPPAutoCompleteDTO;
import com.bitsco.vks.dto.LstSPPDTO;
import com.bitsco.vks.dto.LstSPPSearchDTO;
import com.bitsco.vks.entity.LstSPC;
import com.bitsco.vks.entity.LstSPP;

import java.sql.SQLException;
import java.util.List;

public interface SppRepository {
    List<LstSPP> getChildSPPs(String parentId);

    List<LstSPPAutoCompleteDTO> autocomplete(String query, Integer level, Integer limit) throws SQLException;

    List<LstSPPSearchDTO> search(int rowIndex, int pageSize, String sortField, String sortOrder, String p_SppId, String p_Name, String p_Addr, String p_Tel, String p_Fax, String p_Csppid);

    String findNameSppBySppId(Long sppId);

    LstSPPDTO getSPP(String sppId);

    List<LstSPPAutoCompleteDTO> autocompleteForChangeInsp(String query, Integer level, Integer limit, String sppid) throws SQLException;

    List<LstSPP> getListSpp(String query, Integer items, String sppid);

    String insert(LstSPP req, String username);

    String update(LstSPP req, String username);

    String getid(String sppid, Integer spplevel);

    String delete(LstSPP req);

    LstSPP getBySppid(String sppid);

    List<LstSPP> getSpps(String sppid, String query);

    List<LstSPPSearchDTO> getFnFindTreeData(String id, String level, String sppid);

}
