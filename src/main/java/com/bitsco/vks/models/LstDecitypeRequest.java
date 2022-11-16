package com.bitsco.vks.models;

import java.io.Serializable;

public class LstDecitypeRequest implements Serializable {

    private String action;

    private String sortField;
    private String sortOrder;
    private String decitypeId;
    private String name;

    public LstDecitypeRequest() {
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

    public String getDecitypeId() {
        return decitypeId;
    }

    public void setDecitypeId(String decitypeId) {
        this.decitypeId = decitypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
