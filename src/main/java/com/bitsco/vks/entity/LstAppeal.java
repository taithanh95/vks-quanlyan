package com.bitsco.vks.entity;

public class LstAppeal {
    private String appealid;
    private String appealname;
    private int settime;
    private String setunit;
    private String setunitname;
    String strSettime;

    public LstAppeal() {
    }

    public String getAppealid() {
        return appealid;
    }

    public void setAppealid(String value) {
        appealid = value;
    }

    public String getAppealname() {
        return appealname;
    }

    public void setAppealname(String value) {
        appealname = value;
    }

    public int getSettime() {
        return settime;
    }

    public void setSettime(int value) {
        settime = value;
        this.strSettime = String.valueOf(value);
    }

    public String getSetunit() {
        return setunit;
    }

//    public void setSetunit(String value) {
//        setunit = value;
//        this.setunitname = Utils.getTextFromBundle(null, Constants.CATEGORIES.SetUnit, value);
//    }

//    public Map<String, String> getListOfSetUnit() {
//        return Utils.getCategoryFromBundle(null, Constants.CATEGORIES.SetUnit);
//    }

    public String getSetunitname() {
        return setunitname;
    }

    public void setStrSettime(String strSettime) {
        if(strSettime == null)
            this.settime = 0;
        else
            this.settime = Integer.parseInt(strSettime);
    }

    public String getStrSettime() {
        if(this.settime == 0)
            return "";
        else
            return String.valueOf(this.getSettime());
    }
}
