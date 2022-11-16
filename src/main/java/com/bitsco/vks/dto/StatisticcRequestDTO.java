package com.bitsco.vks.dto;

import com.bitsco.vks.models.BaseListRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class StatisticcRequestDTO extends BaseListRequest {
    private String action;
    private String statid;
    private String status;
    private String statname;
    private BigDecimal valmax;
    private BigDecimal valmin;
}
