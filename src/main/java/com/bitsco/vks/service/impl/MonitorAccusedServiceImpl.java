package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.MonitorEntity;
import com.bitsco.vks.models.MonitorRequest;
import com.bitsco.vks.repository.MonitorAccusedRepository;
import com.bitsco.vks.service.MonitorAccusedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MonitorAccusedServiceImpl implements MonitorAccusedService {
    @Autowired
    MonitorAccusedRepository monitorAccusedRepository;
    @Override
    public List<MonitorEntity> MonitorAccusedService_1(MonitorRequest monitorRequest) throws Exception {
        return monitorAccusedRepository.monitorAccusedRepository_1(monitorRequest);
    }
    @Override
    public List<MonitorEntity> MonitorAccusedService_2(MonitorRequest monitorRequest) throws Exception {
        return monitorAccusedRepository.monitorAccusedRepository_2(monitorRequest);
    }
    @Override
    public List<MonitorEntity> MonitorAccusedService_3(MonitorRequest monitorRequest) throws Exception {
        return monitorAccusedRepository.monitorAccusedRepository_3(monitorRequest);
    }
    @Override
    public List<MonitorEntity> MonitorAccusedService_4(MonitorRequest monitorRequest) throws Exception {
        return monitorAccusedRepository.monitorAccusedRepository_4(monitorRequest);
    }
    @Override
    public List<MonitorEntity> MonitorAccusedService_5(MonitorRequest monitorRequest) throws Exception {
        return monitorAccusedRepository.monitorAccusedRepository_5(monitorRequest);
    }
    @Override
    public List<MonitorEntity> MonitorAccusedService_6(MonitorRequest monitorRequest) throws Exception {
        return monitorAccusedRepository.monitorAccusedRepository_6(monitorRequest);
    }
    @Override
    public List<MonitorEntity> MonitorAccusedService_7(MonitorRequest monitorRequest) throws Exception {
        return monitorAccusedRepository.monitorAccusedRepository_7(monitorRequest);
    }
    @Override
    public List<MonitorEntity> MonitorAccusedService_8(MonitorRequest monitorRequest) throws Exception {
        return monitorAccusedRepository.monitorAccusedRepository_8(monitorRequest);
    }
    @Override
    public List<MonitorEntity> MonitorAccusedService_11(MonitorRequest monitorRequest) throws Exception {
        return monitorAccusedRepository.monitorAccusedRepository_11(monitorRequest);
    }
}
