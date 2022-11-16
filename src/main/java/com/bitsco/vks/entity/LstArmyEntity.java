package com.bitsco.vks.entity;

public class LstArmyEntity {
    public LstArmyEntity() {
        super();
    }

    private String armyid;
    private String name;
    private String addr;
    private String tel;
    private String fax;
    private String director;
    private String position;
    private int armylevel;
    private String armyparent;
    private String armycode;
    private String ordercode;
    private String newarmyid;
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
        if (armyid != null)
            return this.armyid + " - " + this.name;
        else
            return "";
    }

    public void setArmyid(String armyid) {
        this.armyid = armyid;
    }

    public String getArmyid() {
        return armyid;
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

    public void setArmylevel(int armylevel) {
        this.armylevel = armylevel;
    }

    public int getArmylevel() {
        return armylevel;
    }

    public void setArmyparent(String armyparent) {
        this.armyparent = armyparent;
    }

    public String getArmyparent() {
        return armyparent;
    }

    public void setArmycode(String armycode) {
        this.armycode = armycode;
    }

    public String getArmycode() {
        return armycode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setNewarmyid(String newarmyid) {
        this.newarmyid = newarmyid;
    }

    public String getNewarmyid() {
        return newarmyid;
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
