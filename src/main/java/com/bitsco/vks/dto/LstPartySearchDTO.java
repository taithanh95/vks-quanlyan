package com.bitsco.vks.dto;

import java.io.Serializable;

public class LstPartySearchDTO implements Serializable {
    private Long ROWCOUNT;
    private Integer RNUM;
    private String PARTYID;
    private String PARTYNAME;
    private String CRTDATE;
    private String CRTUSER;
    private String MDFDATE;
    private String MDFUSER;
    private String SETLEVEL;
    private String SETCOMMITTEE;
    private String REMARK;

    public LstPartySearchDTO() {
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }

    public Long getROWCOUNT() {
        return ROWCOUNT;
    }

    public void setROWCOUNT(Long ROWCOUNT) {
        this.ROWCOUNT = ROWCOUNT;
    }

    public Integer getRNUM() {
        return RNUM;
    }

    public void setRNUM(Integer RNUM) {
        this.RNUM = RNUM;
    }

    public String getPARTYID() {
        return PARTYID;
    }

    public void setPARTYID(String PARTYID) {
        this.PARTYID = PARTYID;
    }

    public String getPARTYNAME() {
        return PARTYNAME;
    }

    public void setPARTYNAME(String PARTYNAME) {
        this.PARTYNAME = PARTYNAME;
    }

    public String getCRTDATE() {
        return CRTDATE;
    }

    public void setCRTDATE(String CRTDATE) {
        this.CRTDATE = CRTDATE;
    }

    public String getCRTUSER() {
        return CRTUSER;
    }

    public void setCRTUSER(String CRTUSER) {
        this.CRTUSER = CRTUSER;
    }

    public String getMDFDATE() {
        return MDFDATE;
    }

    public void setMDFDATE(String MDFDATE) {
        this.MDFDATE = MDFDATE;
    }

    public String getMDFUSER() {
        return MDFUSER;
    }

    public void setMDFUSER(String MDFUSER) {
        this.MDFUSER = MDFUSER;
    }

    public String getSETLEVEL() {
        return SETLEVEL;
    }

    public void setSETLEVEL(String SETLEVEL) {
        this.SETLEVEL = SETLEVEL;
    }

    public String getSETCOMMITTEE() {
        return SETCOMMITTEE;
    }

    public void setSETCOMMITTEE(String SETCOMMITTEE) {
        this.SETCOMMITTEE = SETCOMMITTEE;
    }
}
