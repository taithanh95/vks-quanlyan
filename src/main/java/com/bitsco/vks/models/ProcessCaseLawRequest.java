package com.bitsco.vks.models;

import com.bitsco.vks.entity.SppCase;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProcessCaseLawRequest implements Serializable {
    public SppCase sppCase;
    public String action;
    public  String lawCode;
    public  String sppId;
    public String userfor;
}
