package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.SppRegisterSearchDTO;
import com.bitsco.vks.entity.SppRegister;
import com.bitsco.vks.models.GetSppRegisterRequest;
import com.bitsco.vks.models.SaveSppRegisterRequest;
import com.bitsco.vks.models.SppRegisterSearchRequest;
import com.bitsco.vks.repository.SppRegisterRepository;
import com.bitsco.vks.service.SppRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

@Service
public class SppRegisterServiceImpl implements SppRegisterService {
    @Autowired
    private SppRegisterRepository sppRegisterRepository;

    @Override
    public List<LinkedCaseInsensitiveMap> search(SppRegisterSearchRequest request, Pageable pageable) {
        return sppRegisterRepository.search(pageable.getPageNumber(), pageable.getPageSize(), request.sortField, request.sortOrder, request.casecode, request.usefor, request.csppid);
    }

//    @Override
//    public SppRegister GetSppRegister(String casecode, String usefor, String sppid) {
//        List<SppRegisterSearchDTO> list = sppRegisterRepository.search(1,1,"", "ASC", casecode, usefor, sppid);
//        if (list != null && list.isEmpty())
//            return list.get(list.size() - 1).;
//        return  null;
//    }

    @Override
    public String SaveSppRegister(SaveSppRegisterRequest request) {
        return  sppRegisterRepository.insertUpdate(request.sppRegister, request.sppCase, request.sppId, request.userId);
    }

    @Override
    public String delete(String regicode) {
        return sppRegisterRepository.delete(regicode);
    }

    @Override
    public String checkRegisterable(String casecode, String usefor, String sppid) {
        return sppRegisterRepository.checkRegisterable(casecode, usefor, sppid);
    }
}
