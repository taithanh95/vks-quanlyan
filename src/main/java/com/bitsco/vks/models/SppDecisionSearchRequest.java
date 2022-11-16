package com.bitsco.vks.models;

import lombok.Data;

@Data
public class SppDecisionSearchRequest extends BaseListRequest {
    public String regicode;
    public String applyfor;
    public String casecode;
    public String usefor;
}
