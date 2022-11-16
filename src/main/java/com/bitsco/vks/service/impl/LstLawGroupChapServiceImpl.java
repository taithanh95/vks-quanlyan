package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstLawGroupChapDTO;
import com.bitsco.vks.models.LstLawGroupChapRequest;
import com.bitsco.vks.models.LstLawGroupChapSave;
import com.bitsco.vks.repository.LstLawGroupChapRepository;
import com.bitsco.vks.service.LstLawGroupChapService;
import com.bitsco.vks.utils.StringCommon;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 12/05/2022
 * Time: 9:31 AM
 */
@Service
public class LstLawGroupChapServiceImpl implements LstLawGroupChapService {

    @Autowired
    private LstLawGroupChapRepository lstLawGroupChapRepository;

    @Override
    public List<LstLawGroupChapDTO> search(LstLawGroupChapRequest req, Pageable pageable) {
        return lstLawGroupChapRepository.search(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                checkSortField(req.getSortField()),
                checkSortOrder(req.getSortOrder()),
                req.getId(),
                req.getGroupid(),
                req.getFullname(),
                req.getGroupname());
    }

    @Override
    public List<LstLawGroupChapDTO> searchLstById(String id) {
        return lstLawGroupChapRepository.searchLstById(id);
    }

    public String checkSortField(String SortField) {
        if (!Strings.isNullOrEmpty(SortField)) {
            return SortField;
        } else {
            return "codeid";
        }
    }

    public String checkSortOrder(String SortOrder) {
        if (!Strings.isNullOrEmpty(SortOrder)) {
            return SortOrder;
        } else {
            return "ASC";
        }
    }

    @Override
    public String insertUpdate(LstLawGroupChapSave req, String username) {
        if ("I".equalsIgnoreCase(req.getAction())) return lstLawGroupChapRepository.insert(req, username);
        String respDel = deleteAll(req.getId());
        if (!StringCommon.isNullOrBlank(respDel)) return respDel;
        return lstLawGroupChapRepository.insertUpdate(req, username);
    }

    @Override
    public String delete(String id, String groupid) {
        return lstLawGroupChapRepository.delete(id,groupid);
    }

    @Override
    public String deleteAll(String id) {
        return lstLawGroupChapRepository.deleteAll(id);
    }

}
