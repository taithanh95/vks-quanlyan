package com.bitsco.vks.entity;

public class LstReason {
    private String reasonid;
    private String reasonname;
    private String deciid;
    private String deciname;

    private LstDecisionEntity atxtDeciid; // chá»©a giÃ¡ trá»‹ cá»§a autocomplete textbox

    public LstReason() {
    }

    public String getDeciid() {
        return deciid;
    }

    public void setDeciid(String deciid) {
        this.deciid = deciid;
    }

    public String getReasonid() {
        return reasonid;
    }

    public void setReasonid(String reasonid) {
        this.reasonid = reasonid;
    }

    public String getReasonname() {
        return reasonname == null ? reasonname : reasonname.trim();
    }

    public void setReasonname(String reasonname) {
        this.reasonname = reasonname;
    }

    public void setDeciname(String deciname) {
        this.deciname = deciname;
    }

    public String getDeciname() {
        return deciname == null ? deciname : deciname.trim();
    }

    public void setAtxtDeciid(LstDecisionEntity atxtDeciid) {
        this.atxtDeciid = atxtDeciid;
    }

    public LstDecisionEntity getAtxtDeciid() {
        return atxtDeciid;
    }
}
