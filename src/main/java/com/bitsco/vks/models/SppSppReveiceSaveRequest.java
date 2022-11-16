package com.bitsco.vks.models;

import lombok.Data;

import java.util.Date;

@Data
public class SppSppReveiceSaveRequest extends BaseListRequest{
    public String action;
    public String transcode;
    public String regicode;
    public String casecode;
    public Date transdate;
    public Date acceptdate;
    public String sppidf;
    public String sppidt;
    public String sender;
    public String receipter;
    public String userfor;
    public String remark;
    public String transid;
}
