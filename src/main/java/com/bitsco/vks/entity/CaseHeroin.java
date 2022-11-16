package com.bitsco.vks.entity;

public class CaseHeroin {
    public CaseHeroin() {
        super();
    }
    private String casecode;
    private String lawcode;
    private String heroinid;
    private String heroinname;
    private String amount;
    private String unit;
    private String unitname;

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

    public void setHeroinid(String heroinid) {
        this.heroinid = heroinid;
    }

    public String getHeroinid() {
        return heroinid;
    }

    public void setHeroinname(String heroinname) {
        this.heroinname = heroinname;
    }

    public String getHeroinname() {
        return heroinname;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setUnit(String unit) {
        this.unit = unit;
//        this.unitname = Utils.getTextFromBundle(null, Constants.CATEGORIES.HeroinUnit,this.unit);
    }

    public String getUnit() {
        return unit;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public String getUnitname() {
        return unitname;
    }
}
