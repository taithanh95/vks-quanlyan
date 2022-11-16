package com.bitsco.vks.dto;

import com.bitsco.vks.utils.Constants;
import com.bitsco.vks.utils.Utils;

import java.io.Serializable;

public class LstConclusionSearchDTO implements Serializable {
    private Long rowcount;
    private Integer rnum;
    private String crtdate;
    private String crtuser;
    private String mdfdate;
    private String mdfuser;

    private String concid;
    private String concname;
    private String userfor;
    private String userforname;
    private String status;
    private String statusname;
    private String id;

    public LstConclusionSearchDTO() {
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

    public String getConcid() {
        return concid;
    }

    public void setConcid(String concid) {
        this.concid = concid;
    }

    public String getConcname() {
        return concname;
    }

    public void setConcname(String concname) {
        this.concname = concname;
    }

    public String getUserfor() {
        return userfor;
    }

    public void setUserfor(String userfor) {
        this.userfor = userfor;
    }

    public String getUserforname() {
        switch (this.userfor) {
            case "G1":
                this.userforname = "Kiểm Sát Điều Tra";
                break;
            case "G2":
                this.userforname = "Xét Truy Tố";
                break;
            case "G3":
                this.userforname = "Sơ Thẩm";
                break;
            case "G4":
                this.userforname = "Phúc Thẩm";
                break;
            case "G5":
                this.userforname = "Giám Đốc Thẩm/Tái Thẩm";
                break;
            case "G6":
                this.userforname = "Thi Hành Án";
                break;
            case "G":
                this.userforname = "Xem xét lại";
                break;
            default:
                this.userforname = "";
        }
        return this.userforname;
    }

    public void setUserforname(String userforname) {
        this.userforname = userforname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusname() {
        if (this.status.equalsIgnoreCase("Y")) return "Có";
        if (this.status.equalsIgnoreCase("N")) return "Không";
        return "";
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
