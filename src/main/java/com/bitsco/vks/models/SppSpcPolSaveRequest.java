package com.bitsco.vks.models;

import com.bitsco.vks.entity.SppSpcPol;
import lombok.Data;

@Data
public class SppSpcPolSaveRequest {
    public String action;
    public SppSpcPol ppl;
    public String regicode;
    public String casecode;
    public String userid;
}
