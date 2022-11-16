package com.bitsco.vks.entity;

public class LstAgainstEntity {
    private String againstid;
    private String againstname;
    private String applyfor;
    private int settime;
    private String setunit;

    private String applyfor_dis;
    private String setunit_dis;

    private String thoihan_tu;
    private String thoihan_den;
    String strSettime;

    public String getThoihan_tu() {
        return thoihan_tu;
    }

    public void setThoihan_tu(String thoihan_tu) {
        this.thoihan_tu = thoihan_tu;
    }

    public String getThoihan_den() {
        return thoihan_den;
    }

    public void setThoihan_den(String thoihan) {
        this.thoihan_den = thoihan;
    }

    public String getApplyfor_dis() {
        return applyfor_dis;
    }


    public String getSetunit_dis() {
        return setunit_dis;
    }


    public String getAgainstid() {
        return againstid == null ? againstid : againstid.trim();
    }

    public void setAgainstid(String againstid) {
        this.againstid = againstid;
    }

    public String getAgainstname() {
        return againstname == null ? againstname : againstname.trim().replace("\r", "");
    }

    public void setAgainstname(String againstname) {
        this.againstname = againstname;
    }

    public String getApplyfor() {
        return applyfor;
    }

//    public void setApplyfor(String applyfor) {
//        this.applyfor = applyfor;
//        this.applyfor_dis =
//                Utils.getTextFromBundle(Constants.BUNDLE_QLA, Constants.CATEGORIES.Applyfor, this.applyfor);
//    }


    public int getSettime() {
        return settime;
    }

    public void setSettime(int settime) {
        this.settime = settime;
        this.strSettime = String.valueOf(settime);
    }

    public String getSetunit() {
        return setunit;
    }

//    public void setSetunit(String setunit) {
//        this.setunit = setunit;
//        this.setunit_dis = Utils.getTextFromBundle(Constants.BUNDLE_QLA, Constants.CATEGORIES.SetUnit, this.setunit);
//    }

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
