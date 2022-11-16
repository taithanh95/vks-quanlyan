package com.bitsco.vks.dto;

import java.io.Serializable;

public class LstCountrySearchDTO implements Serializable{
    private Long ROWCOUNT;
    private Integer RNUM;
    private String COUNID;
    private String COUNNAME;
    private String REMARK;
    private String CRTDATE;
    private String CRTUSER;
    private String MDFDATE;
    private String MDFUSER;

    public LstCountrySearchDTO() {
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

    public String getCOUNID() {
        return COUNID;
    }

    public void setCOUNID(String COUNID) {
        this.COUNID = COUNID;
    }

    public String getCOUNNAME() {
        return COUNNAME;
    }

    public void setCOUNNAME(String COUNNAME) {
        this.COUNNAME = COUNNAME;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
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
}
