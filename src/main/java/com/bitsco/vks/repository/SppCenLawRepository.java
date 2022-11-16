package com.bitsco.vks.repository;

import com.bitsco.vks.entity.LstLaw;
import com.bitsco.vks.models.SppCenLawDeleteRequest;
import com.bitsco.vks.models.SppCenLawSaveRequest;
import com.bitsco.vks.models.SppStattisticaSaveRequest;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppCenLawRepository {
    List<LinkedCaseInsensitiveMap> searchFromAccuUpdateInfo (String regicode, String centcode, String accucode, String userfor);

    String insertCenLawUpdateInfo(SppCenLawSaveRequest req, String userid);

    String deleteCenlaw(SppCenLawDeleteRequest req);

    String updateStatica(SppStattisticaSaveRequest req);

    List<LinkedCaseInsensitiveMap> searchCenLaw(int rowIndex, int pageSize, String sortField, String sortOrder, LstLaw lawFilters,
                                                String centcode, String regicode, String accucode, String userfor);

}
