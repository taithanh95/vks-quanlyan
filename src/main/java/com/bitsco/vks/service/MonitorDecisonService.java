package com.bitsco.vks.service;

import com.bitsco.vks.entity.MonitorEntity;
import com.bitsco.vks.models.MonitorRequest;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 21/07/2022
 * Time: 10:41 AM
 */
public interface MonitorDecisonService {
    List<MonitorEntity> monitorDecison1(MonitorRequest monitorRequest) throws Exception;

    List<MonitorEntity> monitorDecison2(MonitorRequest monitorRequest) throws Exception;

    List<MonitorEntity> monitorDecison3(MonitorRequest monitorRequest) throws Exception;

    List<MonitorEntity> monitorDecison4(MonitorRequest monitorRequest) throws Exception;

    List<MonitorEntity> monitorDecison5(MonitorRequest monitorRequest) throws Exception;
}
