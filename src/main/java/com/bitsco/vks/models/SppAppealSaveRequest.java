package com.bitsco.vks.models;

import com.bitsco.vks.entity.SppAppeal;
import lombok.Data;

import java.io.Serializable;

@Data
public class SppAppealSaveRequest implements Serializable {
    public String action;
    public String sppid;
    public SppAppeal sppAppeal;
}
