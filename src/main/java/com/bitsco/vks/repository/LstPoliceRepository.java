package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstCountrySearchDTO;
import com.bitsco.vks.dto.LstPoliceSearchDTO;
import com.bitsco.vks.entity.LstPolice;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface LstPoliceRepository {
    List<LstPolice> autocomplete(String query, Integer level, Integer limit);

    List<LstPoliceSearchDTO> search(int rowIndex, int pageSize, String sortField, String sortOrder, String p_SppId, String p_Name, String p_Addr, String p_Tel, String p_Fax, String p_Csppid);

    String findPoliceBySppId(Long sppId);

    LinkedCaseInsensitiveMap getfromspp(String sppid);

    String insert(LstPolice ls, String userId);
    String update(LstPolice ls, String userId);
    String delete(LstPolice _spp);
    String getid(String sppid, Integer spplevel);

    List<LstPoliceSearchDTO> getFnFindTreeData(String id, String level, String sppid);

    List<LstPoliceSearchDTO> getPoliceLst(String query);

}
