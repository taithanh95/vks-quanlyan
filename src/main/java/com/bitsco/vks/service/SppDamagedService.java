package com.bitsco.vks.service;

import com.bitsco.vks.request.SppDamagedRequest;
import com.bitsco.vks.response.SppDamagedResponse;

import java.util.List;

public interface SppDamagedService {
    void insertUpdate(SppDamagedRequest sppDamagedRequest);
    void deleteByID(SppDamagedRequest sppDamagedRequest);
    List<SppDamagedResponse> getByCaseCode(SppDamagedRequest sppDamagedRequest);
}
