package com.bitsco.vks.models;

import lombok.Data;

@Data
public class SppSpcPolSearchRequest extends BaseListRequest{
    public String regicode;
    public String casecode;
    public String userfor;
}
