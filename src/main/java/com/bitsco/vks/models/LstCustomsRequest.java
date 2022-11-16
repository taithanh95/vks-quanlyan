package com.bitsco.vks.models;

import java.io.Serializable;

public class LstCustomsRequest implements Serializable {
    private String sortField;
    private String sortOrder;
    private String sppid;
    private String name;
    private String addr;
    private String tel;
    private String fax;
    private String spcid;

    public LstCustomsRequest() {
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

    public String getSppid() {
        return sppid;
    }

    public void setSppid(String sppid) {
        this.sppid = sppid;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getSpcid() {
        return spcid;
    }

    public void setSpcid(String spcid) {
        this.spcid = spcid;
    }
}
