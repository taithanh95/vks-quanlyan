package com.bitsco.vks.dto;

import java.io.Serializable;

public class LstReligionSearchDTO implements Serializable {
    private Long ROWCOUNT;
    private Integer RNUM;
    private String RELIGIONID;
    private String RELIGIONNAME;
    private String CRTUSER;
    private String RELIGIONNOTE;
    private String CRTDATE;
    private String MDFUSER;
    private String MDFDATE;

    public LstReligionSearchDTO() {
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

    public String getRELIGIONID() {
        return RELIGIONID;
    }

    public void setRELIGIONID(String RELIGIONID) {
        this.RELIGIONID = RELIGIONID;
    }

    public String getRELIGIONNAME() {
        return RELIGIONNAME;
    }

    public void setRELIGIONNAME(String RELIGIONNAME) {
        this.RELIGIONNAME = RELIGIONNAME;
    }

    public String getCRTUSER() {
        return CRTUSER;
    }

    public void setCRTUSER(String CRTUSER) {
        this.CRTUSER = CRTUSER;
    }

    public String getRELIGIONNOTE() {
        return RELIGIONNOTE;
    }

    public void setRELIGIONNOTE(String RELIGIONNOTE) {
        this.RELIGIONNOTE = RELIGIONNOTE;
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
