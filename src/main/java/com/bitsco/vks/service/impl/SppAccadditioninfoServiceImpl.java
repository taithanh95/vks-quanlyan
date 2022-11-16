package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.SppAccadditioninfo;
import com.bitsco.vks.repository.SppAccadditioninfoDAO;
import com.bitsco.vks.service.SppAccadditioninfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SppAccadditioninfoServiceImpl implements SppAccadditioninfoService {
    @Autowired
    private SppAccadditioninfoDAO sppAccadditioninfoDAO;

    @Override
    public SppAccadditioninfo getByAccucode(String accucode) {
        return sppAccadditioninfoDAO.getByAccucode(accucode);
    }
}
