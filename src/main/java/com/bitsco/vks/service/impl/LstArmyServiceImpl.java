package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstArmySearchDTO;
import com.bitsco.vks.entity.LstArmyEntity;
import com.bitsco.vks.models.LstArmyRequest;
import com.bitsco.vks.repository.LstArmyRepository;
import com.bitsco.vks.service.LstArmyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LstArmyServiceImpl implements LstArmyService {
    @Autowired
    private LstArmyRepository lstArmyRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstArmySearchDTO> search(LstArmyRequest lstArmyRequest, Pageable pageable) {
        return lstArmyRepository.search(pageable.getPageNumber(),
                pageable.getPageSize(),
                lstArmyRequest.getSortField(),
                lstArmyRequest.getSortOrder(),
                lstArmyRequest.getArmyid(),
                lstArmyRequest.getName(),
                lstArmyRequest.getAddr(),
                lstArmyRequest.getTel(),
                lstArmyRequest.getFax(),
                lstArmyRequest.getSppid());
    }

    @Override
    @Transactional(readOnly = true)
    public List<LstArmyEntity> autocomplete(String query) {
        return lstArmyRepository.autocomplete(query, null, 10);
    }
    @Override
    public String insert(LstArmyEntity ls) {
        //TODO: Sau khi Xung them token, se luu userId vao token va lay ra
        return lstArmyRepository.insert(ls, "admin");
    }

    @Override
    public String update(LstArmyEntity ls) {
        //TODO: Sau khi Xung them token, se luu userId vao token va lay ra
        return lstArmyRepository.update(ls, "admin");
    }

    @Override
    public String delete(LstArmyEntity _spp){
        return lstArmyRepository.delete(_spp);
    }


    @Override
    public String getid(String sppid, Integer spplevel){
        return lstArmyRepository.getid(sppid,spplevel);
    }

    @Override
    public List<LstArmySearchDTO> getFnFindTreeData(String id, String level, String sppid) {
        return lstArmyRepository.getFnFindTreeData(id,level,sppid);
    }

    @Override
    public List<LstArmySearchDTO> getArmyBySppId(String sppid) {
        return lstArmyRepository.getArmyBySppId(sppid);
    }
}
