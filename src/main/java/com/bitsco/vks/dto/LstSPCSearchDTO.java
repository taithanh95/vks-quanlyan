package com.bitsco.vks.dto;

import java.io.Serializable;

public class LstSPCSearchDTO implements Serializable {
    private String spcid;
    private String name;
    private String addr;
    private String tel;
    private String fax;
    private String director;
    private String spclevel;
    private String spcparent;
    private String spccode;
    private String ordercode;
    private String newspcid;
    private String locaid;

    private Long rowcount;
    private Integer rnum;
    private String crtdate;
    private String crtuser;
    private String mdfdate;
    private String mdfuser;

    private String pluschildren;

    public LstSPCSearchDTO() {
    }

    public String getPluschildren() { return pluschildren; }

    public void setPluschildren(String pluschildren) { this.pluschildren = pluschildren; }

    public String getSpcid() {
        return spcid;
    }

    public void setSpcid(String spcid) {
        this.spcid = spcid;
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

    public String getSpclevel() {
        return spclevel;
    }

    public void setSpclevel(String spclevel) {
        this.spclevel = spclevel;
    }

    public String getSpcparent() {
        return spcparent;
    }

    public void setSpcparent(String spcparent) {
        this.spcparent = spcparent;
    }

    public String getSpccode() {
        return spccode;
    }

    public void setSpccode(String spccode) {
        this.spccode = spccode;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public String getNewspcid() {
        return newspcid;
    }

    public void setNewspcid(String newspcid) {
        this.newspcid = newspcid;
    }

    public String getLocaid() {
        return locaid;
    }

    public void setLocaid(String locaid) {
        this.locaid = locaid;
    }

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

    public String getCrtdate() {
        return crtdate;
    }

    public void setCrtdate(String crtdate) {
        this.crtdate = crtdate;
    }

    public String getCrtuser() {
        return crtuser;
    }

    public void setCrtuser(String crtuser) {
        this.crtuser = crtuser;
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
}
