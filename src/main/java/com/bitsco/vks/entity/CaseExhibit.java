package com.bitsco.vks.entity;

public class CaseExhibit {
    public CaseExhibit() {
        super();
    }

    private String casecode;
    private String lawcode;
    private String exhid;
    private String exhname;
    private Integer amount;

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

    public void setExhid(String exhid) {
        this.exhid = exhid;
    }

    public String getExhid() {
        return exhid;
    }

    public void setExhname(String exhname) {
        this.exhname = exhname;
    }

    public String getExhname() {
        return exhname;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }
}
