package com.bitsco.vks.models;

import com.bitsco.vks.entity.LstLaw;
import com.bitsco.vks.entity.SppCase;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateCaseLawWithWarnRequest implements Serializable {
    public SppCase sppCase;
    public LstLaw lstLaw;
    public String sppId;
}
