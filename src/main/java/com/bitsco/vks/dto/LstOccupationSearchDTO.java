package com.bitsco.vks.dto;

import java.io.Serializable;

public class LstOccupationSearchDTO implements Serializable {
    private Long ROWCOUNT;
    private Integer RNUM;
    private String OCCUID;
    private String NAME;
    private String REMARK;
    private String CRTUSER;
    private String MDFUSER;
    private String CRTDATE;
    private String MDFDATE;
    private String BRANCHJOB;
    private String BRANCHJOB_DIS;

    public LstOccupationSearchDTO() {
    }

    public String getOCCUID() {
        return OCCUID;
    }

    public void setOCCUID(String OCCUID) {
        this.OCCUID = OCCUID;
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

    public String getCRTUSER() {
        return CRTUSER;
    }

    public void setCRTUSER(String CRTUSER) {
        this.CRTUSER = CRTUSER;
    }

    public String getMDFUSER() {
        return MDFUSER;
    }

    public void setMDFUSER(String MDFUSER) {
        this.MDFUSER = MDFUSER;
    }

    public String getCRTDATE() {
        return CRTDATE;
    }

    public void setCRTDATE(String CRTDATE) {
        this.CRTDATE = CRTDATE;
    }

    public String getMDFDATE() {
        return MDFDATE;
    }

    public void setMDFDATE(String MDFDATE) {
        this.MDFDATE = MDFDATE;
    }

    public String getBRANCHJOB() {
        return BRANCHJOB;
    }

    public void setBRANCHJOB(String BRANCHJOB) {
        this.BRANCHJOB = BRANCHJOB;
    }

    public String getBRANCHJOB_DIS() {
            if("SPC".equalsIgnoreCase(BRANCHJOB)) this.BRANCHJOB_DIS = "Tòa án";
            else if ("SPP".equalsIgnoreCase(BRANCHJOB)) this.BRANCHJOB_DIS = "Viện kiểm sát";
            else if ("POL".equalsIgnoreCase(BRANCHJOB)) this.BRANCHJOB_DIS = "Công an";
            else if ("EXE".equalsIgnoreCase(BRANCHJOB)) this.BRANCHJOB_DIS = "Thi hành án";
            else if ("OTH".equalsIgnoreCase(BRANCHJOB)) this.BRANCHJOB_DIS = "Ngành khác";
            else this.BRANCHJOB_DIS = "";
        return BRANCHJOB_DIS;
    }

    public void setBRANCHJOB_DIS(String BRANCHJOB_DIS) {
        this.BRANCHJOB_DIS = BRANCHJOB_DIS;
    }
}
