package com.bitsco.vks.service.impl;

import com.bitsco.vks.repository.SppDamagedDAO;
import com.bitsco.vks.request.SppDamagedRequest;
import com.bitsco.vks.response.SppDamagedResponse;
import com.bitsco.vks.service.SppDamagedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SppDamagedServiceImpl implements SppDamagedService {
    @Autowired
    SppDamagedDAO sppDamagedDAO;

    @Override
    public void insertUpdate(SppDamagedRequest sppDamagedRequest) {
        sppDamagedDAO.insertUpdate(sppDamagedRequest);
    }

    @Override
    public void deleteByID(SppDamagedRequest sppDamagedRequest) {
        sppDamagedDAO.deleteByID(sppDamagedRequest);
    }

    @Override
    public List<SppDamagedResponse> getByCaseCode(SppDamagedRequest sppDamagedRequest) {
        return sppDamagedDAO.getByCaseCode(sppDamagedRequest);
    }
}
