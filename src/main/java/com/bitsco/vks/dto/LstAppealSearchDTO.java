package com.bitsco.vks.dto;

import java.io.Serializable;

public class LstAppealSearchDTO implements Serializable {
    private Long rowcount;
    private Integer rnum;
    private String crtdate;
    private String crtuser;
    private String mdfdate;
    private String mdfuser;

    private String appealid;
    private String appealname;
    private int settime;
    private String setunit;
    private String setunitname;
    String strSettime;

    public LstAppealSearchDTO() {
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

    public String getCrtdate() { return crtdate; }

    public void setCrtdate(String crtdate) { this.crtdate = crtdate; }

    public String getCrtuser() { return crtuser; }

    public void setCrtuser(String crtuser) { this.crtuser = crtuser; }

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

    public String getAppealid() {
        return appealid;
    }

    public void setAppealid(String appealid) {
        this.appealid = appealid;
    }

    public String getAppealname() {
        return appealname;
    }

    public void setAppealname(String appealname) {
        this.appealname = appealname;
    }

    public int getSettime() {
        return settime;
    }

    public void setSettime(int value) {
        settime = value;
        this.strSettime = String.valueOf(value);
    }

    public String getSetunit() {
        return setunit;
    }

    public void setSetunit(String setunit) {
        this.setunit = setunit;
    }

    public String getSetunitname() {
        if(this.setunit.equalsIgnoreCase("DAY")) this.setunitname = "Ngày";
        else this.setunitname = "Tháng";
        return this.setunitname;
    }

    public void setSetunitname(String setunitname) {
        this.setunitname = setunitname;
    }

    public void setStrSettime(String strSettime) {
        if(strSettime == null)
            this.settime = 0;
        else
            this.settime = Integer.parseInt(strSettime);
    }

    public String getStrSettime() {
        if(this.settime == 0)
            return "";
        else
            return String.valueOf(this.getSettime());
    }
}
