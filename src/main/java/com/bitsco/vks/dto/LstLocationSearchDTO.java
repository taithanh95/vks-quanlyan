package com.bitsco.vks.dto;
import java.io.Serializable;

public class LstLocationSearchDTO implements Serializable {
    private Long ROWCOUNT;
    private Integer RNUM;
    private String LOCAID;
    private String NAME;
    private String REMARK;
    private String STDCODE;
    private String STATUS;
    private String CRTDATE;
    private String CRTUSER;
    private String MDFDATE;
    private String MDFUSER;
    private String L1NAME;
    private String L2NAME;
    private String LOCACODE;
    private String LOCALEVEL;
    private String LOCAPARENT;
    private String ORDERCODE;
    private Integer SYNC;

    private String plusChildren;

    public LstLocationSearchDTO() {

    }

    public String getPLUSCHILDREN() { return plusChildren; }

    public void setPLUSCHILDREN(String PLUSCHILDREN) { this.plusChildren = PLUSCHILDREN; }

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

    public String getLOCAID() {
        return LOCAID;
    }

    public void setLOCAID(String LOCAID) {
        this.LOCAID = LOCAID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }

    public String getSTDCODE() {
        return STDCODE;
    }

    public void setSTDCODE(String STDCODE) {
        this.STDCODE = STDCODE;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
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

    public String getL1NAME() {
        return L1NAME;
    }

    public void setL1NAME(String l1NAME) {
        L1NAME = l1NAME;
    }

    public String getL2NAME() {
        return L2NAME;
    }

    public void setL2NAME(String l2NAME) {
        L2NAME = l2NAME;
    }

    public String getLOCACODE() {
        return LOCACODE;
    }

    public void setLOCACODE(String LOCACODE) {
        this.LOCACODE = LOCACODE;
    }

    public String getLOCALEVEL() {
        return LOCALEVEL;
    }

    public void setLOCALEVEL(String LOCALEVEL) {
        this.LOCALEVEL = LOCALEVEL;
    }

    public String getLOCAPARENT() {
        return LOCAPARENT;
    }

    public void setLOCAPARENT(String LOCAPARENT) {
        this.LOCAPARENT = LOCAPARENT;
    }

    public String getORDERCODE() {
        return ORDERCODE;
    }

    public void setORDERCODE(String ORDERCODE) {
        this.ORDERCODE = ORDERCODE;
    }

    public Integer getSYNC() {
        return SYNC;
    }

    public void setSYNC(Integer SYNC) {
        this.SYNC = SYNC;
    }
}

