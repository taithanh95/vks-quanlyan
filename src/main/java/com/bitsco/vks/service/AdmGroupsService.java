package com.bitsco.vks.service;

import com.bitsco.vks.dto.AdmGroupsRequestDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface AdmGroupsService {
    List<LinkedCaseInsensitiveMap> getLst(Pageable page, AdmGroupsRequestDTO req);
    String save(AdmGroupsRequestDTO req, String username);
    String delete(String groupid);
}
