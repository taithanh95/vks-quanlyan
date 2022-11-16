package com.bitsco.vks.entity;

import com.bitsco.vks.utils.Constants;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class SppDecision extends UpdateBaseEntity {
    private String decicode;
    //    private String regicode;
    private String deciid;
    private String decitypeid;
    private String decitypename;
    private String setnumdeci;
    private Date indate;
    private String sppid;
    private String spcid;
    private String polid;
    private String content;
    private Date fromdate;
    private Date todate;
    private Date finishdate;
    private String accucode;
    private String reasonid;
    private String signname;
    private String signoffice;
    private String accuname;
    private String lawcode;
    private String decicodefinish;
    private String deciname;
    private String reasonname;
    private String decitype;
    private Date indateregi;
    //    private String casecode;
    //    private String casename;
    private String applyfor;
    //    private String userfor;
    private String state;
    private List<LstDecisionEntity> lstDecitype; //load loáº¡i quyáº¿t Ä‘á»‹nh
    private List<LstDecisionEntity> lstDecision; // load tÃªn quyáº¿t Ä‘á»‹nh
    private List<LstReason> lstReason; //load LÃ½ do quyáº¿t Ä‘á»‹nh
    private Map<String, String> lstDonViRaQD; //Ä�Æ¡n vá»‹ ra QÄ�
    private String donViRaQD;
    private String c;
    private LstSPC atxSpc;
    private LstSPP atxSpp;
    private LstPol atxPol;
    private LstPolice atxPolice;
    private LstArmyEntity atxArmy;
    private LstRanger atxRanger;
    private LstCustoms atxCustoms;
    private LstBorderGuards atxBorderGuards;
    private LstInspector atxInsp;
    protected List<LstDecisionEntity> time = null; //XÃ¡c Ä‘á»‹nh setunit cho tá»«ng quyáº¿t Ä‘á»‹nh

    private int settime;
    private String setunit;
    private int esettime;
    private String esetunit;
    private String sid_txt;
    private String settime_txt;
    private String esettime_txt;
    private String timelimit;
    private String begin_office;
    private String begin_officeid;
    private String dvrqd;
    private String timefrom;
    private String timeto;
    private Integer registerdeciid;
    private int hfrom = 0;
    private int mfrom = 0;
    private int hto = 23;
    private int mto = 59;

    private boolean rutgon;

    public void setRutgon(boolean rutgon) {
        this.rutgon = rutgon;
    }

    public boolean getRutgon() {
        return rutgon;
    }
    public SppDecision() {
        super();
    }

    public void setDecicode(String decicode) {
        this.decicode = decicode;
    }

    public String getDecicode() {
        return decicode;
    }

    public void setDeciid(String deciid) {
        this.deciid = deciid;
    }

    public String getDeciid() {
        return deciid;
    }

    public void setDeciname(String deciname) {
        this.deciname = deciname;
    }

    public String getDeciname() {
        return deciname;
    }

    //    public void setSetnum(String setnum) {
    //        this.setnum = setnum;
    //    }
    //
    //    public String getSetnum() {
    //        return setnum;
    //    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getIndate() {
        return indate;
    }

    public void setSppid(String sppid) {
        this.sppid = sppid;
    }

    public String getSppid() {
        return sppid;
    }

    public void setSpcid(String spcid) {
        this.spcid = spcid;
    }

    public String getSpcid() {
        return spcid;
    }

    public void setPolid(String polid) {
        this.polid = polid;
    }

    public String getPolid() {
        return polid;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
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

    public void setFinishdate(Date finishdate) {
        this.finishdate = finishdate;
    }

    public Date getFinishdate() {
        return finishdate;
    }

    public void setAccucode(String accucode) {
        this.accucode = accucode;
    }

    public String getAccucode() {
        return accucode;
    }

    public void setAccuname(String accuname) {
        this.accuname = accuname;
    }

    public String getAccuname() {
        return accuname;
    }

    public void setReasonid(String reasonid) {
        this.reasonid = reasonid;
    }

    public String getReasonid() {
        return reasonid;
    }

    public void setSignname(String signname) {
        this.signname = signname;
    }

    public String getSignname() {
        return signname;
    }

    public void setSignoffice(String signoffice) {
        this.signoffice = signoffice;
    }

    public String getSignoffice() {
        return signoffice;
    }

    public void setLawcode(String lawcode) {
        this.lawcode = lawcode;
    }

    public String getLawcode() {
        return lawcode;
    }

    public void setDecicodefinish(String decicodefinish) {
        this.decicodefinish = decicodefinish;
    }

    public String getDecicodefinish() {
        return decicodefinish;
    }

    //    public void setUserfor(String userfor) {
    //        this.userfor = userfor;
    //    }
    //
    //    public String getUserfor() {
    //        return userfor;
    //    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setApplyfor(String applyfor) {
        this.applyfor = applyfor;
    }

    public String getApplyfor() {
        return applyfor;
    }

    //    public void setCasecode(String casecode) {
    //        this.casecode = casecode;
    //    }
    //
    //    public String getCasecode() {
    //        return casecode;
    //    }
    //
    //    public void setCasename(String casename) {
    //        this.casename = casename;
    //    }
    //
    //    public String getCasename() {
    //        return casename;
    //    }
    //
    //    public void setRegicode(String regicode) {
    //        this.regicode = regicode;
    //    }
    //
    //    public String getRegicode() {
    //        return regicode;
    //    }

    public void setReasonname(String reasonname) {
        this.reasonname = reasonname;
    }

    public String getReasonname() {
        return reasonname;
    }

    public void setLstDecitype(List<LstDecisionEntity> lstDecitype) {
        this.lstDecitype = lstDecitype;
    }

    public List<LstDecisionEntity> getLstDecitype() {
        return lstDecitype;
    }

    public void setLstDecision(List<LstDecisionEntity> lstDecision) {
        this.lstDecision = lstDecision;
    }

    public List<LstDecisionEntity> getLstDecision() {
        return lstDecision;
    }

    public void setDecitypeid(String decitypeid) {
        this.decitypeid = decitypeid;
    }

    public String getDecitypeid() {
        return decitypeid;
    }

    public void setLstReason(List<LstReason> lstReason) {
        this.lstReason = lstReason;
    }

    public List<LstReason> getLstReason() {
        return lstReason;
    }

    public void setLstDonViRaQD(Map<String, String> lstDonViRaQD) {
        this.lstDonViRaQD = lstDonViRaQD;
    }

    public Map<String, String> getLstDonViRaQD() {
        return lstDonViRaQD;
    }

    public void setDonViRaQD(String donViRaQD) {

        this.donViRaQD = donViRaQD;
    }

    public String getDonViRaQD() {
//        if (this.getBegin_officeid() != null)
//            if (this.getBegin_office().equalsIgnoreCase(Constants.DONVIRAQD_ARMY)) {
//                try {
//                    this.setAtxArmy((LstArmyEntity)new LstArmyDAO().get(this.getBegin_officeid()));
//                } catch (Exception e) {
//                    e.getMessage();
//                }
//                this.donViRaQD = this.getAtxArmy().getName();
//            } else if (this.getBegin_office().equalsIgnoreCase(Constants.DONVIRAQD_POLICE)) {
//                try {
//                    this.setAtxPolice((LstPolice)new LstPoliceDAO().get(this.getBegin_officeid()));
//                } catch (Exception e) {
//                    e.getMessage();
//                }
//                this.donViRaQD = this.getAtxPolice().getName();
//            } else if (this.getBegin_office().equalsIgnoreCase(Constants.DONVIRAQD_RANGER)) {
//                try {
//                    this.setAtxRanger((LstRanger)new LstRangerDAO().get(this.getBegin_officeid()));
//                } catch (Exception e) {
//                    e.getMessage();
//                }
//                this.donViRaQD = this.getAtxRanger().getName();
//            } else if (this.getBegin_office().equalsIgnoreCase(Constants.DONVIRAQD_SPP)) {
//                try {
//                    this.setAtxSpp((LstSPP)new LstSPPDAO().get(this.getBegin_officeid()));
//                } catch (Exception e) {
//                    e.getMessage();
//                }
//                this.donViRaQD = this.getAtxSpp().getName();
//            } else if (this.getBegin_office().equalsIgnoreCase(Constants.DONVIRAQD_SPC)) {
//                try {
//                    this.setAtxSpc((LstSPC)new LstSpcDAO().get(this.getBegin_officeid()));
//                } catch (Exception e) {
//                    e.getMessage();
//                }
//                this.donViRaQD = this.getAtxSpc().getName();
//            } else if (this.getBegin_office().equalsIgnoreCase(Constants.DONVIRAQD_CUSTOM)) {
//                try {
//                    this.setAtxCustoms((LstCustoms)new LstCustomsDAO().get(this.getBegin_officeid()));
//                } catch (Exception e) {
//                    e.getMessage();
//                }
//                this.donViRaQD = this.getAtxCustoms().getName();
//            } else if (this.getBegin_office().equalsIgnoreCase(Constants.DONVIRAQD_BORGUA)) {
//                try {
//                    this.setAtxBorderGuards((LstBorderGuards)new LstBorderGuardsDAO().get(this.getBegin_officeid()));
//                } catch (Exception e) {
//                    e.getMessage();
//                }
//                this.donViRaQD = this.getAtxBorderGuards().getName();
//            }
        return donViRaQD;
    }

    public void setAtxSpc(LstSPC atxSpc) {
        this.atxSpc = atxSpc;
    }

    public LstSPC getAtxSpc() {
        return atxSpc;
    }

    public void setAtxSpp(LstSPP atxSpp) {
        this.atxSpp = atxSpp;
    }

    public LstSPP getAtxSpp() {
        return atxSpp;
    }

    public void setAtxPol(LstPol atxPol) {
        this.atxPol = atxPol;
    }

    public LstPol getAtxPol() {
        return atxPol;
    }

    public void setSetnumdeci(String setnumdeci) {
        this.setnumdeci = setnumdeci;
    }

    public String getSetnumdeci() {
        return setnumdeci;
    }

    public void setAtxInsp(LstInspector atxInsp) {
        this.atxInsp = atxInsp;
    }

    public LstInspector getAtxInsp() {
        return atxInsp;
    }

    public void setDecitype(String decitype) {
        this.decitype = decitype;
    }

    public String getDecitype() {
        return decitype;
    }

    public void setDecitypename(String decitypename) {
        this.decitypename = decitypename;
    }

    public String getDecitypename() {
        return decitypename;
    }

    public void setTime(List<LstDecisionEntity> time) {
        this.time = time;
    }

    public List<LstDecisionEntity> getTime() {
        return time;
    }

    public void setIndateregi(Date indateregi) {
        this.indateregi = indateregi;
    }

    public Date getIndateregi() {
        return indateregi;
    }

    public void setSettime(int settime) {
        this.settime = settime;
    }

    public int getSettime() {
        return settime;
    }

    public void setSetunit(String setunit) {
        this.setunit = setunit;
    }

    public String getSetunit() {
        return setunit;
    }

    public void setEsettime(int esettime) {
        this.esettime = esettime;
    }

    public int getEsettime() {
        return esettime;
    }

    public void setEsetunit(String esetunit) {
        this.esetunit = esetunit;
    }

    public String getEsetunit() {
        return esetunit;
    }

    public void setSid_txt(String sid_txt) {
        this.sid_txt = sid_txt;
    }

    public String getSid_txt() {
        return sid_txt;
    }

    public void setSettime_txt(String settime_txt) {
        this.settime_txt = settime_txt;
    }

    public String getSettime_txt() {
        return settime_txt;
    }

    public void setEsettime_txt(String esettime_txt) {
        this.esettime_txt = esettime_txt;
    }

    public String getEsettime_txt() {
        return esettime_txt;
    }

    public void setTimelimit(String timelimit) {
        this.timelimit = timelimit;
    }

    public String getTimelimit() {
        return timelimit;
    }

    public void setAtxPolice(LstPolice atxPolice) {
        this.atxPolice = atxPolice;
    }

    public LstPolice getAtxPolice() {
        return atxPolice;
    }

    public void setAtxArmy(LstArmyEntity atxArmy) {
        this.atxArmy = atxArmy;
    }

    public LstArmyEntity getAtxArmy() {
        return atxArmy;
    }

    public void setAtxRanger(LstRanger atxRanger) {
        this.atxRanger = atxRanger;
    }

    public LstRanger getAtxRanger() {
        return atxRanger;
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

    public void setDvrqd(String dvrqd) {
        this.dvrqd = dvrqd;
    }

    public String getDvrqd() {
        return dvrqd;
    }

    public void setTimefrom(String timefrom) {
        this.timefrom = timefrom;
        hfrom = Integer.parseInt(timefrom.split(":")[0]);
        mfrom = Integer.parseInt(timefrom.split(":")[1]);
    }

    public String getTimefrom() {
        return timefrom;
    }

    public void setTimeto(String timeto) {
        this.timeto = timeto;
        hto = Integer.parseInt(timeto.split(":")[0]);
        mto = Integer.parseInt(timeto.split(":")[1]);
    }

    public String getTimeto() {
        return timeto;
    }

    public void setHfrom(int hfrom) {
        this.hfrom = hfrom;
    }

    public int getHfrom() {
        return hfrom;
    }

    public void setMfrom(int mfrom) {
        this.mfrom = mfrom;
    }

    public int getMfrom() {
        return mfrom;
    }

    public void setHto(int hto) {
        this.hto = hto;
    }

    public int getHto() {
        return hto;
    }

    public void setMto(int mto) {
        this.mto = mto;
    }

    public int getMto() {
        return mto;
    }

    public void setAtxCustoms(LstCustoms atxCustoms) {
        this.atxCustoms = atxCustoms;
    }

    public LstCustoms getAtxCustoms() {
        return atxCustoms;
    }

    public void setAtxBorderGuards(LstBorderGuards atxBorderGuards) {
        this.atxBorderGuards = atxBorderGuards;
    }

    public LstBorderGuards getAtxBorderGuards() {
        return atxBorderGuards;
    }

    public Integer getRegisterdeciid() { return registerdeciid; }

    public void setRegisterdeciid(Integer registerdeciid) { this.registerdeciid = registerdeciid; }
}
