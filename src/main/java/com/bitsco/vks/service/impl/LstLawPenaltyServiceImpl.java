package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstLawPenaltyDTO;
import com.bitsco.vks.entity.LstLawPenalty;
import com.bitsco.vks.models.LstLawPenaltyRequest;
import com.bitsco.vks.repository.LstLawPenaltyRepository;
import com.bitsco.vks.service.LstLawPenaltyService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 17/05/2022
 * Time: 2:04 PM
 */
@Service
public class LstLawPenaltyServiceImpl implements LstLawPenaltyService {
    @Autowired
    private LstLawPenaltyRepository lstLawPenaltyRepository;

    @Override
    public List<LstLawPenaltyDTO> search(LstLawPenaltyRequest lstLawPenaltyRequest, Pageable pageable) {
        return lstLawPenaltyRepository.search(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                checkSortField(lstLawPenaltyRequest.getSortField()),
                checkSortOrder(lstLawPenaltyRequest.getSortOrder()),
                lstLawPenaltyRequest.getLawid(),
                lstLawPenaltyRequest.getItem(),
                lstLawPenaltyRequest.getPoint(),
                lstLawPenaltyRequest.getLawname(),
                lstLawPenaltyRequest.getCodeid(),
                lstLawPenaltyRequest.getGroupid()
        );
    }

    public String checkSortField(String SortField) {
        if (!Strings.isNullOrEmpty(SortField)) {
            return SortField;
        } else {
            return "penaltyid";
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
    public String insertUpdate(LstLawPenalty req) {
        return lstLawPenaltyRepository.insertUpdate(req);
    }

    @Override
    public String delete(LstLawPenalty req) {
        return lstLawPenaltyRepository.delete(req);
    }
}
