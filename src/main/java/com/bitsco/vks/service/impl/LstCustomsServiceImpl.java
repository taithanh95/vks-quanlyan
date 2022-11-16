package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstCustomsSearchDTO;
import com.bitsco.vks.entity.LstCustoms;
import com.bitsco.vks.models.LstCustomsRequest;
import com.bitsco.vks.repository.LstCustomsRepository;
import com.bitsco.vks.service.LstCustomsService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LstCustomsServiceImpl implements LstCustomsService {

    @Autowired
    private LstCustomsRepository lstCustomsRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstCustomsSearchDTO> search(LstCustomsRequest lstCustomsRequest, Pageable pageable) {
        return lstCustomsRepository.search(pageable.getPageNumber(), pageable.getPageSize(),
                checkSortField(lstCustomsRequest.getSortField()), checkSortOrder(lstCustomsRequest.getSortOrder()),
                lstCustomsRequest.getSppid(), lstCustomsRequest.getName(), lstCustomsRequest.getAddr(),
                lstCustomsRequest.getTel(), lstCustomsRequest.getFax(), lstCustomsRequest.getSpcid());
    }

    @Override
    @Transactional(readOnly = true)
    public List<LstCustoms> autocomplete(String query) {
        return lstCustomsRepository.autocomplete(query, null, 10);
    }


    public String checkSortField(String SortField) {
        if (!Strings.isNullOrEmpty(SortField)) {
            return SortField;
        } else {
            return "customid";
        }
    }

    public String checkSortOrder(String SortOrder) {
        if (!Strings.isNullOrEmpty(SortOrder)) {
            return SortOrder;
        } else {
            return "ASC";
        }
    }

    @Override
    public String insert(LstCustoms req, String username) {
        return lstCustomsRepository.insert(req, username);
    }

    @Override
    public String update(LstCustoms req, String username) {
        return lstCustomsRepository.update(req, username);
    }

    @Override
    public String getid(String sppid, Integer spplevel) {
        return lstCustomsRepository.getid(sppid, spplevel);
    }

    @Override
    public String delete(LstCustoms req) {
        return lstCustomsRepository.delete(req);
    }

    @Override
    public List<LstCustomsSearchDTO> getFnFindTreeData(String cumstoid, String level, String sppid) {
        return lstCustomsRepository.getFnFindTreeData(cumstoid,level,sppid);
    }

    @Override
    public List<LstCustomsSearchDTO> getCustomsBySppId(String sppid) {
        return lstCustomsRepository.getCustomsBySppId(sppid);
    }
}
