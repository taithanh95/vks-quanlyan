package com.bitsco.vks.dto;

import java.util.Date;

public class RegisterDecisionCaseListResponse {
    private String caseCode; // Ma vu an
    private String caseName; // Ten vu an
    private String fullName; // Bi can dau vu
    private String lawName; // Ten dieu luat khoi to
    private String lawId; // ID dieu luat khoi to
    private String beginSetnum; // QD khoi to so
    private Date beginIndate; // Ngay QD khởi to so

    public String getCaseCode() {
        return caseCode;
    }

    public void setCaseCode(String caseCode) {
        this.caseCode = caseCode;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLawName() {
        return lawName;
    }

    public void setLawName(String lawName) {
        this.lawName = lawName;
    }

    public String getLawId() {
        return lawId;
    }

    public void setLawId(String lawId) {
        this.lawId = lawId;
    }

    public String getBeginSetnum() {
        return beginSetnum;
    }

    public void setBeginSetnum(String beginSetnum) {
        this.beginSetnum = beginSetnum;
    }

    public Date getBeginIndate() {
        return beginIndate;
    }

    public void setBeginIndate(Date beginIndate) {
        this.beginIndate = beginIndate;
    }
}
