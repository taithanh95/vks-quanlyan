package com.bitsco.vks.models;

import java.io.Serializable;

public class LstCountryRequest implements Serializable {

    private String action;

    private String sortField;
    private String sortOrder;
    private String counId;
    private String counName;
    private String remark;

    public LstCountryRequest() {
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

    public String getCounId() {
        return counId;
    }

    public void setCounId(String counId) {
        this.counId = counId;
    }

    public String getCounName() {
        return counName;
    }

    public void setCounName(String counName) {
        this.counName = counName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
