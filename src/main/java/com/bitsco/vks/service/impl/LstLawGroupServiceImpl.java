package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstLawGroupDTO;
import com.bitsco.vks.entity.LstLawGroup;
import com.bitsco.vks.models.LstLawGroupRequest;
import com.bitsco.vks.repository.LstLawGroupRepository;
import com.bitsco.vks.service.LstLawGroupService;
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
public class LstLawGroupServiceImpl implements LstLawGroupService {

    @Autowired
    private LstLawGroupRepository lstLawGroupRepository;

    @Override
    public List<LstLawGroupDTO> search(LstLawGroupRequest lstLawGroupRequest, Pageable pageable) {
        return lstLawGroupRepository.search(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                checkSortField(lstLawGroupRequest.getSortField()),
                checkSortOrder(lstLawGroupRequest.getSortOrder()),
                lstLawGroupRequest.getGroupid(),
                lstLawGroupRequest.getGroupname(),
                lstLawGroupRequest.getCodeid());
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
    public String insertUpdate(LstLawGroup req, String username) {
        return lstLawGroupRepository.insertUpdate(req, username);
    }

    @Override
    public String delete(LstLawGroup req) {
        return lstLawGroupRepository.delete(req);
    }
}
