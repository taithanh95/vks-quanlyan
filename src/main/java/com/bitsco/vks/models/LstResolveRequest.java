package com.bitsco.vks.models;

import java.io.Serializable;

public class LstResolveRequest implements Serializable {
    private String action;

    private String sortField;
    private String sortOrder;

    private String resolid;
    private String resolname;
    private String state;

    public LstResolveRequest() {
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

    public String getResolid() {
        return resolid;
    }

    public void setResolid(String resolid) {
        this.resolid = resolid;
    }

    public String getResolname() {
        return resolname;
    }

    public void setResolname(String resolname) {
        this.resolname = resolname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
