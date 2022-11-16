package com.bitsco.vks.repository;

import com.bitsco.vks.models.UpdateInfoG6SearchRequest;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppExecutaJudgmentRepository {
    List<LinkedCaseInsensitiveMap> search(int rowIndex, int pageSize, UpdateInfoG6SearchRequest _obj);

}
