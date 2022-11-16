package com.bitsco.vks.service;

import com.bitsco.vks.entity.SppPenalty;
import com.bitsco.vks.models.SppJudgementSaveRequest;
import com.bitsco.vks.models.SppJudgementSaveResponse;
import com.bitsco.vks.models.UpdateInfoG6SearchRequest;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppExecutaJudgmentService {
    List<LinkedCaseInsensitiveMap> doSearch(UpdateInfoG6SearchRequest req);

}
