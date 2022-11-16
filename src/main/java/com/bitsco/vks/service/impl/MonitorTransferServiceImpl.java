package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.MonitorEntity;
import com.bitsco.vks.models.MonitorRequest;
import com.bitsco.vks.repository.MonitorTransferRepository;
import com.bitsco.vks.service.MonitorTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorTransferServiceImpl implements MonitorTransferService {
    @Autowired
    MonitorTransferRepository monitorTransferRepository;

    @Override
    public List<MonitorEntity> monitorTransferService_cqdt_vks(MonitorRequest req) throws Exception {
        return monitorTransferRepository.monitorTransferRepository_cqdt_vks(req);
    }

    @Override
    public List<MonitorEntity> monitorTransferService_vks_vks(MonitorRequest req) throws Exception {
        return monitorTransferRepository.monitorTransferRepository_vks_vks(req);
    }

    @Override
    public List<MonitorEntity> monitorTransferService_vks_ta(MonitorRequest req) throws Exception {
        return monitorTransferRepository.monitorTransferRepository_vks_ta(req);
    }
}
