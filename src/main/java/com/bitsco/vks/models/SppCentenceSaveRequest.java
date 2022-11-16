package com.bitsco.vks.models;

import com.bitsco.vks.entity.SppCentence;
import lombok.Data;

import java.io.Serializable;

@Data
public class SppCentenceSaveRequest  implements Serializable {
    public String action;
    public String regicode;
    public SppCentence centence;
    public String userfor;
    public String beginOffice;
    public String beginOfficeId;
    public String userId;
    public String sppId;
}
