package com.bitsco.vks.request;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterDecisionCaseSeqRequest implements Serializable {
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private String caseCode;
    private String deciId;
    private String sppId;
    private Date lastUpdate;

    public String getCaseCode() {
        return caseCode;
    }

    public void setCaseCode(String caseCode) {
        this.caseCode = caseCode;
    }

    public String getDeciId() {
        return deciId;
    }

    public void setDeciId(String deciId) {
        this.deciId = deciId;
    }

    public String getSppId() {
        return sppId;
    }

    public void setSppId(String sppId) {
        this.sppId = sppId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Date getFirstYear() throws ParseException {
        return dateFormat.parse("01/01/" + (lastUpdate.getYear() + 1900));
    }

    public Date getLastYear() throws ParseException {
        return dateFormat.parse("31/12/" + (lastUpdate.getYear() + 1900));
    }
}
