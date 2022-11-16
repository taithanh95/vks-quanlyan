package com.bitsco.vks.request;

import com.bitsco.vks.constant.Constant;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterDecisionCaseRequest {
    private DateFormat dateFormat = new SimpleDateFormat(Constant.DATE.FORMAT.DATE);
    private Long id;
    private String caseCode;
    private String caseName;
    private String userFor;
    private Date inDate;
    private String deciId;
    private String deciName;
    private String setNum;
    private String setNumReality;
    private Date fromDate;
    private Date toDate;
    private String sppId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getUserFor() {
        return userFor;
    }

    public void setUserFor(String userFor) {
        this.userFor = userFor;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public String getDeciId() {
        return deciId;
    }

    public void setDeciId(String deciId) {
        this.deciId = deciId;
    }

    public String getDeciName() {
        return deciName;
    }

    public void setDeciName(String deciName) {
        this.deciName = deciName;
    }

    public String getSetNum() {
        return setNum;
    }

    public void setSetNum(String setNum) {
        this.setNum = setNum;
    }

    public String getSetNumReality() {
        return setNumReality;
    }

    public void setSetNumReality(String setNumReality) {
        this.setNumReality = setNumReality;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getSppId() {
        return sppId;
    }

    public void setSppId(String sppId) {
        this.sppId = sppId;
    }

    public Date getFirstDayOfYear() throws ParseException {
        return dateFormat.parse("01/01/" + (inDate.getYear() + 1900));
    }

    public Date getLastDayOfYear() throws ParseException {
        return dateFormat.parse("31/12/" + (inDate.getYear() + 1900));
    }
}
