package com.bitsco.vks.dto;

import java.io.Serializable;

public class LstReasonSearchDTO implements Serializable {
    private Long ROWCOUNT;
    private Integer RNUM;
    private String REASONID;
    private String REASONNAME;
    private String DECIID;
    private String CRTDATE;
    private String CRTUSER;
    private String MDFDATE;
    private String MDFUSER;
    private String DECINAME;

    public LstReasonSearchDTO() {
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

    public String getREASONID() {
        return REASONID;
    }

    public void setREASONID(String REASONID) {
        this.REASONID = REASONID;
    }

    public String getREASONNAME() {
        return REASONNAME;
    }

    public void setREASONNAME(String REASONNAME) {
        this.REASONNAME = REASONNAME;
    }

    public String getDECIID() {
        return DECIID;
    }

    public void setDECIID(String DECIID) {
        this.DECIID = DECIID;
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

    public String getDECINAME() {
        return DECINAME;
    }

    public void setDECINAME(String DECINAME) {
        this.DECINAME = DECINAME;
    }
}
