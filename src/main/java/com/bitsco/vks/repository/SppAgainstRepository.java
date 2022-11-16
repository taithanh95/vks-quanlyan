package com.bitsco.vks.repository;

import com.bitsco.vks.dto.SppAgainstDTO;
import com.bitsco.vks.entity.SppAgainst;
import com.bitsco.vks.models.SppAgainstSaveResponse;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppAgainstRepository {
    List<SppAgainst> searchByRegicode(int rowIndex, int pageSize, String sortField, String sortOrder,
                                      String regicode, String userfor, String sppid);
    List<SppAgainst> searchcase(int rowIndex, int pageSize, String sortField, String sortOrder,
                                String casecode, String userfor, String sppid);
    SppAgainstSaveResponse insertUpdate(String action, SppAgainst bean, String userid);

    String delete(SppAgainst sppAgainst, String sppid);

    List<SppAgainst> loadLstAgainsts(String id);

    List<SppAgainst> loadLstAgainstResult(String id);

    List<SppAgainst> getAgacase(String againstcode);

    Integer isCheckDisable(String regicode);

    List<SppAgainstDTO> searchForUpdateResult(int rowIndex, int pageSize, String sortField, String sortOrder,
                                                         String casecode, String sppid);

    SppAgainstSaveResponse updateResult(String action, SppAgainst bean, String userid);
}
