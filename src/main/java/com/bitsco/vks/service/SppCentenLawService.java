package com.bitsco.vks.service;

import com.bitsco.vks.models.SppCentenLawSaveRequest;
import com.bitsco.vks.models.SppCentenLawSearchRequest;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppCentenLawService {

    List<LinkedCaseInsensitiveMap> searchCentenLaw(String centcode);

    String insertCentenLawUpdateInfo(SppCentenLawSaveRequest req, String userid);

    List<LinkedCaseInsensitiveMap> searchList(SppCentenLawSearchRequest req);

}
