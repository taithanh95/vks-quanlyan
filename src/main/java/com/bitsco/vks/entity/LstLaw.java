package com.bitsco.vks.entity;

import com.bitsco.vks.utils.Utils;

import java.util.Date;

public class LstLaw {
    private String lawcode;
    private String lawid;
    private String item;
    private String point;
    private String lawname;
    private String lawname_txt;
    private Date lawdate;
    private String lawdates;
    private String priority;
    private String setorder;
    private String lawtype;
    private String lawtypename;
    private String groupid;
    private String groupname;
    private String codeid;
    private String codename;
    private String lawnamedetail;
    private String accucode;
    private String fullname;

    /** TUBN2
     * CÃ¡c biáº¿n khai bÃ¡o Ä‘á»ƒ load cá»™t Ä‘á»™ng Tra cá»©u thÃ´ng tin Ä�iá»�u luáº­t
     * */
    private String casecode;
    private String casename; // tÃªn vá»¥ Ã¡n
    private String setnum; // sá»‘ thá»¥ lÃ½
    private Date indate; // ngÃ y ra báº£n Ã¡n
    private Date actdate; // ngÃ y hiá»‡u lá»±c báº£n Ã¡n
    private Date begin_indate;
    private String begin_setnum;

    /** END TUBN2 */

    /*
     * BacNV khai bao de tim kiem ngay den ngay
     */
    private Date fromdate;
    private Date todate;
    private boolean checklawcode;

    public void setCodeid(String codeid) {
        this.codeid = codeid;
    }

    public String getCodeid() {
        return codeid;
    }

    public void setLawcode(String lawcode) {
        this.lawcode = lawcode;
    }

    public String getLawcode() {
        return lawcode;
    }

    public void setLawid(String lawid) {
        this.lawid = lawid;
    }

    public String getLawid() {
        return lawid;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getPoint() {
        return point;
    }

    public void setLawname(String lawname) {
        this.lawname = lawname;
    }

    public String getLawname() {
        return lawname == null ? lawname : lawname.trim();
    }

    public void setLawdate(Date lawdate) {
        this.lawdate = lawdate;
        this.setLawdates(Utils.convertDateToString(lawdate));
    }

    public Date getLawdate() {
        return lawdate;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }

    public void setSetorder(String setorder) {
        this.setorder = setorder;
    }

    public String getSetorder() {
        return setorder;
    }

    public void setLawtype(String lawtype) {
        this.lawtype = lawtype;
//        this.lawtypename =
//                Utils.getTextFromBundle(Constants.BUNDLE_QLA, Constants.CATEGORIES.CaseLevel, this.getLawtype());
    }

    public String getLawtype() {
        return lawtype;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getGroupname() {
        return groupname;
    }


    public void setCodename(String codename) {
        this.codename = codename;
    }

    public String getCodename() {
        return codename;
    }

    public void setLawdates(String lawdates) {
        this.lawdates = lawdates;
    }

    public String getLawdates() {
        return lawdates;
    }

    public void setLawtypename(String lawtypename) {
        this.lawtypename = lawtypename;
    }

    public String getLawtypename() {
        return lawtypename;
    }

    public void setLawnamedetail(String lawnamedetail) {
        this.lawnamedetail = lawnamedetail;
    }

    public String getLawnamedetail() {
        return lawnamedetail;
    }

    public String getLawname1() {
        return lawname;
    }

    public void setSetnum(String setnum) {
        this.setnum = setnum;
    }

    public String getSetnum() {
        return setnum;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getIndate() {
        return indate;
    }

    public void setActdate(Date actdate) {
        this.actdate = actdate;
    }

    public Date getActdate() {
        return actdate;
    }

    public void setCasename(String casename) {
        this.casename = casename;
    }

    public String getCasename() {
        return casename;
    }

    public void setCasecode(String casecode) {
        this.casecode = casecode;
    }

    public String getCasecode() {
        return casecode;
    }

    public void setAccucode(String accucode) {
        this.accucode = accucode;
    }

    public String getAccucode() {
        return accucode;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setTodate(Date todate) {
        this.todate = todate;
    }

    public Date getTodate() {
        return todate;
    }

    public void setLawname_txt(String lawname_txt) {
        this.lawname_txt = lawname_txt;
    }

    public String getLawname_txt() {
        return lawname_txt;
    }


//    public void setChecklawcode(boolean checklawcode) {
//        this.checklawcode = checklawcode;
//    }
    public void setChecklawcode(String checklawcode) {
        this.checklawcode = Utils.toBoolean(checklawcode);
    }

    public boolean isChecklawcode() {
        return checklawcode;
    }

    public String toString() {
        if (lawcode == null || lawcode.isEmpty())
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append("Ä�iá»�u ");
        sb.append(lawid);
        if (item != null && !item.isEmpty()) {
            sb.append(" - Khoáº£n ");
            sb.append(item);
            if (point != null && !point.isEmpty()) {
                sb.append(" - Ä�iá»ƒm");
                sb.append(point);
            }
        }
        sb.append(" - ");
        sb.append(lawname);

        return sb.toString();
    }

    public void setBegin_indate(Date begin_indate) {
        this.begin_indate = begin_indate;
    }

    public Date getBegin_indate() {
        return begin_indate;
    }

    public void setBegin_setnum(String begin_setnum) {
        this.begin_setnum = begin_setnum;
    }

    public String getBegin_setnum() {
        return begin_setnum;
    }
}
