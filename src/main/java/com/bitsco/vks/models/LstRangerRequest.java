package com.bitsco.vks.models;

import java.io.Serializable;

public class LstRangerRequest implements Serializable {
    private String sortField;
    private String sortOrder;

    private String rangid;
    private String name;
    private String addr;
    private String tel;
    private String fax;
    private String sppId;

    public LstRangerRequest() {
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

    public String getRangid() {
        return rangid;
    }

    public void setRangid(String rangid) {
        this.rangid = rangid;
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

    public String getSppId() {
        return sppId;
    }

    public void setSppId(String sppId) {
        this.sppId = sppId;
    }
}
