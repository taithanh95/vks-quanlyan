package com.bitsco.vks.dto;

import java.io.Serializable;

public class LstResolveSearchDTO implements Serializable {
    private Long rowcount;
    private Integer rnum;
    private String crtdate;
    private String crtuser;
    private String mdfdate;
    private String mdfuser;

    private String resolid;
    private String resolname;
    private String state;
    private String state_;

    public LstResolveSearchDTO() {

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

    public String getResolid() {
        return resolid;
    }

    public void setResolid(String resolid) {
        this.resolid = resolid;
    }

    public String getResolname() {
        return resolname;
    }

    public void setResolname(String resolname) {
        this.resolname = resolname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState_() {
        if ("CUSTODY".equalsIgnoreCase(this.state))
            return "Tạm giữ";
        else if ("DETENT".equalsIgnoreCase(this.state))
            return "Tạm giam";
        else if ("CONVICT".equalsIgnoreCase(this.state))
            return "Thi hành án";
        else
            return "";
    }

    public void setState_(String state_) {
        this.state_ = state_;
    }
}
