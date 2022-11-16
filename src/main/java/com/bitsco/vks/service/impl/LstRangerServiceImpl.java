package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstRangerSearchDTO;
import com.bitsco.vks.entity.LstRanger;
import com.bitsco.vks.models.LstRangerRequest;
import com.bitsco.vks.repository.LstRangerRepository;
import com.bitsco.vks.service.LstRangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LstRangerServiceImpl implements LstRangerService {
    @Autowired
    private LstRangerRepository lstRangerRepository;

    @Override
    public List<LstRangerSearchDTO> search(LstRangerRequest lstRangerRequest, Pageable pageable) {
        return lstRangerRepository.search(pageable.getPageNumber(),
                pageable.getPageSize(),
                lstRangerRequest.getSortField(),
                lstRangerRequest.getSortOrder(),
                lstRangerRequest.getRangid(),
                lstRangerRequest.getName(),
                lstRangerRequest.getAddr(),
                lstRangerRequest.getTel(),
                lstRangerRequest.getFax(),
                lstRangerRequest.getSppId());

    }

    @Override
    @Transactional(readOnly = true)
    public List<LstRanger> autocomplete(String query) {
        return lstRangerRepository.autocomplete(query,null,10);
    }
    @Override
    public String insert(LstRanger ls) {
        //TODO: Sau khi Xung them token, se luu userId vao token va lay ra
        return lstRangerRepository.insert(ls, "admin");
    }

    @Override
    public String update(LstRanger ls) {
        //TODO: Sau khi Xung them token, se luu userId vao token va lay ra
        return lstRangerRepository.update(ls, "admin");
    }

    @Override
    public String delete(LstRanger _spp){
        return lstRangerRepository.delete(_spp);
    }


    @Override
    public String getid(String sppid, Integer spplevel){
        return lstRangerRepository.getid(sppid,spplevel);
    }

    @Override
    public List<LstRangerSearchDTO> getFnFindTreeData(String id, String level, String sppid) {
        return lstRangerRepository.getFnFindTreeData(id, level, sppid);
    }

    @Override
    public List<LstRangerSearchDTO> getRangerBySppId(String sppid) {
        return lstRangerRepository.getRangerBySppId(sppid);
    }
}
