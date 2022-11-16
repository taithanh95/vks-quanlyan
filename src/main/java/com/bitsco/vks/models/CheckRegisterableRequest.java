package com.bitsco.vks.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class CheckRegisterableRequest implements Serializable {
    public String casecode;
    public String usefor;
    public String sppId;
}
