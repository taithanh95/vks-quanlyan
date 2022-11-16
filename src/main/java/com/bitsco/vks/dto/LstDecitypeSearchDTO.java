package com.bitsco.vks.dto;

import java.io.Serializable;

public class LstDecitypeSearchDTO implements Serializable {
    Long ROWCOUNT;
    Integer RNUM;
    String DECITYPEID;
    String NAME;
    String CRTUSER;
    String CRTDATE;
    String MDFUSER;
    String MDFDATE;

    public LstDecitypeSearchDTO() {
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

    public String getDECITYPEID() {
        return DECITYPEID;
    }

    public void setDECITYPEID(String DECITYPEID) {
        this.DECITYPEID = DECITYPEID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getCRTUSER() {
        return CRTUSER;
    }

    public void setCRTUSER(String CRTUSER) {
        this.CRTUSER = CRTUSER;
    }

    public String getCRTDATE() {
        return CRTDATE;
    }

    public void setCRTDATE(String CRTDATE) {
        this.CRTDATE = CRTDATE;
    }

    public String getMDFUSER() {
        return MDFUSER;
    }

    public void setMDFUSER(String MDFUSER) {
        this.MDFUSER = MDFUSER;
    }

    public String getMDFDATE() {
        return MDFDATE;
    }

    public void setMDFDATE(String MDFDATE) {
        this.MDFDATE = MDFDATE;
    }
}
