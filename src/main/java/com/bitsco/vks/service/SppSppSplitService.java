package com.bitsco.vks.service;

import com.bitsco.vks.dto.RequestSaveListSplitDTO;
import com.bitsco.vks.dto.RequestSearchSplitDTO;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppSppSplitService {
    List<LinkedCaseInsensitiveMap> search(RequestSearchSplitDTO req);

    String insertOrUpdate(RequestSaveListSplitDTO req, String username);

    String delete(RequestSaveListSplitDTO req, String choiceType);
}
