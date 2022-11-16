package com.bitsco.vks.service;

import com.bitsco.vks.models.SppJoinSaveRequest;
import com.bitsco.vks.models.SppJoinSearchRequest;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppJoinService {
    List<LinkedCaseInsensitiveMap> getList(SppJoinSearchRequest req);

    String save(SppJoinSaveRequest req);
}
