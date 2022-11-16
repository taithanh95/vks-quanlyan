package com.bitsco.vks.dto;

import java.io.Serializable;

public class LstTransferSearchDTO  implements Serializable {
    private Long rowcount;
    private Integer rnum;
    private String crtdate;
    private String crtuser;
    private String mdfdate;
    private String mdfuser;

    private String transid;
    private String transname;
    private String fromto;
    private String fromToName;

    public LstTransferSearchDTO() {
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

    public String getTransid() {
        return transid;
    }

    public void setTransid(String transid) {
        this.transid = transid;
    }

    public String getTransname() {
        return transname;
    }

    public void setTransname(String transname) {
        this.transname = transname;
    }

    public String getFromto() {
        return fromto;
    }

    public void setFromto(String fromto) {
        this.fromto = fromto;
    }

    public String getFromToName() {
        switch (fromto) {
            case "CQDT-VKS":
                return "Cơ quan điều tra - Viện kiểm sát";
            case "VKS-CQDT":
                return "Viện kiểm sát - Cơ quan điều tra";
            case "VKS-VKS":
                return "Viện kiểm sát - Viện kiểm sát";
            case "VKS-TA":
                return "Viện kiểm sát - Tòa án";
            case "TA-VKS":
                return "Tòa án - Viện kiểm sát";
            default:
                return "";
        }
    }

    public void setFromToName(String fromToName) {
        this.fromToName = fromToName;
    }
}
