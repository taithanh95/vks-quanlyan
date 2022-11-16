package com.bitsco.vks.models;

import java.io.Serializable;

public class LstLocationRequest implements Serializable {
    private String sortField;
    private String sortOrder;
    private String locaid;
    private String name;
    private String remark;
    private String sppid;

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

    public LstLocationRequest() {
        super();
    }

    public String getLocaid() {
        return locaid;
    }

    public void setLocaid(String locaid) {
        this.locaid = locaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSppid() {
        return sppid;
    }

    public void setSppid(String sppid) {
        this.sppid = sppid;
    }
}
