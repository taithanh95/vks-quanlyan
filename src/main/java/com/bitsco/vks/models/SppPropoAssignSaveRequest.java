package com.bitsco.vks.models;

import com.bitsco.vks.entity.SppPropoAssignEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class SppPropoAssignSaveRequest implements Serializable {
    public SppPropoAssignEntity sppPropoAssign;
    public String sppId;
}
