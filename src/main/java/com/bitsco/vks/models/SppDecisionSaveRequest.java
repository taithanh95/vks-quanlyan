package com.bitsco.vks.models;

import com.bitsco.vks.entity.SppDecision;
import lombok.Data;

import java.io.Serializable;

@Data
public class SppDecisionSaveRequest implements Serializable {
    public String action;
    public SppDecision decision;
    public String sppid;
}
