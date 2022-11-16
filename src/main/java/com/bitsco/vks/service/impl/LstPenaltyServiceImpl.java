package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstPenaltyDTO;
import com.bitsco.vks.entity.LstPenalty;
import com.bitsco.vks.models.LstPenaltyRequest;
import com.bitsco.vks.repository.LstPenaltyRepository;
import com.bitsco.vks.service.LstPenaltyService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 17/05/2022
 * Time: 10:00 AM
 */
@Service
public class LstPenaltyServiceImpl implements LstPenaltyService {
    @Autowired
    private LstPenaltyRepository lstPenaltyRepository;

    @Override
    public List<LstPenaltyDTO> search(LstPenaltyRequest lstPenaltyRequest, Pageable pageable) {
        return lstPenaltyRepository.search(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                checkSortField(lstPenaltyRequest.getSortField()),
                checkSortOrder(lstPenaltyRequest.getSortOrder()),
                lstPenaltyRequest.getPenaltyid(),
                lstPenaltyRequest.getPenaltyname(),
                lstPenaltyRequest.getPenaltyfor()
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
    public String insertUpdate(LstPenalty req, String username) {
        return lstPenaltyRepository.insertUpdate(req, username);
    }

    @Override
    public String delete(LstPenalty req) {
        return lstPenaltyRepository.delete(req);
    }

    @Override
    public List<LstPenalty> getListPenalty(String query) {
        return lstPenaltyRepository.getListPenalty(query, 10);
    }
}
