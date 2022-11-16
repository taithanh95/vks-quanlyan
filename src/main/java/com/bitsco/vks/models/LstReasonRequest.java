package com.bitsco.vks.models;

import java.io.Serializable;

public class LstReasonRequest implements Serializable {

    private String action;

    private String sortField;
    private String sortOrder;
    private String reasonId;
    private String reasonName;
    private String deciId;

    public LstReasonRequest() {
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

    public String getReasonId() {
        return reasonId;
    }

    public void setReasonId(String reasonId) {
        this.reasonId = reasonId;
    }

    public String getReasonName() {
        return reasonName;
    }

    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }

    public String getDeciId() {
        return deciId;
    }

    public void setDeciId(String deciId) {
        this.deciId = deciId;
    }
}
