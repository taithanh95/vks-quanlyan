package com.bitsco.vks.models;

import lombok.Data;

import java.util.Date;

@Data
public class SppSppSendSearchNameRequest extends BaseListRequest{
    public String transid;
    public String sppid;
    public String casecode;
    public String query;
    public String userfor;
}
