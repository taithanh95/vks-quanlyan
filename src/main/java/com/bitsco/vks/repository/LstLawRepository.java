package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstLawAutoCompleteDTO;
import com.bitsco.vks.dto.LstLawSearchDTO;
import com.bitsco.vks.entity.LstCode;
import com.bitsco.vks.entity.LstCustoms;
import com.bitsco.vks.entity.LstLaw;
import com.bitsco.vks.entity.LstLawGroup;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.sql.SQLException;
import java.util.List;

public interface LstLawRepository {
    List<LstLawAutoCompleteDTO> autocomplete(String query, String codeId, Integer limit) throws SQLException;
    List<LstLawAutoCompleteDTO> search(String query, Integer limit) throws SQLException;
    List<LstLawSearchDTO> searchLaw(int rowIndex, int pageSize, String sortField, String sortOrder, String p_LawId, String p_Item, String p_Point, String p_LawName, String p_GroupId, String p_CodeId);
    List<LstLaw> sarchLaw(int rowIndex, int pageSize, String sortField, String sortOrder, LstLaw lawFilters);
    List<LstCode> getLstCode(String codeid);
    List<LstLawGroup> getLstLawGroup(String codeid);

    LinkedCaseInsensitiveMap get(String lawcode);

    String insert(LstLaw req, String username, String action);

    String update(LstLaw req, String username, String action);

    String delete(LstLaw req);
}
