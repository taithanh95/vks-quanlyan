package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstLawGroupChapDTO;
import com.bitsco.vks.entity.MonitorEntity;
import com.bitsco.vks.models.MonitorRequest;
import com.bitsco.vks.repository.MonitorRepository;
import com.bitsco.vks.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 04/07/2022
 * Time: 1:47 PM
 */

@Service
public class MonitorServiceImpl implements MonitorService {
    @Autowired
    MonitorRepository monitorRepository;

    @Override
    public List<MonitorEntity> monitorRegister(MonitorRequest monitorRequest) throws Exception {
        return monitorRepository.monitorRegister(monitorRequest);
    }

    @Override
    public List<LstLawGroupChapDTO> getLstLawGroupChap() throws Exception {
        return monitorRepository.getLstLawGroupChap();
    }

    @Override
    public List<MonitorEntity> monitorCase1(MonitorRequest monitorRequest) throws Exception {
        return monitorRepository.monitorCase1(monitorRequest);
    }

    @Override
    public List<MonitorEntity> monitorCase2(MonitorRequest monitorRequest) throws Exception {
        return monitorRepository.monitorCase2(monitorRequest);
    }

    @Override
    public List<MonitorEntity> monitorCase3(MonitorRequest monitorRequest) throws Exception {
        return monitorRepository.monitorCase3(monitorRequest);
    }

    @Override
    public List<MonitorEntity> monitorCase4(MonitorRequest monitorRequest) throws Exception {
        return monitorRepository.monitorCase4(monitorRequest);
    }

    @Override
    public List<MonitorEntity> monitorCase5(MonitorRequest monitorRequest) throws Exception {
        return monitorRepository.monitorCase5(monitorRequest);
    }

    @Override
    public List<MonitorEntity> monitorCase6(MonitorRequest monitorRequest) throws Exception {
        return monitorRepository.monitorCase6(monitorRequest);
    }

    @Override
    public List<MonitorEntity> monitorCase7(MonitorRequest monitorRequest) throws Exception {
        return monitorRepository.monitorCase7(monitorRequest);
    }

    @Override
    public List<MonitorEntity> monitorCase8(MonitorRequest monitorRequest) throws Exception {
        return monitorRepository.monitorCase8(monitorRequest);
    }

    @Override
    public List<MonitorEntity> monitorCase9(MonitorRequest monitorRequest) throws Exception {
        return monitorRepository.monitorCase9(monitorRequest);
    }

    @Override
    public List<MonitorEntity> monitorLaw(MonitorRequest monitorRequest) throws Exception {
        return monitorRepository.monitorLaw(monitorRequest);
    }

    @Override
    public List<MonitorEntity> monitorPenalty(MonitorRequest monitorRequest) throws Exception {
        return monitorRepository.monitorPenalty(monitorRequest);
    }

    @Override
    public List<MonitorEntity> monitorAgainst(MonitorRequest monitorRequest) throws Exception {
        return monitorRepository.monitorAgainst(monitorRequest);
    }

    @Override
    public List<MonitorEntity> monitorAppeal(MonitorRequest monitorRequest) throws Exception {
        return monitorRepository.monitorAppeal(monitorRequest);
    }
}
