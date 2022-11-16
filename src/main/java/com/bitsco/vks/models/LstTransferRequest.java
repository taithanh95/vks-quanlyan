package com.bitsco.vks.models;

import java.io.Serializable;

public class LstTransferRequest implements Serializable {
    private String action;

    private String sortField;
    private String sortOrder;

    private String transid;
    private String transname;
    private String fromto;
    private String fromToName;

    public LstTransferRequest() {
    }

    public String getAction() { return action; }

    public void setAction(String action) { this.action = action; }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getTransid() {
        return transid;
    }

    public void setTransid(String transid) {
        this.transid = transid;
    }

    public String getTransname() {
        return transname;
    }

    public void setTransname(String transname) {
        this.transname = transname;
    }

    public String getFromto() {
        return fromto;
    }

    public void setFromto(String fromto) {
        this.fromto = fromto;
    }

    public String getFromToName() {
        return fromToName;
    }

    public void setFromToName(String fromToName) {
        this.fromToName = fromToName;
    }
}
