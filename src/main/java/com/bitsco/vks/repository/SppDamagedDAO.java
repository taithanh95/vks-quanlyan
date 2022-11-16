package com.bitsco.vks.repository;

import com.bitsco.vks.request.SppDamagedRequest;
import com.bitsco.vks.response.SppDamagedResponse;

import java.util.List;

public interface SppDamagedDAO {
    void insertUpdate(SppDamagedRequest sppDamagedRequest);
    void deleteByID(SppDamagedRequest sppDamagedRequest);
    List<SppDamagedResponse> getByCaseCode(SppDamagedRequest sppDamagedRequest);
}
