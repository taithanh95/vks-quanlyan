package com.bitsco.vks.models;

import java.io.Serializable;

public class LstOfficeRequest implements Serializable {
    private String sortField;
    private String sortOrder;
    private String officeId;
    private String officeName;
    private String setLevel;
    private String action;

    public LstOfficeRequest() {
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getSetLevel() {
        return setLevel;
    }

    public void setSetLevel(String setLevel) {
        this.setLevel = setLevel;
    }
}
