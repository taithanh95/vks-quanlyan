package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.SppViolantion;
import com.bitsco.vks.repository.SppViolantionDAO;
import com.bitsco.vks.service.SppViolantionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SppViolantionServiceImpl implements SppViolantionService {
    @Autowired
    private SppViolantionDAO sppViolantionDAO;

    @Override
    public void save(SppViolantion sppViolantion) {
        sppViolantionDAO.save(sppViolantion);
    }

    @Override
    public List<SppViolantion> getSppViolantionByAccucode(String accucode) {
        return sppViolantionDAO.getSppViolantionByAccucode(accucode);
    }

    @Override
    public void deleteById(Long id) {
        sppViolantionDAO.deleteById(id);
    }
}
