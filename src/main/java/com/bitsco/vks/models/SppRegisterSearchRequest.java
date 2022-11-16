package com.bitsco.vks.models;

import lombok.Data;

@Data
public class SppRegisterSearchRequest extends BaseListRequest {
    public String casecode;
    public String usefor;
    public String csppid;
}
