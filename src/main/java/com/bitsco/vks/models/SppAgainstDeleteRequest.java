package com.bitsco.vks.models;

import com.bitsco.vks.entity.SppAgainst;
import lombok.Data;

import java.io.Serializable;

@Data
public class SppAgainstDeleteRequest implements Serializable {
    public SppAgainst sppAgainst;
    public String sppid;
}
