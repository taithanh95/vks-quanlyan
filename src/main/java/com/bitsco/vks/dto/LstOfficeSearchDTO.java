package com.bitsco.vks.dto;

import java.io.Serializable;

public class LstOfficeSearchDTO implements Serializable {
    private Long ROWCOUNT;
    private Integer RNUM;
    private String OFFICEID;
    private String OFFICENAME;
    private String CRTDATE;
    private String CRTUSER;
    private String MDFDATE;
    private String MDFUSER;
    private String SETLEVEL;

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

    public String getOFFICEID() {
        return OFFICEID;
    }

    public void setOFFICEID(String OFFICEID) {
        this.OFFICEID = OFFICEID;
    }

    public String getOFFICENAME() {
        return OFFICENAME;
    }

    public void setOFFICENAME(String OFFICENAME) {
        this.OFFICENAME = OFFICENAME;
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
}
