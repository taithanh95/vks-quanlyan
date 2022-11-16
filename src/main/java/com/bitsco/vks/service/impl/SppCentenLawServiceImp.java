package com.bitsco.vks.service.impl;

import com.bitsco.vks.models.SppCentenLawSaveRequest;
import com.bitsco.vks.models.SppCentenLawSearchRequest;
import com.bitsco.vks.repository.SppCentenLawRepository;
import com.bitsco.vks.service.SppCentenLawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

@Service
public class SppCentenLawServiceImp implements SppCentenLawService {

    @Autowired
    private SppCentenLawRepository sppCentenLawRepository;

    @Override
    public String insertCentenLawUpdateInfo(SppCentenLawSaveRequest req, String username) {
        return sppCentenLawRepository.insertOrDelCentenLawUpdateInfo(req,username);
    }

    @Override
    public List<LinkedCaseInsensitiveMap> searchList(SppCentenLawSearchRequest req) {
        return sppCentenLawRepository.searchList(
                req.getCentcode(),req.getLaw(),req.pageindex,req.pagesize,req.getSortField(),req.getSortOrder());
    }

    @Override
    public List<LinkedCaseInsensitiveMap> searchCentenLaw(String centcode) {
        return sppCentenLawRepository.searchCentenLaw(centcode);
    }
}
