package com.bitsco.vks.models;

import lombok.Data;

import java.util.Date;

@Data
public class SppSppSendSearchRequest extends BaseListRequest{
    public String casecode;
    public String casename;
    public Date fromdate;
    public Date todate;
    public String sendtype;
    public String sppid;
    public String sppname;
    public int rowIndex;
    public int pageSize;
}
