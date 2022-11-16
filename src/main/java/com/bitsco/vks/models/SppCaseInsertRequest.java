package com.bitsco.vks.models;

import com.bitsco.vks.entity.SppCase;
import lombok.Data;

import java.io.Serializable;

@Data
public class SppCaseInsertRequest implements Serializable {
    public String sppId;
    public String userId;
    public SppCase sppcase;
    public Boolean withWarn;
    public Boolean isTachvu;
}
