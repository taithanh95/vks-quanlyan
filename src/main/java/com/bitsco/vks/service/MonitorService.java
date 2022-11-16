package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstLawGroupChapDTO;
import com.bitsco.vks.entity.MonitorEntity;
import com.bitsco.vks.models.MonitorRequest;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 04/07/2022
 * Time: 1:47 PM
 */
public interface MonitorService {
    List<MonitorEntity> monitorRegister(MonitorRequest monitorRequest) throws Exception;

    List<LstLawGroupChapDTO> getLstLawGroupChap() throws Exception;

    List<MonitorEntity> monitorCase1(MonitorRequest monitorRequest) throws Exception;

    List<MonitorEntity> monitorCase2(MonitorRequest monitorRequest) throws Exception;

    List<MonitorEntity> monitorCase3(MonitorRequest monitorRequest) throws Exception;

    List<MonitorEntity> monitorCase4(MonitorRequest monitorRequest) throws Exception;

    List<MonitorEntity> monitorCase5(MonitorRequest monitorRequest) throws Exception;

    List<MonitorEntity> monitorCase6(MonitorRequest monitorRequest) throws Exception;

    List<MonitorEntity> monitorCase7(MonitorRequest monitorRequest) throws Exception;

    List<MonitorEntity> monitorCase8(MonitorRequest monitorRequest) throws Exception;

    List<MonitorEntity> monitorCase9(MonitorRequest monitorRequest) throws Exception;

    List<MonitorEntity> monitorLaw(MonitorRequest monitorRequest) throws Exception;

    List<MonitorEntity> monitorPenalty(MonitorRequest monitorRequest) throws Exception;

    List<MonitorEntity> monitorAgainst(MonitorRequest monitorRequest) throws Exception;

    List<MonitorEntity> monitorAppeal(MonitorRequest monitorRequest) throws Exception;
}
