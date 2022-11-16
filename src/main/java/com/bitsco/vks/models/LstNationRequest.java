package com.bitsco.vks.models;

import java.io.Serializable;

public class LstNationRequest implements Serializable {

    private String action;

    private String sortField;
    private String sortOrder;
    private String natiId;
    private String name;
    private String remark;

    public LstNationRequest() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

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

    public String getNatiId() {
        return natiId;
    }

    public void setNatiId(String natiId) {
        this.natiId = natiId;
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
}
