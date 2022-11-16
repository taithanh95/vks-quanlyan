package com.bitsco.vks.dto;

import java.io.Serializable;

public class LstAgainstSearchDTO implements Serializable {
    private Long rowcount;
    private Integer rnum;
    private String crtdate;
    private String crtuser;
    private String mdfdate;
    private String mdfuser;

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

    public LstAgainstSearchDTO() {
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

    public String getCrtdate() {
        return crtdate;
    }

    public void setCrtdate(String crtdate) {
        this.crtdate = crtdate;
    }

    public String getCrtuser() {
        return crtuser;
    }

    public void setCrtuser(String crtuser) {
        this.crtuser = crtuser;
    }

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
        if (this.applyfor.equalsIgnoreCase("A")) this.applyfor_dis = "Bị Can";
        else this.applyfor_dis = "Vụ án";
        return this.applyfor_dis;
    }

    public String getSetunit_dis() {
        if (this.setunit.equalsIgnoreCase("DAY")) this.setunit_dis = "Ngày";
        else this.setunit_dis = "Tháng";
        return this.setunit_dis;
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
        if (strSettime == null)
            this.settime = 0;
        else
            this.settime = Integer.parseInt(strSettime);
    }

    public String getStrSettime() {
        if (this.settime == 0)
            return "";
        else
            return String.valueOf(this.getSettime());
    }

    public void setApplyfor(String applyfor) {
        this.applyfor = applyfor;
    }

    public void setSetunit(String setunit) {
        this.setunit = setunit;
    }

    public void setApplyfor_dis(String applyfor_dis) {
        this.applyfor_dis = applyfor_dis;
    }

    public void setSetunit_dis(String setunit_dis) {
        this.setunit_dis = setunit_dis;
    }
}
