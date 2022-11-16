package com.bitsco.vks.models;

import java.io.Serializable;

public class LstSpcSearchRequest implements Serializable {
    private String sortField;
    private String sortOrder;
    private String spcId;
    private String name;
    private String addr;
    private String cspcId;
    public LstSpcSearchRequest (){

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

    public String getSpcId() {
        return spcId;
    }

    public void setSpcId(String spcId) {
        this.spcId = spcId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCspcId() {
        return cspcId;
    }

    public void setCspcId(String cspcId) {
        this.cspcId = cspcId;
    }
}
