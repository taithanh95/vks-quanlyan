package com.bitsco.vks.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SppEnforceDeleteRequest implements Serializable  {
    public String action;
    public String transcode;
    public String regicode;
    public String accucode;
    public String casecode;

}
