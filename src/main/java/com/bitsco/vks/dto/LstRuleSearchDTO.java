package com.bitsco.vks.dto;

import java.io.Serializable;

public class LstRuleSearchDTO implements Serializable {
    private Long rowcount;
    private Integer rnum;
    private String crtdate;
    private String crtuser;
    private String mdfdate;
    private String mdfuser;

    private String nameOfCaseType;
    private String nameOfUseFor;
    private String caseType;
    private String userFor;
    private String ruleTime;
    private String setUnit;
    private String nameOfSetUnit;
    private String thoihan_tu;
    private String thoihan_den;

    public LstRuleSearchDTO() {
    }

    public Long getRowcount() {
        return rowcount;
    }

    public void setRowcount(Long rowcount) {
        this.rowcount = rowcount;
    }

    public Integer getRnum() {
        return rnum;
    }

    public void setRnum(Integer rnum) {
        this.rnum = rnum;
    }

    public String getCrtdate() { return crtdate; }

    public void setCrtdate(String crtdate) { this.crtdate = crtdate; }

    public String getCrtuser() { return crtuser; }

    public void setCrtuser(String crtuser) { this.crtuser = crtuser; }

    public String getMdfdate() {
        return mdfdate;
    }

    public void setMdfdate(String mdfdate) {
        this.mdfdate = mdfdate;
    }

    public String getMdfuser() {
        return mdfuser;
    }

    public void setMdfuser(String mdfuser) {
        this.mdfuser = mdfuser;
    }

    public String getCaseType() {
        return caseType;
    }

    public String getUserFor() {
        return userFor;
    }

    public void setRuleTime(String ruleTime) {
        this.ruleTime = ruleTime;
    }

    public String getRuleTime() {
        return ruleTime;
    }


    public String getSetUnit() {
        return setUnit;
    }

    public void setNameOfCaseType(String nameOfCaseType) {
        this.nameOfCaseType = nameOfCaseType;
    }

    public void setNameOfSetUnit(String nameOfSetUnit) {
        this.nameOfSetUnit = nameOfSetUnit;
    }

    public void setNameOfUseFor(String nameOfUseFor) {
        this.nameOfUseFor = nameOfUseFor;
    }

    public void setThoihan_den(String thoihan_den) {
        this.thoihan_den = thoihan_den;
    }

    public String getThoihan_den() {
        return thoihan_den;
    }

    public void setThoihan_tu(String thoihan_tu) {
        this.thoihan_tu = thoihan_tu;
    }

    public String getThoihan_tu() {
        return thoihan_tu;
    }

    public String getNameOfCaseType() {
        switch (this.caseType){
            case "L1" : this.nameOfCaseType = "Ít nghiêm trọng"; break;
            case "L2" : this.nameOfCaseType = "Nghiêm trọng"; break;
            case "L3" : this.nameOfCaseType = "Rất nghiêm trọng"; break;
            case "L4" : this.nameOfCaseType = "Đặc biệt nghiêm trọng"; break;
            default: this.nameOfCaseType = "";
        }
        return  this.nameOfCaseType;
    }

    public String getNameOfUseFor() {
        switch (this.userFor){
            case "G1" : this.nameOfUseFor = "Kiểm tra điều tra"; break;
            case "G2" : this.nameOfUseFor = "Xét truy tố"; break;
            case "G3" : this.nameOfUseFor = "Sơ thẩm"; break;
            case "G4" : this.nameOfUseFor = "Phúc thẩm"; break;
            case "G5" : this.nameOfUseFor = "Giám đốc thẩm/Tái thẩm"; break;
            case "G6" : this.nameOfUseFor = "Thi hành án"; break;
            default: this.nameOfUseFor = "";
        }
        return  this.nameOfUseFor;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public void setUserFor(String userFor) {
        this.userFor = userFor;
    }

    public void setSetUnit(String setUnit) {
        this.setUnit = setUnit;
    }

    public String getNameOfSetUnit() {
        switch (this.setUnit){
            case "DAY" : this.nameOfSetUnit = "Ngày"; break;
            case "MONTH" : this.nameOfSetUnit = "Tháng"; break;
            default: this.nameOfSetUnit = "";
        }
        return  this.nameOfSetUnit;
    }
}
