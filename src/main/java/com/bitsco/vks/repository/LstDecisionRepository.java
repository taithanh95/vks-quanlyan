package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstDecisionSearchDTO;
import com.bitsco.vks.entity.LstDecisionEntity;
import com.bitsco.vks.models.LstDecisionSaveRequest;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface LstDecisionRepository {
    List<LstDecisionSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String id, String name, String applyFor, String userFor, String status, String applyFinish, String deciType);

    List<LstDecisionEntity> searchForHS(String usefor, String applyfor, String decitype);

    List<LstDecisionSearchDTO> getListApplyForTBTG(Integer rowIndex, Integer pageSize, String search, String sortFields, String sortOrder);

    LinkedCaseInsensitiveMap getDecisionById(String deciid);

    List<LstDecisionSearchDTO> autocomplete(String query);

    String save(LstDecisionSaveRequest req, String username);

    String delete(String deciid);

    List<LstDecisionSearchDTO> getFnFindTree(String decilevel, String deciid);
}
