package com.bitsco.vks.repository;

import com.bitsco.vks.models.SppJoinSaveRequest;
import com.bitsco.vks.models.SppJoinSearchRequest;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppJoinRepository {
    List<LinkedCaseInsensitiveMap> getList(SppJoinSearchRequest req);

    String save(SppJoinSaveRequest req);
}
