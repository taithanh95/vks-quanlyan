package com.bitsco.vks.entity;

import com.bitsco.vks.utils.Utils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SppAccused {
    public SppAccused() {
        super();
    }

    private String casecode;
    private String casename;
    private String regicode;
    private String accucode;
    private String fullname;
    private String othername;
    private String aliasname;
    private Date birthday;
    private Date birthdayfrom;
    private Date birthdayto;
    private String sex;
    private String identify;
    private Date identifyd;
    private String identifyw;
    private boolean inparty;
    private String occuid;
    private String occuname;
    private String religion;
    private boolean heroin;
    private String repeater;
    private int conviction;
    private int offence;
    private Date crimdate;
    private String crimtime;
    private boolean wander;
    private int age;
    private String lawcode;
    private String g3_pnt;
    private String g4_pnt;
    private String begin_setnum;
    private Date begin_indate;
    private boolean unoccupation;
    private String firstacc;
    private boolean occuteler;
    private boolean occudishonest;
    private boolean occureeducate;
    private boolean occusoldier;
    private boolean occustudent;
    private boolean occuofficer;
    private boolean dpvndtn;
    private String ten_nbc;

    private String status;
    private Date statusdate;
    private String lawid;
    private String locaid;
    private String locaname;
    private String address;
    private String addrname;
    private String remark; //nÆ¡i cÆ° trÃº
    private Date indatefrom;
    private Date indateto;
    private String sppid;
    private String counid;
    private String counname;
    private String crimwhere;
    private String natiid;
    private String natiname;
    private String levelid;
    private String levelname;
    private String officeid;
    private String partyid;
    private String bday;
    private String bmonth;
    private String byear;
    private boolean available;
    private String begin_spp;
    private String begin_office;
    private String begin_officeid;
    private String lastdecicode;
    private Date lastdeciindate;
    private String rstatus;
    private String rcasecode;
    private String legalper;

    //duclm8
    private boolean baochua;
    private boolean bcvnd;
    private boolean tgvpl;
    private SppAccadditioninfo sppAccadditioninfo;
    private List<SppViolantion> lstViolantion;
    private List<PreventMeasures> lstPreventMeasures;

    //bổ sung id bị can sổ thụ lý
    private String arresteeId;

    public void setLstPreventMeasures(List<PreventMeasures> lstPreventMeasures) {
        this.lstPreventMeasures = lstPreventMeasures;
    }

    public List<PreventMeasures> getLstPreventMeasures() {
        return lstPreventMeasures;
    }

    public void setLstViolantion(List<SppViolantion> lstViolantion) {
        this.lstViolantion = lstViolantion;
    }

    public List<SppViolantion> getLstViolantion() {
        return lstViolantion;
    }

    public void setSppAccadditioninfo(SppAccadditioninfo sppAccadditioninfo) {
        this.sppAccadditioninfo = sppAccadditioninfo;
    }

    public SppAccadditioninfo getSppAccadditioninfo() {
        return sppAccadditioninfo;
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

    public void setOthername(String othername) {
        this.othername = othername;
    }

    public String getOthername() {
        return othername;
    }

    public void setAliasname(String aliasname) {
        this.aliasname = aliasname;
    }

    public String getAliasname() {
        return aliasname;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentifyd(Date identifyd) {
        this.identifyd = identifyd;
    }

    public Date getIdentifyd() {
        return identifyd;
    }

    public void setIdentifyw(String identifyw) {
        this.identifyw = identifyw;
    }

    public String getIdentifyw() {
        return identifyw;
    }


    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getReligion() {
        return religion;
    }

    public void setRepeater(String repeater) {
        this.repeater = repeater;
    }

    public String getRepeater() {
        return repeater;
    }

    public void setConviction(int conviction) {
        this.conviction = conviction;
    }

    public int getConviction() {
        return conviction;
    }

    public void setOffence(int offence) {
        this.offence = offence;
    }

    public int getOffence() {
        return offence;
    }

    public void setCrimdate(Date crimdate) {
        this.crimdate = crimdate;
    }

    public Date getCrimdate() {
        return crimdate;
    }

    public void setCrimtime(String crimtime) {
        this.crimtime = crimtime;
    }

    public String getCrimtime() {
        return crimtime;
    }

    //    public void setWander(boolean wander) {
//        this.wander = wander;
//    }
    public void setWander(String wander) {
        this.wander = Utils.toBoolean(wander);
    }

    public boolean getWander() {
        return wander;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setLawcode(String lawcode) {
        this.lawcode = lawcode;
    }

    public String getLawcode() {
        return lawcode;
    }

    public void setG3_pnt(String g3_pnt) {
        this.g3_pnt = g3_pnt;
    }

    public String getG3_pnt() {
        return g3_pnt;
    }

    public void setG4_pnt(String g4_pnt) {
        this.g4_pnt = g4_pnt;
    }

    public String getG4_pnt() {
        return g4_pnt;
    }

    public void setBegin_setnum(String begin_setnum) {
        this.begin_setnum = begin_setnum;
    }

    public String getBegin_setnum() {
        return begin_setnum;
    }

    public void setBegin_indate(Date begin_indate) {
        this.begin_indate = begin_indate;
    }

    public Date getBegin_indate() {
        return begin_indate;
    }

    public void setFirstacc(String firstacc) {
        this.firstacc = firstacc;
    }

    public String getFirstacc() {
        return firstacc;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatusdate(Date statusdate) {
        this.statusdate = statusdate;
    }

    public Date getStatusdate() {
        return statusdate;
    }

    public void setLawid(String lawid) {
        this.lawid = lawid;
    }

    public String getLawid() {
        return lawid;
    }

    public void setAddrname(String addrname) {
        this.addrname = addrname;
    }

    public String getAddrname() {
        return addrname;
    }

    public void setLocaname(String locaname) {
        this.locaname = locaname;
    }

    public String getLocaname() {
        return locaname;
    }

    public void setCasecode(String casecode) {
        this.casecode = casecode;
    }

    public String getCasecode() {
        return casecode;
    }

    public void setSppid(String sppid) {
        this.sppid = sppid;
    }

    public String getSppid() {
        return sppid;
    }

    public void setCounid(String counid) {
        this.counid = counid;
    }

    public String getCounid() {
        return counid;
    }

    public void setLevelid(String levelid) {
        this.levelid = levelid;
    }

    public String getLevelid() {
        return levelid;
    }

    public void setCrimwhere(String crimwhere) {
        this.crimwhere = crimwhere;
    }

    public String getCrimwhere() {
        return crimwhere;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setLocaid(String locaid) {
        this.locaid = locaid;
    }

    public String getLocaid() {
        return locaid;
    }

    public void setNatiid(String natiid) {
        this.natiid = natiid;
    }

    public String getNatiid() {
        return natiid;
    }

    public void setOccuid(String occuid) {
        this.occuid = occuid;
    }

    public String getOccuid() {
        return occuid;
    }

    public void setOfficeid(String officeid) {
        this.officeid = officeid;
    }

    public String getOfficeid() {
        return officeid;
    }

    public void setPartyid(String partyid) {
        this.partyid = partyid;
    }

    public String getPartyid() {
        return partyid;
    }

    public void setBirthdayfrom(Date birthdayfrom) {
        this.birthdayfrom = birthdayfrom;
    }

    public Date getBirthdayfrom() {
        return birthdayfrom;
    }

    public void setBirthdayto(Date birthdayto) {
        this.birthdayto = birthdayto;
    }

    public Date getBirthdayto() {
        return birthdayto;
    }

    public void setCasename(String casename) {
        this.casename = casename;
    }

    public String getCasename() {
        return casename;
    }


    public void setIndatefrom(Date indatefrom) {
        this.indatefrom = indatefrom;
    }

    public Date getIndatefrom() {
        return indatefrom;
    }

    public void setIndateto(Date indateto) {
        this.indateto = indateto;
    }

    public Date getIndateto() {
        return indateto;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    //    public void setInparty(boolean inparty) {
//        this.inparty = inparty;
//    }
    public void setInparty(String inparty) {
        this.inparty = Utils.toBoolean(inparty);
    }

    public boolean getInparty() {
        return inparty;
    }

    //    public void setHeroin(boolean heroin) {
//        this.heroin = heroin;
//    }
    public void setHeroin(String heroin) {
        this.heroin = Utils.toBoolean(heroin);
    }

    public boolean getHeroin() {
        return heroin;
    }

    //    public void setUnoccupation(boolean unoccupation) {
//        this.unoccupation = unoccupation;
//    }
    public void setUnoccupation(String unoccupation) {
        this.unoccupation = Utils.toBoolean(unoccupation);
    }

    public boolean getUnoccupation() {
        return unoccupation;
    }

    //    public void setOccuteler(boolean occuteler) {
//        this.occuteler = occuteler;
//    }
    public void setOccuteler(String occuteler) {
        this.occuteler = Utils.toBoolean(occuteler);
    }

    public boolean getOccuteler() {
        return occuteler;
    }

    //    public void setOccudishonest(boolean occudishonest) {
//        this.occudishonest = occudishonest;
//    }
    public void setOccudishonest(String occudishonest) {
        this.occudishonest = Utils.toBoolean(occudishonest);
    }

    public boolean getOccudishonest() {
        return occudishonest;
    }

    //    public void setOccureeducate(boolean occureeducate) {
//        this.occureeducate = occureeducate;
//    }
    public void setOccureeducate(String occureeducate) {
        this.occureeducate = Utils.toBoolean(occureeducate);
    }

    public boolean getOccureeducate() {
        return occureeducate;
    }

    //    public void setOccusoldier(boolean occusoldier) {
//        this.occusoldier = occusoldier;
//    }
    public void setOccusoldier(String occusoldier) {
        this.occusoldier = Utils.toBoolean(occusoldier);
    }

    public boolean getOccusoldier() {
        return occusoldier;
    }

    //    public void setOccustudent(boolean occustudent) {
//        this.occustudent = occustudent;
//    }
    public void setOccustudent(String occustudent) {
        this.occustudent = Utils.toBoolean(occustudent);
    }

    public boolean getOccustudent() {
        return occustudent;
    }

    public void setDpvndtn(String dpvndtn) {
        this.dpvndtn = Utils.toBoolean(dpvndtn);
    }

    public boolean getDpvndtn() {
        return dpvndtn;
    }

    //    public void setOccuofficer(boolean occuofficer) {
//        this.occuofficer = occuofficer;
//    }
    public void setOccuofficer(String occuofficer) {
        this.occuofficer = Utils.toBoolean(occuofficer);
    }

    public boolean getOccuofficer() {
        return occuofficer;
    }

    public void setOccuname(String occuname) {
        this.occuname = occuname;
    }

    public String getOccuname() {
        return occuname;
    }

    public void setCounname(String counname) {
        this.counname = counname;
    }

    public String getCounname() {
        return counname;
    }

    public void setNatiname(String natiname) {
        this.natiname = natiname;
    }

    public String getNatiname() {
        return natiname;
    }

    public void setTen_nbc(String ten_nbc) {
        this.ten_nbc = ten_nbc;
    }

    public String getTen_nbc() {
        return ten_nbc;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname;
    }

    public String getLevelname() {
        return levelname;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    public String getBday() {
        return bday;
    }

    public void setBmonth(String bmonth) {
        this.bmonth = bmonth;
    }

    public String getBmonth() {
        return bmonth;
    }

    public void setByear(String byear) {
        this.byear = byear;
    }

    public String getByear() {
        if ((byear == null || byear.isEmpty()) && birthday != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(birthday);
            return String.valueOf(calendar.get(Calendar.YEAR));
        }
        return byear;
    }

    public void setRegicode(String regicode) {
        this.regicode = regicode;
    }

    public String getRegicode() {
        return regicode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(accucode);
        sb.append(" - ");
        sb.append(fullname);
        if (aliasname != null) {
            sb.append(" (");
            sb.append(aliasname);
            sb.append(")");
        }
        return sb.toString();
    }

    //    public void setAvailable(boolean available) {
//        this.available = available;
//    }
    public void setAvailable(String available) {
        this.available = Utils.toBoolean(available);
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean isAdult() {
        return true;
    }

    public void setBegin_office(String begin_office) {
        this.begin_office = begin_office;
    }

    public String getBegin_office() {
        return begin_office;
    }

    public void setBegin_officeid(String begin_officeid) {
        this.begin_officeid = begin_officeid;
    }

    public String getBegin_officeid() {
        return begin_officeid;
    }

    public void setLastdecicode(String lastdecicode) {
        this.lastdecicode = lastdecicode;
    }

    public String getLastdecicode() {
        return lastdecicode;
    }

    public void setLastdeciindate(Date lastdeciindate) {
        this.lastdeciindate = lastdeciindate;
    }

    public Date getLastdeciindate() {
        return lastdeciindate;
    }

    public void setRstatus(String rstatus) {
        this.rstatus = rstatus;
    }

    public String getRstatus() {
        return rstatus;
    }

    public void setRcasecode(String rcasecode) {
        this.rcasecode = rcasecode;
    }

    public String getRcasecode() {
        return rcasecode;
    }

    public void setBegin_spp(String begin_spp) {
        this.begin_spp = begin_spp;
    }

    public String getBegin_spp() {
        return begin_spp;
    }

    public void setLegalper(String legalper) {
        this.legalper = legalper;
    }

    public String getLegalper() {
        return legalper;
    }

    //    public void setBaochua(boolean baochua) {
//        this.baochua = baochua;
//    }
    public void setBaochua(String baochua) {
        this.baochua = Utils.toBoolean(baochua);
    }

    public boolean getBaochua() {
        return baochua;
    }

    //    public void setBcvnd(boolean bcvnd) {
//        this.bcvnd = bcvnd;
//    }
    public void setBcvnd(String bcvnd) {
        this.bcvnd = Utils.toBoolean(bcvnd);
    }

    public boolean getBcvnd() {
        return bcvnd;
    }

    //    public void setTgvpl(boolean tgvpl) {
//        this.tgvpl = tgvpl;
//    }
    public void setTgvpl(String tgvpl) {
        this.tgvpl = Utils.toBoolean(tgvpl);
    }

    public boolean getTgvpl() {
        return tgvpl;
    }

    public String getArresteeId() { return arresteeId; }

    public void setArresteeId(String arresteeId) { this.arresteeId = arresteeId; }
}
