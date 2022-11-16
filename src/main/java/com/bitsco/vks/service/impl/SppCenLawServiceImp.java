package com.bitsco.vks.service.impl;

import com.bitsco.vks.models.LstLawSearchRequest;
import com.bitsco.vks.models.SppCenLawDeleteRequest;
import com.bitsco.vks.models.SppCenLawSaveRequest;
import com.bitsco.vks.repository.SppCenLawRepository;
import com.bitsco.vks.service.SppCenLawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

@Service
public class SppCenLawServiceImp implements SppCenLawService {

    @Autowired
    private SppCenLawRepository sppCenLawRepository;

    @Override
    public List<LinkedCaseInsensitiveMap> searchFromAccuUpdateInfo(String regicode, String centcode, String accucode, String userfor) {
        return sppCenLawRepository.searchFromAccuUpdateInfo(regicode,centcode,accucode,userfor);
    }

    @Override
    public String insertCenLawUpdateInfo(SppCenLawSaveRequest req, String userid) {
        return sppCenLawRepository.insertCenLawUpdateInfo(req,userid);
    }

    @Override
    public String deleteCenlaw(SppCenLawDeleteRequest req) {
        return sppCenLawRepository.deleteCenlaw(req);
    }

    @Override
    public List<LinkedCaseInsensitiveMap> searchCenLaw(LstLawSearchRequest request) {
        return sppCenLawRepository.searchCenLaw(request.getPageindex(), request.getPagesize(), request.getSortField(),
                request.getSortOrder(), request.getLaw(),request.getCentcode(),request.getRegicode(),request.getAccucode(),request.getUserfor());
    }
}
