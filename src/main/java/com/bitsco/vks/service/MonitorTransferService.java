package com.bitsco.vks.service;

import com.bitsco.vks.entity.MonitorEntity;
import com.bitsco.vks.models.MonitorRequest;

import java.util.List;

public interface MonitorTransferService {
    //Cơ quan điều tra <-> Viện kiểm sát
    List<MonitorEntity> monitorTransferService_cqdt_vks(MonitorRequest req) throws Exception;
    //Viện kiểm sát <-> Viện kiểm sát
    List<MonitorEntity> monitorTransferService_vks_vks(MonitorRequest req) throws Exception;
    //Viện kiểm sát <-> Tòa án
    List<MonitorEntity> monitorTransferService_vks_ta(MonitorRequest req) throws Exception;
}
