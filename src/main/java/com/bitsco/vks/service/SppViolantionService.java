package com.bitsco.vks.service;

import com.bitsco.vks.entity.SppViolantion;

import java.util.List;

public interface SppViolantionService {
    void save(SppViolantion sppViolantion);

    List<SppViolantion> getSppViolantionByAccucode(String accucode);

    void deleteById(Long id);
}
