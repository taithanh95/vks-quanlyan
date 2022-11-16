package com.bitsco.vks.repository;

import com.bitsco.vks.dto.RequestSaveSplitDTO;
import com.bitsco.vks.dto.RequestSearchSplitDTO;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppSppSplitRepository {
    List<LinkedCaseInsensitiveMap> searchCase(RequestSearchSplitDTO req);

    List<LinkedCaseInsensitiveMap> searchCase1(RequestSearchSplitDTO req);

    List<LinkedCaseInsensitiveMap> searchCaseSplit(RequestSearchSplitDTO req);

    List<LinkedCaseInsensitiveMap> searchSplit(RequestSearchSplitDTO req);

    List<LinkedCaseInsensitiveMap> searchAccuSplit(RequestSearchSplitDTO req);

    String insertUpdateAccSpilit(RequestSaveSplitDTO req, String username, String choice, String choiceType);

    String deleteAccSpilit(RequestSaveSplitDTO req, String choiceType);

}
