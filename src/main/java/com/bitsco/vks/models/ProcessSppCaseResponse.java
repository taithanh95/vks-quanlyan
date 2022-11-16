package com.bitsco.vks.models;

import com.bitsco.vks.entity.SppCase;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProcessSppCaseResponse implements Serializable {
    public SppCase sppCase;
    public String result;
}
