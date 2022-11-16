package com.bitsco.vks.models;

import lombok.Data;

@Data
public class SppAgainstSearchCaseRequest extends BaseListRequest {
    public String casecode;
    public String userfor;
    public String sppid;
}
