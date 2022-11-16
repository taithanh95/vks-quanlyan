package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.MonitorEntity;
import com.bitsco.vks.models.MonitorRequest;
import com.bitsco.vks.repository.MonitorDecisonRepository;
import com.bitsco.vks.service.MonitorDecisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 21/07/2022
 * Time: 10:42 AM
 */
@Service
public class MonitorDecisonServiceImpl implements MonitorDecisonService {
    @Autowired
    MonitorDecisonRepository monitorDecisonRepository;

    @Override
    public List<MonitorEntity> monitorDecison1(MonitorRequest monitorRequest) throws Exception {
        return monitorDecisonRepository.monitorDecison1(monitorRequest);
    }

    @Override
    public List<MonitorEntity> monitorDecison2(MonitorRequest monitorRequest) throws Exception {
        return monitorDecisonRepository.monitorDecison2(monitorRequest);
    }

    @Override
    public List<MonitorEntity> monitorDecison3(MonitorRequest monitorRequest) throws Exception {
        return monitorDecisonRepository.monitorDecison3(monitorRequest);
    }

    @Override
    public List<MonitorEntity> monitorDecison4(MonitorRequest monitorRequest) throws Exception {
        return monitorDecisonRepository.monitorDecison4(monitorRequest);
    }

    @Override
    public List<MonitorEntity> monitorDecison5(MonitorRequest monitorRequest) throws Exception {
        return monitorDecisonRepository.monitorDecison5(monitorRequest);
    }
}
