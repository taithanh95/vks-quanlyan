package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstCountrySearchDTO;
import com.bitsco.vks.dto.LstPoliceSearchDTO;
import com.bitsco.vks.entity.LstPolice;
import com.bitsco.vks.models.LstPoliceSearchRequest;
import com.bitsco.vks.repository.LstPoliceRepository;
import com.bitsco.vks.service.LstPoliceService;
import com.google.common.base.Strings;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedCaseInsensitiveMap;

@Service
public class LstPoliceServiceImpl implements LstPoliceService {
    @Autowired
    LstPoliceRepository lstPoliceRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstPolice> autocomplete(String query) {
        return lstPoliceRepository.autocomplete(query, null, 10);
    }

    @Override
    public List<LstPoliceSearchDTO> search(Pageable pageable, LstPoliceSearchRequest lstPoliceSearchRequest) {
        return lstPoliceRepository.search(pageable.getPageNumber(), pageable.getPageSize(),
                lstPoliceSearchRequest.getSortField(), checkSortOrder(lstPoliceSearchRequest.getSortOrder()), lstPoliceSearchRequest.getSppId(),  lstPoliceSearchRequest.getName(), lstPoliceSearchRequest.getAddr(), lstPoliceSearchRequest.getTel(), lstPoliceSearchRequest.getFax(), lstPoliceSearchRequest.getCsppId());
    }

    @Override
    public LinkedCaseInsensitiveMap getfromspp(String sppid) {
        return lstPoliceRepository.getfromspp(sppid);
    }

    public String checkSortOrder(String SortOrder) {
        if (!Strings.isNullOrEmpty(SortOrder)) {
            return SortOrder;
        } else {
            return "ASC";
        }
    }

    @Override
    public String findPoliceBySppId(Long sppId) {

        return lstPoliceRepository.findPoliceBySppId(sppId);
    }
    @Override
    public String insert(LstPolice ls) {
        //TODO: Sau khi Xung them token, se luu userId vao token va lay ra
        return lstPoliceRepository.insert(ls, "admin");
    }

    @Override
    public String update(LstPolice ls) {
        //TODO: Sau khi Xung them token, se luu userId vao token va lay ra
        return lstPoliceRepository.update(ls, "admin");
    }

    @Override
    public String delete(LstPolice _spp){
        return lstPoliceRepository.delete(_spp);
    }


    @Override
    public String getid(String sppid, Integer spplevel) {
        return lstPoliceRepository.getid(sppid,spplevel);
    }

    @Override
    public List<LstPoliceSearchDTO> getFnFindTreeData(String id, String level, String sppid) {
        return lstPoliceRepository.getFnFindTreeData(id, level, sppid);
    }

    @Override
    public List<LstPoliceSearchDTO> getPoliceLst(String query) {
        return lstPoliceRepository.getPoliceLst(query);
    }
}
