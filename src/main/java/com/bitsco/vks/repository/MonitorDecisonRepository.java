package com.bitsco.vks.repository;

import com.bitsco.vks.entity.MonitorEntity;
import com.bitsco.vks.models.MonitorRequest;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 21/07/2022
 * Time: 10:30 AM
 */
public interface MonitorDecisonRepository {
    List<MonitorEntity> monitorDecison1(MonitorRequest req) throws Exception;

    List<MonitorEntity> monitorDecison2(MonitorRequest req) throws Exception;

    List<MonitorEntity> monitorDecison3(MonitorRequest req) throws Exception;

    List<MonitorEntity> monitorDecison4(MonitorRequest req) throws Exception;

    List<MonitorEntity> monitorDecison5(MonitorRequest req) throws Exception;
}
