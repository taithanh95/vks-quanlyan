package com.bitsco.vks.dto;

import com.bitsco.vks.models.BaseListRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StatisticaRequestDTO extends BaseListRequest {
    private String action;
    private String statid;
    private String status;
    private String statname;
    private String children;
    private String adult;
}
