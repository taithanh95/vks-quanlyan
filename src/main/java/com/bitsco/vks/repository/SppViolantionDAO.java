package com.bitsco.vks.repository;

import com.bitsco.vks.entity.SppViolantion;

import java.util.List;

public interface SppViolantionDAO {
    void save(SppViolantion sppViolantion);

    List<SppViolantion> getSppViolantionByAccucode(String accucode);

    void deleteById(Long id);
}
