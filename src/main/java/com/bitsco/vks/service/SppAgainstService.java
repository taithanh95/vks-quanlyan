package com.bitsco.vks.service;

import com.bitsco.vks.dto.SppAgainstDTO;
import com.bitsco.vks.entity.SppAgainst;
import com.bitsco.vks.models.*;
import org.springframework.data.domain.Pageable;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppAgainstService {
    List<SppAgainst> searchByRegicode(SppAgainstSearchRegiRequest request, Pageable pageable);
    List<SppAgainst> searchcase(SppAgainstSearchCaseRequest request, Pageable pageable);
    SppAgainstSaveResponse insertUpdate(SppAgainstSaveRequest request, String userid);
    String delete(SppAgainstDeleteRequest request);

    List<SppAgainst> loadLstAgainsts(String id);

    List<SppAgainst> loadLstAgainstResult(String id);

    List<SppAgainst> getAgacase(String againstcode);

    List<LinkedCaseInsensitiveMap> isCheckTrans(String regicode);
    Integer isCheckDisable(String regicode);

    List<SppAgainstDTO> searchForUpdateResult(SppAgainstSearchCaseRequest request, Pageable pageable);

    SppAgainstSaveResponse updateResult(SppAgainstSaveRequest request, String userid);
}
