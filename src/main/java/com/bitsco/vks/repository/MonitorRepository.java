package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstLawGroupChapDTO;
import com.bitsco.vks.entity.MonitorEntity;
import com.bitsco.vks.models.MonitorRequest;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 04/07/2022
 * Time: 11:11 AM
 */
public interface MonitorRepository {
    List<MonitorEntity> monitorRegister(MonitorRequest req) throws Exception;

    List<LstLawGroupChapDTO> getLstLawGroupChap() throws Exception;

    List<MonitorEntity> monitorCase1(MonitorRequest req) throws Exception;

    List<MonitorEntity> monitorCase2(MonitorRequest req) throws Exception;

    List<MonitorEntity> monitorCase3(MonitorRequest req) throws Exception;

    List<MonitorEntity> monitorCase4(MonitorRequest req) throws Exception;

    List<MonitorEntity> monitorCase5(MonitorRequest req) throws Exception;

    List<MonitorEntity> monitorCase6(MonitorRequest req) throws Exception;

    List<MonitorEntity> monitorCase7(MonitorRequest req) throws Exception;

    List<MonitorEntity> monitorCase8(MonitorRequest req) throws Exception;

    List<MonitorEntity> monitorCase9(MonitorRequest req) throws Exception;

    List<MonitorEntity> monitorLaw(MonitorRequest req) throws Exception;

    List<MonitorEntity> monitorPenalty(MonitorRequest req) throws Exception;

    List<MonitorEntity> monitorAgainst(MonitorRequest req) throws Exception;

    List<MonitorEntity> monitorAppeal(MonitorRequest req) throws Exception;
}
