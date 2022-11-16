package com.bitsco.vks.repository;

import com.bitsco.vks.entity.LstLaw;
import com.bitsco.vks.models.SppCentenLawSaveRequest;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppCentenLawRepository {

    String insertOrDelCentenLawUpdateInfo(SppCentenLawSaveRequest req, String username);

    List<LinkedCaseInsensitiveMap> searchCentenLaw(String centcode);

    List<LinkedCaseInsensitiveMap> searchList(String centcode, LstLaw req, int index, int pageSize, String sortField, String sortOrder);

}
