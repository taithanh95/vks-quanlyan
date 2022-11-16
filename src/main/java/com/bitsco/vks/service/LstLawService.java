package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstLawAutoCompleteDTO;
import com.bitsco.vks.dto.LstLawSearchDTO;
import com.bitsco.vks.entity.LstLaw;
import com.bitsco.vks.models.LstLawSearch1Request;
import org.springframework.data.domain.Pageable;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.sql.SQLException;
import java.util.List;

public interface LstLawService {
    List<LstLawAutoCompleteDTO> autocomplete(String query, String codeId) throws SQLException;

    List<LstLawAutoCompleteDTO> search(String query) throws SQLException;

    List<LstLawSearchDTO> searchLaw(Pageable pageable, LstLawSearch1Request lstLawSearch1Request);

    LinkedCaseInsensitiveMap get(String lawcode);

    String insert(LstLaw req, String username);

    String update(LstLaw req, String username);

    String delete(LstLaw req);
}

