package com.bitsco.vks.models;

import java.io.Serializable;

public class LstConclusionRequest implements Serializable {

    private String action;

    private String sortField;
    private String sortOrder;

    private String concid;
    private String concname;
    private String userfor;
    private String status;

    public LstConclusionRequest() {
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

    public String getConcid() {
        return concid;
    }

    public void setConcid(String concid) {
        this.concid = concid;
    }

    public String getConcname() {
        return concname;
    }

    public void setConcname(String concname) {
        this.concname = concname;
    }

    public String getUserfor() {
        return userfor;
    }

    public void setUserfor(String userfor) {
        this.userfor = userfor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
