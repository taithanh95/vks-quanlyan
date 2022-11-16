package com.bitsco.vks.service.impl;

import com.bitsco.vks.models.SppRegisterSearchRequest;
import com.bitsco.vks.models.SppSpcPolSaveRequest;
import com.bitsco.vks.models.SppSpcPolSearchRequest;
import com.bitsco.vks.repository.SppSpcPolRepository;
import com.bitsco.vks.service.SppSpcPolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

@Service
public class SppSpcPolServiceImpl implements SppSpcPolService {
    @Autowired
    private SppSpcPolRepository sppSpcPolRepository;

    @Override
    public List<LinkedCaseInsensitiveMap> search(SppSpcPolSearchRequest request, Pageable pageable) {
        return sppSpcPolRepository.searchUpdateInfo(pageable.getPageNumber(), pageable.getPageSize(), request.sortField, request.sortOrder, request.regicode
                , request.casecode, request.userfor);
    }

    @Override
    public String SaveSppSpcPol(SppSpcPolSaveRequest request) {
        return sppSpcPolRepository.insertUpdate(request.action, request.ppl, request.regicode, request.casecode, request.userid);
    }
}
