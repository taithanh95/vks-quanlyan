package com.bitsco.vks.models;

import java.io.Serializable;

public class LstRuleRequest implements Serializable {

    private String action;

    private String sortField;
    private String sortOrder;

    private String caseType;
    private String userFor;
    private String ruleTime;
    private String setUnit;
    private String sppid;
    private String thoi_han_tu;
    private String thoi_han_den;

    public LstRuleRequest() {
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

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getUserFor() {
        return userFor;
    }

    public void setUserFor(String userFor) {
        this.userFor = userFor;
    }

    public String getRuleTime() {
        return ruleTime;
    }

    public void setRuleTime(String ruleTime) {
        this.ruleTime = ruleTime;
    }

    public String getSetUnit() {
        return setUnit;
    }

    public void setSetUnit(String setUnit) {
        this.setUnit = setUnit;
    }

    public String getSppid() {
        return sppid;
    }

    public void setSppid(String sppid) {
        this.sppid = sppid;
    }

    public String getThoi_han_tu() {
        return thoi_han_tu;
    }

    public void setThoi_han_tu(String thoi_han_tu) {
        this.thoi_han_tu = thoi_han_tu;
    }

    public String getThoi_han_den() {
        return thoi_han_den;
    }

    public void setThoi_han_den(String thoi_han_den) {
        this.thoi_han_den = thoi_han_den;
    }
}
