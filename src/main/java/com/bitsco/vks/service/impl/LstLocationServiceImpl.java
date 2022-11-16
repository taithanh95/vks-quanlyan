package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstLocationSearchDTO;
import com.bitsco.vks.entity.LstBorderGuards;
import com.bitsco.vks.entity.LstLocation;
import com.bitsco.vks.models.LstLocationRequest;
import com.bitsco.vks.repository.LstLocationRepository;
import com.bitsco.vks.service.LstLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LstLocationServiceImpl implements LstLocationService {
    @Autowired
    private LstLocationRepository lstLocationRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstLocationSearchDTO> search(LstLocationRequest lstLocationRequest, Pageable pageable) {
        return lstLocationRepository.search(pageable.getPageNumber(), pageable.getPageSize(), lstLocationRequest.getSortField(), lstLocationRequest.getSortOrder(), lstLocationRequest.getLocaid(), lstLocationRequest.getName(), lstLocationRequest.getRemark(), lstLocationRequest.getSppid());
    }

    @Override
    @Transactional(readOnly = true)
    public List<LstLocation> autocomplete(String query){
        return lstLocationRepository.autocomplete(query, null, 10);
    }
    @Override
    @Transactional(readOnly = true)
    public List<LstLocation> autocomplete2(String query, Integer level){
        return lstLocationRepository.autocomplete(query, level, 10);
    }

    @Override
    public LstLocation getLocationById(String id) {
        return lstLocationRepository.getLocationById(id);
    }
    @Override
    public String insert(LstLocation ls) {
        //TODO: Sau khi Xung them token, se luu userId vao token va lay ra
        return lstLocationRepository.insert(ls, "admin");
    }

    @Override
    public String update(LstLocation ls) {
        //TODO: Sau khi Xung them token, se luu userId vao token va lay ra
        return lstLocationRepository.update(ls, "admin");
    }

    @Override
    public String delete(LstLocation _spp){
        return lstLocationRepository.delete(_spp);
    }

    @Override
    public String getid(String locaid, Integer localevel){
        return lstLocationRepository.getid(locaid,localevel);
    }

    @Override
    public List<LstLocationSearchDTO> getFnFindTreeData(String locaid, String localevel, String sppid) {
        return lstLocationRepository.getFnFindTreeData(locaid,localevel,sppid);
    }
}
