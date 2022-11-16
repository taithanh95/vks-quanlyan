package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstConclusionAutoCompleteDTO;
import com.bitsco.vks.dto.LstConclusionSearchDTO;
import com.bitsco.vks.models.LstConclusionRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstConclusionService {
    List<LstConclusionSearchDTO> search(LstConclusionRequest lstConclusionRequest, Pageable pageable);

    List<LstConclusionAutoCompleteDTO> autocomplete(String query, String usefor);

    LstConclusionSearchDTO getConclu(String concid);

    String save(LstConclusionRequest req, String username);

    String delete(String concid);
}
