package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstSPPAutoCompleteDTO;
import com.bitsco.vks.dto.LstSPPDTO;
import com.bitsco.vks.dto.LstSPPSearchDTO;
import com.bitsco.vks.entity.LstCustoms;
import com.bitsco.vks.entity.LstSPP;
import com.bitsco.vks.models.LstSppSearchRequest;
import org.springframework.data.domain.Pageable;

import java.sql.SQLException;
import java.util.List;

public interface SppService {
    List<LstSPP> getChildSPPs(String parentId);

    List<LstSPPAutoCompleteDTO> autocomplete(String query) throws SQLException;

    List<LstSPPSearchDTO> search(Pageable pageable, LstSppSearchRequest lstSppSearchRequest);

    String findNameSppBySppId(Long sppId);

    LstSPPDTO getSPP(String sppId);

    List<LstSPPAutoCompleteDTO> autocompleteForChangeInsp(String query, String sppid) throws SQLException;

    List<LstSPP> getListSpp(String query, String sppid) throws SQLException;

    String insert(LstSPP req, String username);

    String update(LstSPP req, String username);

    String getid(String sppid, Integer spplevel);

    String delete(LstSPP req);

    LstSPP getBySppid(String sppid);

    List<LstSPP> getSpps(String sppid, String query);

    List<LstSPPSearchDTO> getFnFindTreeData(String id, String level, String sppid);
}
