package com.bitsco.vks.dto;

import java.io.Serializable;

public class LstRangerSearchDTO implements Serializable {
    private Long rowcount;
    private Integer rnum;
    private String ctrdate;
    private String ctruser;
    private String mdfdate;
    private String mdfuser;

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
    private String atxtspc;
    private String sppid;
    private String sppname;
    private String atxspp;
    private String locaid;

    private String pluschildren;

    public LstRangerSearchDTO() {
    }

    public String getPluschildren() { return pluschildren; }

    public void setPluschildren(String pluschildren) { this.pluschildren = pluschildren; }

    public Long getRowcount() {
        return rowcount;
    }

    public void setRowcount(Long rowcount) {
        this.rowcount = rowcount;
    }

    public Integer getRnum() {
        return rnum;
    }

    public void setRnum(Integer rnum) {
        this.rnum = rnum;
    }

    public String getCtrdate() {
        return ctrdate;
    }

    public void setCtrdate(String ctrdate) {
        this.ctrdate = ctrdate;
    }

    public String getCtruser() {
        return ctruser;
    }

    public void setCtruser(String ctruser) {
        this.ctruser = ctruser;
    }

    public String getMdfdate() {
        return mdfdate;
    }

    public void setMdfdate(String mdfdate) {
        this.mdfdate = mdfdate;
    }

    public String getMdfuser() {
        return mdfuser;
    }

    public void setMdfuser(String mdfuser) {
        this.mdfuser = mdfuser;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getRanglevel() {
        return ranglevel;
    }

    public void setRanglevel(int ranglevel) {
        this.ranglevel = ranglevel;
    }

    public String getRangparent() {
        return rangparent;
    }

    public void setRangparent(String rangparent) {
        this.rangparent = rangparent;
    }

    public String getRangcode() {
        return rangcode;
    }

    public void setRangcode(String rangcode) {
        this.rangcode = rangcode;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public String getNewrangid() {
        return newrangid;
    }

    public void setNewrangid(String newrangid) {
        this.newrangid = newrangid;
    }

    public String getSpcid() {
        return spcid;
    }

    public void setSpcid(String spcid) {
        this.spcid = spcid;
    }

    public String getSpcname() {
        return spcname;
    }

    public void setSpcname(String spcname) {
        this.spcname = spcname;
    }

    public String getAtxtspc() {
        return atxtspc;
    }

    public void setAtxtspc(String atxtspc) {
        this.atxtspc = atxtspc;
    }

    public String getSppid() {
        return sppid;
    }

    public void setSppid(String sppid) {
        this.sppid = sppid;
    }

    public String getSppname() {
        return sppname;
    }

    public void setSppname(String sppname) {
        this.sppname = sppname;
    }

    public String getAtxspp() {
        return atxspp;
    }

    public void setAtxspp(String atxspp) {
        this.atxspp = atxspp;
    }

    public String getLocaid() {
        return locaid;
    }

    public void setLocaid(String locaid) {
        this.locaid = locaid;
    }
}
