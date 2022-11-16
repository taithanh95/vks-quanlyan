package com.bitsco.vks.service;

import com.bitsco.vks.entity.LstLaw;
import com.bitsco.vks.models.LstLawSearchRequest;
import com.bitsco.vks.models.SppCenLawDeleteRequest;
import com.bitsco.vks.models.SppCenLawSaveRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppCenLawService {

    List<LinkedCaseInsensitiveMap> searchFromAccuUpdateInfo(String regicode, String centcode, String accucode, String userfor);

    String insertCenLawUpdateInfo(SppCenLawSaveRequest req, String userid);

    String deleteCenlaw(SppCenLawDeleteRequest req);

    List<LinkedCaseInsensitiveMap> searchCenLaw(LstLawSearchRequest request);

}
