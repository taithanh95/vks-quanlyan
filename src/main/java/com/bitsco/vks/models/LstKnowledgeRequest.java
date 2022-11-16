package com.bitsco.vks.models;

import java.io.Serializable;

public class LstKnowledgeRequest implements Serializable {
    private String action;

    private String sortField;
    private String sortOrder;

    private String levelid;
    private String levelname;

    public LstKnowledgeRequest() {
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

    public String getLevelid() { return levelid; }

    public void setLevelid(String levelid) { this.levelid = levelid; }

    public String getLevelname() {
        return levelname;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname;
    }
}
