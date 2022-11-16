package com.bitsco.vks.repository;

import com.bitsco.vks.dto.AdmGroupsRequestDTO;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface AdmGroupsRepository {
    List<LinkedCaseInsensitiveMap> getLst(AdmGroupsRequestDTO req, int rowIndex, int pageSize, String sortField, String sortOrder);
    String save(AdmGroupsRequestDTO req, String username);
    String delete(String groupid);
}
