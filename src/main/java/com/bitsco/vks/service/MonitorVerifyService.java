package com.bitsco.vks.service;

import com.bitsco.vks.entity.MonitorEntity;
import com.bitsco.vks.models.MonitorRequest;

import java.util.List;

public interface MonitorVerifyService {
    List<MonitorEntity> getList(MonitorRequest req) throws Exception;

}
