package com.bitsco.vks.dto;

import java.io.Serializable;

public class LstPrisonSearchDTO implements Serializable {
    private Long ROWCOUNT;
    private Integer RNUM;
    private String PRISONID;
    private String NAME;
    private String ADDR;
    private String TEL;
    private String FAX;
    private String PTYPE;
    private String CRTDATE;
    private String CRTUSER;
    private String MDFDATE;
    private String MDFUSER;

    private String SPPID;
    private String SPPNAME;
    private String SELECTEDSPP;

    public LstPrisonSearchDTO() {
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

    public String getPRISONID() {
        return PRISONID;
    }

    public void setPRISONID(String POLID) {
        this.PRISONID = POLID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getADDR() {
        return ADDR;
    }

    public void setADDR(String ADDR) {
        this.ADDR = ADDR;
    }

    public String getTEL() {
        return TEL;
    }

    public void setTEL(String TEL) {
        this.TEL = TEL;
    }

    public String getFAX() {
        return FAX;
    }

    public void setFAX(String FAX) {
        this.FAX = FAX;
    }

    public String getPTYPE() {
        return PTYPE;
    }

    public void setPTYPE(String PTYPE) {
        this.PTYPE = PTYPE;
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

    public String getSPPID() {
        return SPPID;
    }

    public void setSPPID(String sppid) {
        this.SPPID = sppid;
    }

    public String getSPPNAME() {
        return SPPNAME;
    }

    public void setSPPNAME(String sppname) {
        this.SPPNAME = sppname;
    }

    public String getSELECTEDSPP() {
        return SELECTEDSPP;
    }

    public void setSELECTEDSPP(String atxspp) {
        this.SELECTEDSPP = SELECTEDSPP;
    }
}
