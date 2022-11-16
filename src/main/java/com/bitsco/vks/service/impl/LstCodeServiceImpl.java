package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstCodeDTO;
import com.bitsco.vks.entity.LstCode;
import com.bitsco.vks.models.LstCodeRequest;
import com.bitsco.vks.repository.LstCodeRepository;
import com.bitsco.vks.service.LstCodeService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 11/05/2022
 * Time: 3:34 PM
 */
@Service
public class LstCodeServiceImpl implements LstCodeService {

    @Autowired
    private LstCodeRepository lstCodeRepository;

    @Override
    public List<LstCodeDTO> search(LstCodeRequest lstCodeRequest, Pageable pageable) {
        return lstCodeRepository.search(pageable.getPageNumber(), pageable.getPageSize(),
                checkSortField(lstCodeRequest.getSortField()), checkSortOrder(lstCodeRequest.getSortOrder()),
                lstCodeRequest.getCodeid(), lstCodeRequest.getCodename());
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
    public String insertUpdate(LstCode req, String username) {
        return lstCodeRepository.insertUpdate(req, username);
    }

    @Override
    public String delete(LstCode req) {
        return lstCodeRepository.delete(req);
    }

    @Override
    public List<LstCode> autocomplete(String query) {
        return lstCodeRepository.autocomplete(query, 10);
    }
}
