package com.bitsco.vks.entity;

public class SppStaticcBegin {
    public SppStaticcBegin() {
        super();
    }
    private String casecode;
    private String lawcode;
    private String statid;
    private String statname;
    private String amount;
    private String valmin;
    private String valmax;

    public void setCasecode(String casecode) {
        this.casecode = casecode;
    }

    public String getCasecode() {
        return casecode;
    }

    public void setLawcode(String lawcode) {
        this.lawcode = lawcode;
    }

    public String getLawcode() {
        return lawcode;
    }

    public void setStatid(String statid) {
        this.statid = statid;
    }

    public String getStatid() {
        return statid;
    }

    public void setStatname(String statname) {
        this.statname = statname;
    }

    public String getStatname() {
        return statname;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setValmin(String valmin) {
        this.valmin = valmin;
    }

    public String getValmin() {
        return valmin;
    }

    public void setValmax(String valmax) {
        this.valmax = valmax;
    }

    public String getValmax() {
        return valmax;
    }
}
