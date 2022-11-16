package com.bitsco.vks.repository;

import com.bitsco.vks.dto.AdmDepartmentsRequestDTO;
import com.bitsco.vks.entity.LstSPP;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface AdmDepartmentsRepository {

    List<LinkedCaseInsensitiveMap> getLst(int rowIndex, int pageSize, AdmDepartmentsRequestDTO req);

    String save(AdmDepartmentsRequestDTO req, String username);

    String delete(String departid);

    List<LstSPP> getLstSpp(String sppid);

}
