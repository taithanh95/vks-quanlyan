package com.bitsco.vks.models;

import com.bitsco.vks.entity.SppAppeal;
import lombok.Data;

import java.io.Serializable;

@Data
public class SppAppealSaveResponse implements Serializable {
    public SppAppealSaveResponse(){super();}

    public String result;
    public SppAppeal sppAppeal;
}
