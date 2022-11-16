package com.bitsco.vks.models;

import com.bitsco.vks.entity.SppCentence;
import lombok.Data;

import java.io.Serializable;

@Data
public class SppCentenceDeleteRequest implements Serializable {
    public String regicode;
    public SppCentence centence;
    public String conclusionId;
    public String userId;
    public String sppId;
}
