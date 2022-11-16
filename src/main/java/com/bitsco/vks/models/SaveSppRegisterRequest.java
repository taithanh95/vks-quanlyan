package com.bitsco.vks.models;

import com.bitsco.vks.entity.SppCase;
import com.bitsco.vks.entity.SppRegister;
import lombok.Data;

import java.io.Serializable;

@Data
public class SaveSppRegisterRequest implements Serializable {
    public SppCase sppCase;
    public SppRegister sppRegister;
    public String sppId;
    public String userId;
}
