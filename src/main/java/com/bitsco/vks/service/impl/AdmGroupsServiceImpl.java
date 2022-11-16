package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.AdmGroupsRequestDTO;
import com.bitsco.vks.repository.AdmGroupsRepository;
import com.bitsco.vks.service.AdmGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

@Service
public class AdmGroupsServiceImpl implements AdmGroupsService {

    @Autowired
    AdmGroupsRepository admGroupsRepository;

    @Override
    public List<LinkedCaseInsensitiveMap> getLst(Pageable page, AdmGroupsRequestDTO req) {
        return admGroupsRepository.getLst(req,page.getPageNumber(),page.getPageSize(),
                req.sortField, req.sortOrder);
    }

    @Override
    public String save(AdmGroupsRequestDTO req, String username) {
        return admGroupsRepository.save(req,username);
    }

    @Override
    public String delete(String groupid) {
        return admGroupsRepository.delete(groupid);
    }
}
