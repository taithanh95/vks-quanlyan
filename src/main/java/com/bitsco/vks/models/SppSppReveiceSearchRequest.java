package com.bitsco.vks.models;

import lombok.Data;

import java.util.Date;

@Data
public class SppSppReveiceSearchRequest extends BaseListRequest{
    public String casecode;
    public String casename;
    public Date fromdate;
    public Date todate;
    public String reveicetype;
    public String sppid;
    public String sppidf;
    public String sppname;
    public String transid;
    public int rowIndex;
    public int pageSize;
}
