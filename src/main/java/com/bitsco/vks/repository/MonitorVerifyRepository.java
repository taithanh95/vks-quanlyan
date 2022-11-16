package com.bitsco.vks.repository;

import com.bitsco.vks.entity.MonitorEntity;
import com.bitsco.vks.models.MonitorRequest;

import java.util.List;

public interface MonitorVerifyRepository {
    List<MonitorEntity> getList(MonitorRequest req) throws Exception;

}
