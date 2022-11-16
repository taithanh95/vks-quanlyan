package com.bitsco.vks.models;

import com.bitsco.vks.entity.CaseExhibit;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProcessCaseExhibitRequest implements Serializable {
    public String casecode;
    public String lawcode;
    public List<CaseExhibit> lstCaseExhibit;
}
