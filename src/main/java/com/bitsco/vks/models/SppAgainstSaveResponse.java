package com.bitsco.vks.models;

import com.bitsco.vks.entity.SppAgainst;
import lombok.Data;

import java.io.Serializable;

@Data
public class SppAgainstSaveResponse implements Serializable {
    public SppAgainstSaveResponse(){super();}
    public SppAgainst sppAgainst;
    public String result;
    public String warning;
}
