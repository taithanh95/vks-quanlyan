package com.bitsco.vks.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SppEnforceSaveRequest implements Serializable  {
    public String action;
    public String transcode;
    public String regicode;
    public String accucode;
    public Date transdate;
    public String sppidf;
    public String sppidt;
    public String sender;
    public String remark;
    public Date acceptdate;
    public String casecode;
    public String accuname;
    public String casename;
    public String result;
    public Date decidate;
    public String decicode;
    public String receipter;
    public String reason;


}
