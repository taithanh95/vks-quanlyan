package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.MonitorEntity;
import com.bitsco.vks.models.MonitorRequest;
import com.bitsco.vks.repository.MonitorVerifyRepository;
import com.bitsco.vks.service.MonitorVerifyService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorVerifyServiceImpl implements MonitorVerifyService {
    @Autowired
    MonitorVerifyRepository monitorVerifyRepository;
    @Override
    public List<MonitorEntity> getList(MonitorRequest req) throws Exception {
        return monitorVerifyRepository.getList(req);
    }


}
