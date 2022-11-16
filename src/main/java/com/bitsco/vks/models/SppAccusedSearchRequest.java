package com.bitsco.vks.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class SppAccusedSearchRequest extends BaseListRequest {
    public String casecode;
    public String regicode;
    public String sppid;
}
