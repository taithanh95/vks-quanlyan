package com.bitsco.vks.entity;

public class LstCode {
    private String action;
    private String codeid;
    private String codeName;
    //  private String status;

    public void setCodeid(String codeid) {
        this.codeid = codeid;
    }

    public String getCodeid() {
        return codeid == null ? codeid : codeid.trim();
    }

    public void setCodeName(String codename) {
        this.codeName = codename;
    }

    public String getCodeName() {
        return codeName == null ? codeName : codeName.trim();
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
