package com.bitsco.vks.entity;

public class LstSigner {
    protected String signname;
    protected String position;
    protected String polid;
    protected String polname;
    protected String officeid;
    protected String officename;
    protected String sppid;
    protected String sppname;
    protected String signid;
    protected String display;

    public LstSigner() {
        super();
    }

    public void setSignname(String signname) {
        this.signname = signname;
    }

    public String getSignname() {
        return signname;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPolid(String polid) {
        this.polid = polid;
    }

    public String getPolid() {
        return polid;
    }

    public void setPolname(String polname) {
        this.polname = polname;
    }

    public String getPolname() {
        return polname;
    }

    public void setOfficeid(String officeid) {
        this.officeid = officeid;
    }

    public String getOfficeid() {
        return officeid;
    }

    public void setOfficename(String officename) {
        this.officename = officename;
    }

    public String getOfficename() {
        return officename;
    }

    public void setSppid(String sppid) {
        this.sppid = sppid;
    }

    public String getSppid() {
        return sppid;
    }

    public void setSppname(String sppname) {
        this.sppname = sppname;
    }

    public String getSppname() {
        return sppname;
    }

    public void setSignid(String signid) {
        this.signid = signid;
    }

    public String getSignid() {
        return signid;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getDisplay() {
        display = signname + "/" + position;
        return display;
    }


    public String toString() {
        return getDisplay();
    }
}
