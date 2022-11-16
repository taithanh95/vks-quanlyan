package com.bitsco.vks.dto;

import java.io.Serializable;

public class LstCustomsSearchDTO implements Serializable {
    private Long ROWCOUNT;
    private Integer RNUM;
    private String CUSTOMID;
    private String NAME;
    private String ADDR;
    private String TEL;
    private String FAX;
    private String DIRECTOR;
    private String STATUS;
    private String SPCID;
    private String SPCNAME;
    private String SPPID;
    private String SPPNAME;
    private String LOCAID;
    private String CRTDATE;
    private String CRTUSER;
    private String MDFDATE;
    private String MDFUSER;
    private String POSITION;
    private String SHORTNAME;
    private String LOCANAME;
    private String CUSTOMCODE;
    private String CUSTOMLEVEL;
    private String CUSTOMPARENT;
    private String ORDERCODE;

    private String PLUSCHILDREN;

    public LstCustomsSearchDTO() {

    }

    public String getPLUSCHILDREN() { return PLUSCHILDREN; }

    public void setPLUSCHILDREN(String PLUSCHILDREN) { this.PLUSCHILDREN = PLUSCHILDREN; }

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

    public String getCUSTOMID() {
        return CUSTOMID;
    }

    public void setCUSTOMID(String CUSTOMID) {
        this.CUSTOMID = CUSTOMID;
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

    public String getDIRECTOR() {
        return DIRECTOR;
    }

    public void setDIRECTOR(String DIRECTOR) {
        this.DIRECTOR = DIRECTOR;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getSPCID() {
        return SPCID;
    }

    public void setSPCID(String SPCID) {
        this.SPCID = SPCID;
    }

    public String getSPCNAME() {
        return SPCNAME;
    }

    public void setSPCNAME(String SPCNAME) {
        this.SPCNAME = SPCNAME;
    }

    public String getSPPID() {
        return SPPID;
    }

    public void setSPPID(String SPPID) {
        this.SPPID = SPPID;
    }

    public String getSPPNAME() {
        return SPPNAME;
    }

    public void setSPPNAME(String SPPNAME) {
        this.SPPNAME = SPPNAME;
    }

    public String getLOCAID() {
        return LOCAID;
    }

    public void setLOCAID(String LOCAID) {
        this.LOCAID = LOCAID;
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

    public String getPOSITION() {
        return POSITION;
    }

    public void setPOSITION(String POSITION) {
        this.POSITION = POSITION;
    }

    public String getSHORTNAME() {
        return SHORTNAME;
    }

    public void setSHORTNAME(String SHORTNAME) {
        this.SHORTNAME = SHORTNAME;
    }

    public String getLOCANAME() {
        return LOCANAME;
    }

    public void setLOCANAME(String LOCANAME) {
        this.LOCANAME = LOCANAME;
    }

    public String getCUSTOMCODE() {
        return CUSTOMCODE;
    }

    public void setCUSTOMCODE(String CUSTOMCODE) {
        this.CUSTOMCODE = CUSTOMCODE;
    }

    public String getCUSTOMLEVEL() {
        return CUSTOMLEVEL;
    }

    public void setCUSTOMLEVEL(String CUSTOMLEVEL) {
        this.CUSTOMLEVEL = CUSTOMLEVEL;
    }

    public String getCUSTOMPARENT() {
        return CUSTOMPARENT;
    }

    public void setCUSTOMPARENT(String CUSTOMPARENT) {
        this.CUSTOMPARENT = CUSTOMPARENT;
    }

    public String getORDERCODE() {
        return ORDERCODE;
    }

    public void setORDERCODE(String ORDERCODE) {
        this.ORDERCODE = ORDERCODE;
    }
}

