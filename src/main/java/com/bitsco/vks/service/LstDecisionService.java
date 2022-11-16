package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstDecisionSearchDTO;
import com.bitsco.vks.entity.LstDecisionEntity;
import com.bitsco.vks.models.LstDecisionRequest;
import com.bitsco.vks.models.LstDecisionSaveRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface LstDecisionService {
    List<LstDecisionSearchDTO> search(LstDecisionRequest lstDecisionRequest, Pageable pageable);

    List<LstDecisionSearchDTO> getListApplyForTBTG(Pageable pageable, String search, String sortFields, String sortOrder);

    List<LstDecisionEntity> searchForHS(String usefor, String applyfor, String decitype);

    LinkedCaseInsensitiveMap getDecisionById(String deciid);

    List<LstDecisionSearchDTO> autocomplete(String query);

    String save(LstDecisionSaveRequest req, String username);

    String delete(String deciid);

    List<LstDecisionSearchDTO> findTreeData(String deciid, String decilevel);

}
