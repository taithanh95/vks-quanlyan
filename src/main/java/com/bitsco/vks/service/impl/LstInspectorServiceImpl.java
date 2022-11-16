package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.LstInspector;
import com.bitsco.vks.entity.LstSPP;
import com.bitsco.vks.entity._LstInspector;
import com.bitsco.vks.models.LstInspectorInsertRequest;
import com.bitsco.vks.models.LstInspectorSearchRequest;
import com.bitsco.vks.repository.LstInspectorRepository;
import com.bitsco.vks.repository._LstInspectorRepository;
import com.bitsco.vks.service.LstInspectorService;
import com.bitsco.vks.utils.StringCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

@Service
public class LstInspectorServiceImpl implements LstInspectorService {
    @Autowired
    private LstInspectorRepository lstInspectorRepository;

    @Autowired
    private _LstInspectorRepository _LstInspectorRepository;

    @Override
    public List<LstInspector> loadInsList(String query, String sppid, String position_type) {
        return lstInspectorRepository.autocomplete(query, sppid, position_type);
    }

    @Override
    public List<LstInspector> loadInsList_npc(String query, String sppid) {
        return lstInspectorRepository.autocomplete(query, sppid, "LD");
    }

    @Override
    public List<LinkedCaseInsensitiveMap> search(LstInspectorSearchRequest request, Pageable pageable) {
        return lstInspectorRepository.search(pageable.getPageNumber(), pageable.getPageSize(), request.sortField, request.sortOrder, request.regicode, request.casecode, request.sppid, request.usefor);
    }

    @Override
    public List<_LstInspector> getListLstInspectorBySppId(String sppId) {
        return _LstInspectorRepository.getListLstInspectorBySppId(sppId);
    }

    @Override
    public List<_LstInspector> getListLstInspectorBySppIdAndPosition(String sppId, String position) {
        return _LstInspectorRepository.getListLstInspectorBySppIdAndPosition(sppId, StringCommon.addLikeRightAndLeft(position));
    }

    @Override
    public List<_LstInspector> getListInspectorByPositionSearchKey(String sppId, String position, String key) {
        return _LstInspectorRepository.getListInspectorByPositionSearchKey(sppId,
                StringCommon.addLikeRightAndLeft(position),
               StringCommon.isNullOrBlank(key)? null : StringCommon.addLikeRightAndLeft(key));
    }

    @Override
    public LinkedCaseInsensitiveMap getByInspcode(String inspcode) {
        return lstInspectorRepository.getByInspcode(inspcode);
    }

    @Override
    public List<LstInspector> search1(LstInspectorSearchRequest request) {
        return lstInspectorRepository.search1(request);
    }

    @Override
    public String delete(LstInspectorSearchRequest request) {
        return lstInspectorRepository.delete(request);
    }

    @Override
    public String insertUpdate(LstInspectorInsertRequest req, String username) {
        return lstInspectorRepository.insertUpdate(req, username);
    }

    @Override
    public List<LstSPP> getSpp(String sppid) {
        return lstInspectorRepository.getSpp(sppid);
    }

    @Override
    public List<LstSPP> getListSppIsDepart(String sppid) {
        return lstInspectorRepository.getListSppIsDepart(sppid);
    }

    @Override
    public String changeInspector(LstInspector req, String username) {
        return lstInspectorRepository.changeInspector(req, username);
    }

    @Override
    public List<LstInspector> getInspList(String query, String sppid, String underlevel) {
        return lstInspectorRepository.autocomplete2022(query, sppid, underlevel);
    }
}
