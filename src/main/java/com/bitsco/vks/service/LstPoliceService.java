package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstCountrySearchDTO;
import com.bitsco.vks.dto.LstPoliceSearchDTO;
import com.bitsco.vks.entity.LstPolice;
import com.bitsco.vks.models.LstPoliceSearchRequest;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.util.LinkedCaseInsensitiveMap;

public interface LstPoliceService {
    List<LstPolice> autocomplete(String query);

    String findPoliceBySppId(Long sppId);

    List<LstPoliceSearchDTO> search(Pageable pageable, LstPoliceSearchRequest lstPoliceSearchRequest);

    LinkedCaseInsensitiveMap getfromspp(String sppid);
    String insert(LstPolice ls);
    String update(LstPolice ls);
    String delete(LstPolice _spp);
    String getid(String sppid,Integer spplevel);

    List<LstPoliceSearchDTO> getFnFindTreeData(String id, String level, String sppid);

    List<LstPoliceSearchDTO> getPoliceLst(String query);
}
