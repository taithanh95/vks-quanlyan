package com.bitsco.vks.entity;

public class LstRanger {
    public LstRanger() {
        super();
    }
    private String rangid;
    private String name;
    private String addr;
    private String tel;
    private String fax;
    private String director;
    private String position;
    private int ranglevel;
    private String rangparent;
    private String rangcode;
    private String ordercode;
    private String newrangid;
    private String spcid;
    private String spcname;
    private LstSPC atxtspc;
    private String sppid;
    private String sppname;
    private LstSPP atxspp;
    private String locaid;

    public void setLocaid(String locaid) {
        this.locaid = locaid;
    }

    public String getLocaid() {
        return locaid == null ? locaid : locaid.trim();
    }

    public String toString() {
        if (rangid != null)
            return this.rangid + " - " + this.name;
        else
            return "";
    }

    public void setRangid(String rangid) {
        this.rangid = rangid;
    }

    public String getRangid() {
        return rangid;
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

    public void setRanglevel(int ranglevel) {
        this.ranglevel = ranglevel;
    }

    public int getRanglevel() {
        return ranglevel;
    }

    public void setRangparent(String rangparent) {
        this.rangparent = rangparent;
    }

    public String getRangparent() {
        return rangparent;
    }

    public void setRangcode(String rangcode) {
        this.rangcode = rangcode;
    }

    public String getRangcode() {
        return rangcode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setNewrangid(String newrangid) {
        this.newrangid = newrangid;
    }

    public String getNewrangid() {
        return newrangid;
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

    public void setAtxspp(LstSPP atxspp) {
        this.atxspp = atxspp;
    }

    public LstSPP getAtxspp() {
        return atxspp;
    }
}
