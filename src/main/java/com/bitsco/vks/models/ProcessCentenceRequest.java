package com.bitsco.vks.models;

import com.bitsco.vks.entity.SppCentence;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProcessCentenceRequest implements Serializable {
    public String action;
    public SppCentence centence;
    public String sppId;
}
