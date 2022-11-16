package com.bitsco.vks.models;

import lombok.Data;

@Data
public class SppAppealSearchCaseRequest extends BaseListRequest{
    public String casecode;
    public String userfor;
    public String sppid;
}
