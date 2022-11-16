package com.bitsco.vks.models;

import com.bitsco.vks.entity.SppAccused;
import com.bitsco.vks.entity.SppCase;
import com.bitsco.vks.entity.SppCentence;
import com.bitsco.vks.entity.SppRegister;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateInfoRequest implements Serializable {
    public String sppId;
    public int rowIndex;
    public int pageSize;
    public String sortField;
    public String sortOrder;
    public SppCase sppcase;
    public SppAccused accused;
    public SppRegister register;
    public SppCentence centence;
}
