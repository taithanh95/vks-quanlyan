package com.bitsco.vks.repository;

import com.bitsco.vks.entity.MonitorEntity;
import com.bitsco.vks.models.MonitorRequest;

import java.util.List;

public interface MonitorTransferRepository {

    //Cơ quan điều tra <-> Viện kiểm sát
    List<MonitorEntity> monitorTransferRepository_cqdt_vks(MonitorRequest req) throws Exception;
    //Viện kiểm sát <-> Viện kiểm sát
    List<MonitorEntity> monitorTransferRepository_vks_vks(MonitorRequest req) throws Exception;
    //Viện kiểm sát <-> Tòa án
    List<MonitorEntity> monitorTransferRepository_vks_ta(MonitorRequest req) throws Exception;


}
