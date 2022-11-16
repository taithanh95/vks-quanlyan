package com.bitsco.vks.repository;

import com.bitsco.vks.entity.LstInspector;
import com.bitsco.vks.entity.LstSPP;
import com.bitsco.vks.models.LstInspectorInsertRequest;
import com.bitsco.vks.models.LstInspectorSearchRequest;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface LstInspectorRepository {
    List<LstInspector> autocomplete(String query, String sppid, String position_type);

    List<LinkedCaseInsensitiveMap> search(int rowIndex, int pageSize, String sortField, String sortOrder, String regicode, String caseCode, String sppId, String usefor);

    LinkedCaseInsensitiveMap getByInspcode(String inspcode);

    List<LstInspector> search1(LstInspectorSearchRequest request);

    String delete(LstInspectorSearchRequest request);

    String insertUpdate(LstInspectorInsertRequest req, String username);

    List<LstSPP> getSpp(String sppid);

    List<LstSPP> getListSppIsDepart(String sppid);

    String changeInspector(LstInspector req, String username);

    List<LstInspector> autocomplete2022(String query, String sppid, String underlevel);
}
