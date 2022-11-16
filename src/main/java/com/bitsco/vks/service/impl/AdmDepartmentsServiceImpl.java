package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.AdmDepartmentsRequestDTO;
import com.bitsco.vks.entity.LstSPP;
import com.bitsco.vks.repository.AdmDepartmentsRepository;
import com.bitsco.vks.service.AdmDepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

@Service
public class AdmDepartmentsServiceImpl implements AdmDepartmentsService {

    @Autowired
    private AdmDepartmentsRepository admDepartmentsRepository;

    @Override
    public List<LinkedCaseInsensitiveMap> getLst(Pageable page, AdmDepartmentsRequestDTO req) {
        return admDepartmentsRepository.getLst(page.getPageNumber(), page.getPageSize(),req);
    }

    @Override
    public String save(AdmDepartmentsRequestDTO req, String username) {
        return admDepartmentsRepository.save(req, username);
    }

    @Override
    public String delete(String departid) {
        return admDepartmentsRepository.delete(departid);
    }

    @Override
    public List<LstSPP> getLstSpp(String sppid) {
        return admDepartmentsRepository.getLstSpp(sppid);
    }
}
