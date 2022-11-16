package com.bitsco.vks.models;

import com.bitsco.vks.entity.CaseHeroin;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProcessCaseHeroinRequest implements Serializable {
    public String casecode;
    public String lawcode;
    public CaseHeroin heroin;
}
