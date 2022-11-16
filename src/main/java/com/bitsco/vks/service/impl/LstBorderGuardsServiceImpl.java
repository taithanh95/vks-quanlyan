package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstBorderGuardsSearchDTO;
import com.bitsco.vks.entity.LstBorderGuards;
import com.bitsco.vks.models.LstBorderGuardsRequest;
import com.bitsco.vks.repository.LstBorderGuardsRepository;
import com.bitsco.vks.service.LstBorderGuardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LstBorderGuardsServiceImpl implements LstBorderGuardsService {
    @Autowired
    private LstBorderGuardsRepository lstBorderGuardsRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstBorderGuardsSearchDTO> search(LstBorderGuardsRequest lstBorderGuardsRequest, Pageable pageable) {
        return lstBorderGuardsRepository.search(pageable.getPageNumber(),
                                                pageable.getPageSize(),
                                                lstBorderGuardsRequest.getSortField(),
                                                lstBorderGuardsRequest.getSortOrder(),
                                                lstBorderGuardsRequest.getSppId(),
                                                lstBorderGuardsRequest.getName(),
                                                lstBorderGuardsRequest.getAddr(),
                                                lstBorderGuardsRequest.getTel(),
                                                lstBorderGuardsRequest.getFax());
    }

    @Override
    public String insert(LstBorderGuards ls) {
        //TODO: Sau khi Xung them token, se luu userId vao token va lay ra
        return lstBorderGuardsRepository.insert(ls, "admin");
    }

    @Override
    public String update(LstBorderGuards ls) {
        //TODO: Sau khi Xung them token, se luu userId vao token va lay ra
        return lstBorderGuardsRepository.update(ls, "admin");
    }

    @Override
    public String delete(LstBorderGuards _spp){
        return lstBorderGuardsRepository.delete(_spp);
    }

    @Override
    public List<LstBorderGuards> autocomplete(String query) {
        return lstBorderGuardsRepository.autocomplete(query, 0, 10);
    }

    @Override
    public String getid(String sppid, Integer spplevel){
        return lstBorderGuardsRepository.getid(sppid,spplevel);
    }

    @Override
    public List<LstBorderGuardsSearchDTO> getFnFindTreeData(String id, String level, String sppid) {
        return lstBorderGuardsRepository.getFnFindTreeData(id, level, sppid);
    }

    @Override
    public List<LstBorderGuardsSearchDTO> getBorderGuardsBySppId(String sppid) {
        return lstBorderGuardsRepository.getBorderGuardsBySppId(sppid);
    }
}
