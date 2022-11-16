package com.bitsco.vks.repository;

import com.bitsco.vks.models.SppEnforceSaveRequest;
import com.bitsco.vks.models.UpdateInfoG6SearchRequest;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppEnforcementRepository {
    String save(SppEnforceSaveRequest _obj, String username);

    String delete(String casecode, String regicode, String accucode, String transcode, String action);

}