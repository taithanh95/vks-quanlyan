package com.bitsco.vks.service;

import com.bitsco.vks.entity.LstInspector;
import com.bitsco.vks.entity.LstSPP;
import com.bitsco.vks.entity._LstInspector;
import com.bitsco.vks.models.LstInspectorInsertRequest;
import com.bitsco.vks.models.LstInspectorSearchRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface LstInspectorService {
    List<LstInspector> loadInsList(String query, String sppid, String position_type);

    List<LstInspector> loadInsList_npc(String query, String sppid);

    List<LinkedCaseInsensitiveMap> search(LstInspectorSearchRequest request, Pageable pageable);

    List<_LstInspector> getListLstInspectorBySppId(String sppId);
    List<_LstInspector> getListLstInspectorBySppIdAndPosition(String sppId, String position);
    List<_LstInspector> getListInspectorByPositionSearchKey(String sppId, String position, String key);

    LinkedCaseInsensitiveMap getByInspcode(String inspcode);

    List<LstInspector> search1(LstInspectorSearchRequest request);

    String delete(LstInspectorSearchRequest request);

    String insertUpdate(LstInspectorInsertRequest req, String username);

    List<LstSPP> getSpp(String sppid);

    List<LstSPP> getListSppIsDepart(String sppid);

    String changeInspector(LstInspector req, String username);

    List<LstInspector> getInspList(String query, String sppid, String underlevel);
}
