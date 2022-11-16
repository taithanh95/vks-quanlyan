package com.bitsco.vks.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UpdateInfoG6SearchRequest extends BaseListRequest {
    public int rowIndex;
    public int pageSize;
    public String caseCode;
    public String caseName;
    public Date fromDate;
    public Date toDate;
    public String accuName;
    public String sppid;
    public int acceptType;
    public String regiCode;
    public String userfor;
    public String sppCentence;
    public String status;


}
