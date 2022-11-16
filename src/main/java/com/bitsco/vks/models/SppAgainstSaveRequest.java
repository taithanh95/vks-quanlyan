package com.bitsco.vks.models;

import com.bitsco.vks.entity.SppAgainst;
import lombok.Data;

import java.io.Serializable;

@Data
public class SppAgainstSaveRequest implements Serializable {
    public String action;
    public SppAgainst sppAgainst;
}
