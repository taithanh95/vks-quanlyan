package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstLawAutoCompleteDTO;
import com.bitsco.vks.dto.LstLawSearchDTO;
import com.bitsco.vks.entity.LstLaw;
import com.bitsco.vks.models.LstLawSearch1Request;
import com.bitsco.vks.repository.LstLawRepository;
import com.bitsco.vks.service.LstLawService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.sql.SQLException;
import java.util.List;

@Service
public class LstLawServiceImpl implements LstLawService {
    @Autowired
    LstLawRepository lstLawRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstLawAutoCompleteDTO> autocomplete(String query, String codeId) throws SQLException {
        return lstLawRepository.autocomplete(query, codeId, 10);
    }
    @Override
    @Transactional(readOnly = true)
    public List<LstLawAutoCompleteDTO> search(String query) throws SQLException {
        return lstLawRepository.search(query, 10);
    }

    @Override
    public List<LstLawSearchDTO> searchLaw(Pageable pageable, LstLawSearch1Request lstLawSearch1Request) {
        return lstLawRepository.searchLaw(pageable.getPageNumber(), pageable.getPageSize(), lstLawSearch1Request.getSortField(), checkSortOrder(lstLawSearch1Request.getSortOrder()), lstLawSearch1Request.getLawId(), lstLawSearch1Request.getItem(), lstLawSearch1Request.getPoint(), lstLawSearch1Request.getLawName(), lstLawSearch1Request.getGroupId(), lstLawSearch1Request.getCodeId());
    }

    @Override
    public LinkedCaseInsensitiveMap get(String lawcode) {
        return lstLawRepository.get(lawcode);
    }

    public String checkSortOrder(String SortOrder) {
        if (!Strings.isNullOrEmpty(SortOrder)) {
            return SortOrder;
        } else {
            return "ASC";
        }
    }

    @Override
    public String insert(LstLaw req, String username) {
        return lstLawRepository.insert(req, username, "I");
    }

    @Override
    public String update(LstLaw req, String username) {
        return lstLawRepository.update(req, username, "U");
    }

    @Override
    public String delete(LstLaw req) {
        return lstLawRepository.delete(req);
    }
}
