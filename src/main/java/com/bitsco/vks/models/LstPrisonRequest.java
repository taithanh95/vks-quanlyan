package com.bitsco.vks.models;

public class LstPrisonRequest {
    private String sortField;
    private String sortOrder;

    private String prisonid;
    private String name;
    private String addr;

    private String ptype;

    private String sppid;

    public LstPrisonRequest(){

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

    public String getPrisonid() {
        return prisonid;
    }

    public void setPrisonid(String prisonid) {
        this.prisonid = prisonid;
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

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getSppid() {
        return sppid;
    }

    public void setSppid(String sppid) {
        this.sppid = sppid;
    }
}
