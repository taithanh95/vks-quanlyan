package com.bitsco.vks.entity;

public class LstPolice {
    public LstPolice() {
        super();
    }

    private String policeid;
    private String name;
    private String addr;
    private String tel;
    private String fax;
    private String director;
    private String position;
    private int policelevel;
    private String policeparent;
    private String policecode;
    private String ordercode;
    private String newpoliceid;
    private String spcid;
    private String spcname;
    private String sppid;
    private String sppname;
    private LstSPC atxtspc;
    private LstSPP atxspp;
    private String locaid;

    public void setLocaid(String locaid) {
        this.locaid = locaid;
    }

    public String getLocaid() {
        return locaid == null ? locaid : locaid.trim();
    }

    public String toString() {
        if (policeid != null)
            return this.policeid + " - " + this.name;
        else
            return "";
    }

    public void setPoliceid(String policeid) {
        this.policeid = policeid;
    }

    public String getPoliceid() {
        return policeid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFax() {
        return fax;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPolicelevel(int policelevel) {
        this.policelevel = policelevel;
    }

    public int getPolicelevel() {
        return policelevel;
    }

    public void setPoliceparent(String policeparent) {
        this.policeparent = policeparent;
    }

    public String getPoliceparent() {
        return policeparent;
    }

    public void setPolicecode(String policecode) {
        this.policecode = policecode;
    }

    public String getPolicecode() {
        return policecode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setNewpoliceid(String newpoliceid) {
        this.newpoliceid = newpoliceid;
    }

    public String getNewpoliceid() {
        return newpoliceid;
    }

    public void setSpcid(String spcid) {
        this.spcid = spcid;
    }

    public String getSpcid() {
        return spcid;
    }

    public void setSpcname(String spcname) {
        this.spcname = spcname;
    }

    public String getSpcname() {
        return spcname;
    }

    public void setAtxtspc(LstSPC atxtspc) {
        this.atxtspc = atxtspc;
    }

    public LstSPC getAtxtspc() {
        return atxtspc;
    }

    public void setAtxspp(LstSPP atxspp) {
        this.atxspp = atxspp;
    }

    public LstSPP getAtxspp() {
        return atxspp;
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
}
