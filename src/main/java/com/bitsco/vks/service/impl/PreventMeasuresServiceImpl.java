package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.PreventMeasures;
import com.bitsco.vks.repository.PreventMeasuresRepository;
import com.bitsco.vks.service.PreventMeasuresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 20/01/2022
 * Time: 4:54 PM
 */
@Service
public class PreventMeasuresServiceImpl implements PreventMeasuresService {
    @Autowired
    PreventMeasuresRepository preventMeasuresRepository;

    @Override
    public List<PreventMeasures> search(PreventMeasures preventMeasures) {
        return preventMeasuresRepository.search(preventMeasures);
    }

    @Override
    public String insertOrUpdate(PreventMeasures preventMeasures, String username) {
        return preventMeasuresRepository.insertOrUpdate(preventMeasures, username);
    }

    @Override
    public String delete(String accucode) {
        return preventMeasuresRepository.delete(accucode);
    }
}
