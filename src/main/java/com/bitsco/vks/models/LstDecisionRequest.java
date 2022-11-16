package com.bitsco.vks.models;

import java.io.Serializable;

public class LstDecisionRequest implements Serializable {
    private String sortField;
    private String sortOrder;
    private String id;
    private String name;
    private String applyFor;
    private String userFor;
    private String status;
    private String applyFinish;
    private String deciType;

    public LstDecisionRequest() {
        super();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApplyFor() {
        return applyFor;
    }

    public void setApplyFor(String applyFor) {
        this.applyFor = applyFor;
    }

    public String getUserFor() {
        return userFor;
    }

    public void setUserFor(String userFor) {
        this.userFor = userFor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApplyFinish() {
        return applyFinish;
    }

    public void setApplyFinish(String applyFinish) {
        this.applyFinish = applyFinish;
    }

    public String getDeciType() {
        return deciType;
    }

    public void setDeciType(String deciType) {
        this.deciType = deciType;
    }
}
