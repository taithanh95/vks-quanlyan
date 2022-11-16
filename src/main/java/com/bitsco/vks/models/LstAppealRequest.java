package com.bitsco.vks.models;

import java.io.Serializable;

public class LstAppealRequest implements Serializable {

    private String action;

    private int settime;
    private String setunit;

    private String sortField;
    private String sortOrder;

    private String appealid;
    private String appealname;

    public LstAppealRequest() {
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

    public String getAppealid() {
        return appealid;
    }

    public void setAppealid(String appealid) {
        this.appealid = appealid;
    }

    public String getAppealname() {
        return appealname;
    }

    public void setAppealname(String appealname) {
        this.appealname = appealname;
    }

    public String getAction() { return action; }

    public void setAction(String action) { this.action = action; }

    public int getSettime() { return settime; }

    public void setSettime(int settime) { this.settime = settime; }

    public String getSetunit() { return setunit; }

    public void setSetunit(String setunit) { this.setunit = setunit; }
}
