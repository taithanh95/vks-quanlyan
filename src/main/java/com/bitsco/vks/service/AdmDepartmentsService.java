package com.bitsco.vks.service;

import com.bitsco.vks.dto.AdmDepartmentsRequestDTO;
import com.bitsco.vks.entity.LstSPP;
import org.springframework.data.domain.Pageable;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface AdmDepartmentsService {

    List<LinkedCaseInsensitiveMap> getLst(Pageable page, AdmDepartmentsRequestDTO req);

    String save(AdmDepartmentsRequestDTO req, String username);

    String delete(String departid);

    List<LstSPP> getLstSpp(String sppid);

}
