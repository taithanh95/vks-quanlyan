package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstSPPAutoCompleteDTO;
import com.bitsco.vks.dto.LstSPPDTO;
import com.bitsco.vks.dto.LstSPPSearchDTO;
import com.bitsco.vks.entity.LstSPP;
import com.bitsco.vks.models.LstSppSearchRequest;
import com.bitsco.vks.repository.SppRepository;
import com.bitsco.vks.service.SppService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class SppServiceImpl implements SppService {
    @Autowired
    private SppRepository sppRepository;

    @Override
    public List<LstSPP> getChildSPPs(String parentId) {
        return sppRepository.getChildSPPs(parentId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LstSPPAutoCompleteDTO> autocomplete(String query) throws SQLException {
        return sppRepository.autocomplete(query, 0, 10);
    }

    @Override
    public List<LstSPPSearchDTO> search(Pageable pageable, LstSppSearchRequest lstSppSearchRequest) {
        return sppRepository.search(pageable.getPageNumber(), pageable.getPageSize(),
                lstSppSearchRequest.getSortField(), checkSortOrder(lstSppSearchRequest.getSortOrder()), lstSppSearchRequest.getSppId(), lstSppSearchRequest.getName(), lstSppSearchRequest.getAddr(), lstSppSearchRequest.getTel(), lstSppSearchRequest.getFax(), lstSppSearchRequest.getCsppId());
    }

    @Override
    public LstSPPDTO getSPP(String sppId) {
        return sppRepository.getSPP(sppId);
    }

    public String checkSortOrder(String SortOrder) {
        if (!Strings.isNullOrEmpty(SortOrder)) {
            return SortOrder;
        } else {
            return "ASC";
        }
    }

    @Override
    public String findNameSppBySppId(Long sppId) {
        return sppRepository.findNameSppBySppId(sppId);
    }

    @Override
    public List<LstSPPAutoCompleteDTO> autocompleteForChangeInsp(String query, String sppid) throws SQLException {
        return sppRepository.autocompleteForChangeInsp(query, 0, 10, sppid);
    }

    @Override
    public List<LstSPP> getListSpp(String query, String sppid) throws SQLException {
        return sppRepository.getListSpp(query, 10, sppid);
    }

    @Override
    public String insert(LstSPP req, String username) {
        return sppRepository.insert(req, username);
    }

    @Override
    public String update(LstSPP req, String username) {
        return sppRepository.update(req, username);
    }

    @Override
    public String getid(String sppid, Integer spplevel) {
        return sppRepository.getid(sppid, spplevel);
    }

    @Override
    public String delete(LstSPP req) {
        return sppRepository.delete(req);
    }

    @Override
    public LstSPP getBySppid(String sppid) {
        return sppRepository.getBySppid(sppid);
    }

    @Override
    public List<LstSPP> getSpps(String sppid, String query) {
        return sppRepository.getSpps(sppid,query);
    }

    @Override
    public List<LstSPPSearchDTO> getFnFindTreeData(String id, String level, String sppid) {
        return sppRepository.getFnFindTreeData(id,level,sppid);
    }
}

