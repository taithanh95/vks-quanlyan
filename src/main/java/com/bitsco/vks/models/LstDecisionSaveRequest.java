package com.bitsco.vks.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class LstDecisionSaveRequest implements Serializable {
    private String action;
    private String type_ins;
    private String deciid;
    private String deciname;
    private String applyfor;
    private String settime;
    private String setunit;
    private String applyfinish;
    private String userfortempl;
    private String status;
    private String decitypeid;
    private String decitemp;
    private int decilevel;
    private boolean limittime;
}
