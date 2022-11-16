package com.bitsco.vks.entity;
import com.bitsco.vks.utils.Utils;

import java.util.Date;
import java.util.List;

public class SppCase {
    public SppCase() {
        super();
    }

    private String casecode;
    private String casename;
    private String casetype;
    private String casetypename;
    private String setnum; //sá»‘ thá»¥ lÃ½
    private String regicode;
    private Date indate; //ngÃ y thá»¥ lÃ½
    private String userfor;
    private String remark;
    private String spccasecode;
    private Date crimdate;
    private String crimtime;
    private String orisppid;
    private String begin_setnum;
    private Date begin_indate;
    private String lawcode;
    private String lawcode_txt;
    private String firstacc;
    private String firstacc_txt;
    private String alias;
    private String lawid;
    private String status;
    private String statusdate;
    private String crimdate1;
    private String crimwhere1;
    private String crimwhere;
    private String begin_pol;
    private String begin_spc;
    private String begin_spp;
    private String sppid;
    private String address;
    private String begin_office;
    private String begin_officeid;

    private String sppspcid;
    private Date crimdate_from;
    private Date crimdate_to;
    private Date begin_indatefrom;
    private Date begin_indateto;
    private String sid;
    private String sid_txt;
    private String crimwhere_txt;
    private String casestatus_txt;

    private String codeid;
    private String transfer;
    private String fullname;
    private String remark_name;
    private String setnum_BA;
    private Date indate_BA;
    private String name;
    private String accucode;

    private String cday;
    private String cmonth;
    private String cyear;

    private String transcode;
    private String transid;

    private LstSPP atxSpp;
    private LstSPC atxSpc;
    private LstPolice atxPol;
    private LstArmyEntity atxArmy;
    private LstRanger atxRanger;
    private LstCustoms atxCustoms;
    private LstBorderGuards atxBorderGuards;
    private LstLaw atxLaw;
    private LstLocation atxLocation;
    private boolean checkorisppid;
    private Boolean checkcrimdate;
    private String checktrans;
    private boolean autolaw;
    private Date actdate;
    private String rname;
    private boolean editable;
    private String caseisnew;

    //duclm8 add 16.06.2017
    private boolean ghihinh;
    private boolean dienthoai;
    private boolean dientu;
    //7
    private String kham_nghiem_hien_truong;
    private String nhan_dang;
    private String kham_xet;
    private String kham_nghiem_tu_thi;
    private String nhan_biet_giong_noi;
    private String thuc_nghiem_dieu_tra;
    private String doi_chat;


    private String kham_nghiem_hien_truong_ko;
    private String nhan_dang_ko;
    private String kham_xet_ko;
    private String kham_nghiem_tu_thi_ko;
    private String nhan_biet_giong_noi_ko;
    private String thuc_nghiem_dieu_tra_ko;
    private String doi_chat_ko;



    private boolean vks_y_c_khoi_to;
    private String tt_hoi_cung;
    private String tt_lk_nbd_ds;
    private String tg_hoi_cung;
    private String tt_lk_bb_tg;
    private String tt_lk_nlc;
    private String tt_lk_nbh;
    private String tg_lk;
    private String tt_lk_nbb_ntg_nlc_nbh;

    private Date fromdate;
    private int settime;
    private int esettime;
    private Date finishdate1;
    private String signname;
    private String signoffice;
    //thêm thông tin id tin báo liên quan
    private String denouncementid;
    private List<SppInvestment> lstInvestment;
    private List<String> lstInvecode;

    public List<SppInvestment> getLstInvestment() {return lstInvestment;}

    public void setLstInvestment(List<SppInvestment> lstInvestment) {this.lstInvestment = lstInvestment;}

    public List<String> getLstInvecode() {return lstInvecode;}

    public void setLstInvecode(List<String> lstInvecode) {this.lstInvecode = lstInvecode;}

    public String getDenouncementid() { return denouncementid; }

    public void setDenouncementid(String denouncementid) { this.denouncementid = denouncementid; }

    public void setFromDate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public Date getFromDate() {
        return fromdate;
    }

    public void setSettime(int settime) {
        this.settime = settime;
    }

    public int getSettime() {
        return settime;
    }

    public void setEsettime(int esettime) {
        this.esettime = esettime;
    }

    public int getEsettime() {
        return esettime;
    }

    public void setFinishdate(Date finishdate1) {
        this.finishdate1 = finishdate1;
    }

    public Date getFinishdate() {
        return finishdate1;
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





    public void settt_lk_nbb_ntg_nlc_nbh(String tt_lk_nbb_ntg_nlc_nbh) {
        this.tt_lk_nbb_ntg_nlc_nbh = tt_lk_nbb_ntg_nlc_nbh;
    }

    public String gettt_lk_nbb_ntg_nlc_nbh() {
        return (tt_lk_nbb_ntg_nlc_nbh == null) ? "0" : tt_lk_nbb_ntg_nlc_nbh;
    }

    public void settg_lk(String tg_lk) {
        this.tg_lk = tg_lk;
    }

    public String gettg_lk() {
        return (tg_lk == null) ? "0" : tg_lk;
    }

    public void settt_lk_nlc(String tt_lk_nlc) {
        this.tt_lk_nlc = tt_lk_nlc;
    }

    public String gettt_lk_nlc() {
        return (tt_lk_nlc == null) ? "0" : tt_lk_nlc;
    }
    public void settt_lk_nbh(String tt_lk_nbh) {
        this.tt_lk_nbh = tt_lk_nbh;
    }

    public String gettt_lk_nbh() {
        return (tt_lk_nbh == null) ? "0" : tt_lk_nbh;

    }

    public void setKham_nghiem_hien_truong_ko(String kham_nghiem_hien_truong_ko) {
        this.kham_nghiem_hien_truong_ko = kham_nghiem_hien_truong_ko;
    }

    public String getKham_nghiem_hien_truong_ko() {
        return (kham_nghiem_hien_truong_ko == null) ? "0" : kham_nghiem_hien_truong_ko;
    }

    public void setNhan_dang_ko(String nhan_dang_ko) {
        this.nhan_dang_ko = nhan_dang_ko;
    }

    public String getNhan_dang_ko() {
        return (nhan_dang_ko == null) ? "0" : nhan_dang_ko;

    }
    public void setKham_xet_ko(String kham_xet_ko) {
        this.kham_xet_ko = kham_xet_ko;
    }

    public String getKham_xet_ko() {
        return (kham_xet_ko == null) ? "0" : kham_xet_ko;
    }
    public void setKham_nghiem_tu_thi_ko(String kham_nghiem_tu_thi_ko) {
        this.kham_nghiem_tu_thi_ko = kham_nghiem_tu_thi_ko;
    }

    public String getKham_nghiem_tu_thi_ko() {
        return (kham_nghiem_tu_thi_ko == null) ? "0" : kham_nghiem_tu_thi_ko;
    }
    public void setNhan_biet_giong_noi_ko(String nhan_biet_giong_noi_ko) {
        this.nhan_biet_giong_noi_ko = nhan_biet_giong_noi_ko;
    }

    public String getNhan_biet_giong_noi_ko() {
        return (nhan_biet_giong_noi_ko == null) ? "0" : nhan_biet_giong_noi_ko;
    }
    public void setThuc_nghiem_dieu_tra_ko(String thuc_nghiem_dieu_tra_ko) {
        this.thuc_nghiem_dieu_tra_ko = thuc_nghiem_dieu_tra_ko;
    }

    public String getThuc_nghiem_dieu_tra_ko() {
        return (thuc_nghiem_dieu_tra_ko == null) ? "0" : thuc_nghiem_dieu_tra_ko;

    }
    public void setDoi_chat_ko(String doi_chat_ko) {
        this.doi_chat_ko = doi_chat_ko;
    }

    public String getDoi_chat_ko() {
        return (doi_chat_ko == null) ? "0" : doi_chat_ko;


    }

        public void settt_hoi_cung(String tt_hoi_cung) {
        this.tt_hoi_cung = tt_hoi_cung;
    }

    public String gettt_hoi_cung() {
        return (tt_hoi_cung == null) ? "0" : tt_hoi_cung;
    }


    public void settt_lk_nbd_ds(String tt_lk_nbd_ds) {
        this.tt_lk_nbd_ds = tt_lk_nbd_ds;
    }

    public String gettt_lk_nbd_ds() {
        return (tt_lk_nbd_ds == null) ? "0" : tt_lk_nbd_ds;
    }

    public void settg_hoi_cung(String tg_hoi_cung) {
        this.tg_hoi_cung = tg_hoi_cung;
    }

    public String gettg_hoi_cung() {
        return (tg_hoi_cung == null) ? "0" : tg_hoi_cung;
    }
//    public void setvks_y_c_khoi_to(boolean vks_y_c_khoi_to) {
//        this.vks_y_c_khoi_to = vks_y_c_khoi_to;
//    }
    public void setvks_y_c_khoi_to(String vks_y_c_khoi_to) {
        this.vks_y_c_khoi_to = Utils.toBoolean(vks_y_c_khoi_to);
    }
    public boolean isvks_y_c_khoi_to() {
        return vks_y_c_khoi_to;
    }
    public boolean getvks_y_c_khoi_to() {
        return vks_y_c_khoi_to;
    }



    public void settt_lk_bb_tg(String tt_lk_bb_tg) {
        this.tt_lk_bb_tg = tt_lk_bb_tg;
    }

    public String gettt_lk_bb_tg() {
        return (tt_lk_bb_tg == null) ? "0" : tt_lk_bb_tg;
    }


    public void setThuc_nghiem_dieu_tra(String thuc_nghiem_dieu_tra) {
        this.thuc_nghiem_dieu_tra = thuc_nghiem_dieu_tra;
    }

    public String getThuc_nghiem_dieu_tra() {
        return (thuc_nghiem_dieu_tra == null) ? "0" : thuc_nghiem_dieu_tra;
    }

    public void setDoi_chat(String doi_chat) {
        this.doi_chat = doi_chat;
    }

    public String getDoi_chat() {
        return (doi_chat == null) ? "0" : doi_chat;
    }


    public void setNhan_biet_giong_noi(String nhan_biet_giong_noi) {
        this.nhan_biet_giong_noi = nhan_biet_giong_noi;
    }

    public String getNhan_biet_giong_noi() {
        return (nhan_biet_giong_noi == null) ? "0" : nhan_biet_giong_noi;
    }

    public void setKham_nghiem_tu_thi(String kham_nghiem_tu_thi) {
        this.kham_nghiem_tu_thi = kham_nghiem_tu_thi;
    }

    public String getKham_nghiem_tu_thi() {
        return (kham_nghiem_tu_thi == null) ? "0" : kham_nghiem_tu_thi;

    }

    public void setKham_xet(String kham_xet) {
        this.kham_xet = kham_xet;
    }

    public String getKham_xet() {
        return (kham_xet == null) ? "0" : kham_xet;
    }


    public void setNhan_dang(String nhan_dang) {
        this.nhan_dang = nhan_dang;
    }

    public String getNhan_dang() {
        return (nhan_dang == null) ? "0" : nhan_dang;
    }

    public void setKham_nghiem_hien_truong(String kham_nghiem_hien_truong) {
        this.kham_nghiem_hien_truong = kham_nghiem_hien_truong;
    }

    public String getKham_nghiem_hien_truong() {
        return (kham_nghiem_hien_truong == null) ? "0" : kham_nghiem_hien_truong;
    }






    public void setCasecode(String casecode) {
        this.casecode = casecode;
    }

    public String getCasecode() {
        return casecode;
    }

    public void setCasename(String casename) {
        this.casename = casename;
    }

    public String getCasename() {
        return casename;
    }

    public void setSppid(String sppid) {
        this.sppid = sppid;
    }

    public String getSppid() {
        return sppid;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCasetype(String casetype) {
        this.casetype = casetype;
    }

    public String getCasetype() {
        return casetype;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setSpccasecode(String spccasecode) {
        this.spccasecode = spccasecode;
    }

    public String getSpccasecode() {
        return spccasecode;
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

    public void setOrisppid(String orisppid) {
        this.orisppid = orisppid;
    }

    public String getOrisppid() {
        return orisppid;
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

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public void setLawid(String lawid) {
        this.lawid = lawid;
    }

    public String getLawid() {
        return lawid;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatusdate(String statusdate) {
        this.statusdate = statusdate;
    }

    public String getStatusdate() {
        return statusdate;
    }

    public void setCrimdate1(String crimdate1) {
        this.crimdate1 = crimdate1;
    }

    public String getCrimdate1() {
        return crimdate1;
    }

    public void setCrimwhere1(String crimwhere1) {
        this.crimwhere1 = crimwhere1;
    }

    public String getCrimwhere1() {
        return crimwhere1;
    }

    public void setCrimwhere(String crimwhere) {
        this.crimwhere = crimwhere;
    }

    public String getCrimwhere() {
        return crimwhere;
    }

    public void setBegin_pol(String begin_pol) {
        this.begin_pol = begin_pol;
    }

    public String getBegin_pol() {
        return begin_pol;
    }

    public void setBegin_spc(String begin_spc) {
        this.begin_spc = begin_spc;
    }

    public String getBegin_spc() {
        return begin_spc;
    }

    public void setBegin_spp(String begin_spp) {
        this.begin_spp = begin_spp;
    }

    public String getBegin_spp() {
        return begin_spp;
    }

    public void setSppspcid(String sppspcid) {
        this.sppspcid = sppspcid;
    }

    public String getSppspcid() {
        return sppspcid;
    }

    public void setCrimdate_from(Date crimdate_from) {
        this.crimdate_from = crimdate_from;
    }

    public Date getCrimdate_from() {
        return crimdate_from;
    }

    public void setCrimdate_to(Date crimdate_to) {
        this.crimdate_to = crimdate_to;
    }

    public Date getCrimdate_to() {
        return crimdate_to;
    }

    public void setSid_txt(String sid_txt) {
        this.sid_txt = sid_txt;
    }

    public String getSid_txt() {
        return sid_txt;
    }

    public void setCodeid(String codeid) {
        this.codeid = codeid;
    }

    public String getCodeid() {
        return codeid;
    }

//    public void setCheckcrimdate(Boolean checkcrimdate) {
//        this.checkcrimdate = checkcrimdate;
//    }
    public void setCheckcrimdate(String checkcrimdate) {
        this.checkcrimdate = Utils.toBoolean(checkcrimdate);
    }

    public Boolean getCheckcrimdate() {
        return checkcrimdate;
    }

    public void setAtxSpp(LstSPP atxSpp) {
        this.atxSpp = atxSpp;
    }

    public LstSPP getAtxSpp() {
        return atxSpp;
    }

    public void setAtxSpc(LstSPC atxSpc) {
        this.atxSpc = atxSpc;
    }

    public LstSPC getAtxSpc() {
        return atxSpc;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSid() {
        return sid;
    }

    public void setAtxLocation(LstLocation atxLocation) {
        this.atxLocation = atxLocation;
    }

    public LstLocation getAtxLocation() {
        return atxLocation;
    }

    public void setCasetypename(String casetypename) {
        this.casetypename = casetypename;
    }

    public String getCasetypename() {
//        this.casetypename =
//                Utils.StringIsNullOrEmpty(this.getCasetype()) ? "ChÆ°a xÃ¡c Ä‘á»‹nh" : Utils.getTextFromBundle(Constants.BUNDLE_QLA,
//                        Constants.CATEGORIES.CaseType,
//                        this.getCasetype());
        return casetypename;
    }

    public void setLawcode(String lawcode) {
        this.lawcode = lawcode;
    }

    public String getLawcode() {
        return lawcode;
    }

    public void setCrimwhere_txt(String crimwhere_txt) {
        this.crimwhere_txt = crimwhere_txt;
    }

    public String getCrimwhere_txt() {
        return crimwhere_txt;
    }

    public void setLawcode_txt(String lawcode_txt) {
        this.lawcode_txt = lawcode_txt;
    }

    public String getLawcode_txt() {
        return lawcode_txt;
    }

    public void setFirstacc_txt(String firstacc_txt) {
        this.firstacc_txt = firstacc_txt;
    }

    public String getFirstacc_txt() {
        return firstacc_txt;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setUserfor(String userfor) {
        this.userfor = userfor;
    }

    public String getUserfor() {
        return userfor;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setRemark_name(String remark_name) {
        this.remark_name = remark_name;
    }

    public String getRemark_name() {
        return remark_name;
    }

    public void setSetnum_BA(String setnum_BA) {
        this.setnum_BA = setnum_BA;
    }

    public String getSetnum_BA() {
        return setnum_BA;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAccucode(String accucode) {
        this.accucode = accucode;
    }

    public String getAccucode() {
        return accucode;
    }

    public void setCday(String cday) {
        this.cday = cday;
    }

    public String getCday() {
        return cday;
    }

    public void setCmonth(String cmonth) {
        this.cmonth = cmonth;
    }

    public String getCmonth() {
        return cmonth;
    }

    public void setCyear(String cyear) {
        this.cyear = cyear;
    }

    public String getCyear() {
        return cyear;
    }

    public void setTranscode(String transcode) {
        this.transcode = transcode;
    }

    public String getTranscode() {
        return transcode;
    }

//    public void setCheckorisppid(boolean checkorisppid) {
//        this.checkorisppid = checkorisppid;
//    }
    public void setCheckorisppid(String checkorisppid) {
        this.checkorisppid = Utils.toBoolean(checkorisppid);
    }

    public boolean isCheckorisppid() {
        return checkorisppid;
    }

    public void setBegin_indatefrom(Date begin_indatefrom) {
        this.begin_indatefrom = begin_indatefrom;
    }

    public Date getBegin_indatefrom() {
        return begin_indatefrom;
    }

    public void setBegin_indateto(Date begin_indateto) {
        this.begin_indateto = begin_indateto;
    }

    public Date getBegin_indateto() {
        return begin_indateto;
    }

    public void setAtxLaw(LstLaw atxLaw) {
        this.atxLaw = atxLaw;
    }

    public LstLaw getAtxLaw() {
        return atxLaw;
    }

    public void setChecktrans(String checktrans) {
        this.checktrans = checktrans;
    }

    public String getChecktrans() {
        return checktrans;
    }

//    public void setAutolaw(boolean autolaw) {
//        this.autolaw = autolaw;
//    }
    public void setAutolaw(String autolaw) {
        this.autolaw = Utils.toBoolean(autolaw);
    }

    public boolean isAutolaw() {
        return autolaw;
    }

    public void setActdate(Date actdate) {
        this.actdate = actdate;
    }

    public Date getActdate() {
        return actdate;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRname() {
        return rname;
    }

    public void setIndate_BA(Date indate_BA) {
        this.indate_BA = indate_BA;
    }

    public Date getIndate_BA() {
        return indate_BA;
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

    public void setAtxPol(LstPolice atxPol) {
        this.atxPol = atxPol;
    }

    public LstPolice getAtxPol() {
        return atxPol;
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

//    public void setEditable(boolean editable) {
//        this.editable = editable;
//    }
    public void setEditable(String editable) {
        this.editable = Utils.toBoolean(editable);
    }

    public boolean isEditable() {
        return editable;
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

    public void setCasestatus_txt(String casestatus_txt) {
        this.casestatus_txt = casestatus_txt;
    }

    public String getCasestatus_txt() {
        return casestatus_txt;
    }

    public void setCaseisnew(String caseisnew) {
        this.caseisnew = caseisnew;
    }

    public String getCaseisnew() {
        return caseisnew;
    }

    public void setRegicode(String regicode) {
        this.regicode = regicode;
    }

    public String getRegicode() {
        return regicode;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getIndate() {
        return indate;
    }

    public void setSetnum(String setnum) {
        this.setnum = setnum;
    }

    public String getSetnum() {
        return setnum;
    }

//    public void setGhihinh(boolean ghihinh) {
//        this.ghihinh = ghihinh;
//    }
    public void setGhihinh(String ghihinh) {
        this.ghihinh = Utils.toBoolean(ghihinh);
    }

    public boolean isGhihinh() {
        return ghihinh;
    }


//    public void setDienthoai(boolean dienthoai) {
//        this.dienthoai = dienthoai;
//    }
    public void setDienthoai(String dienthoai) {
        this.dienthoai = Utils.toBoolean(dienthoai);
    }

    public boolean isDienthoai() {
        return dienthoai;
    }

//    public void setDientu(boolean dientu) {
//        this.dientu = dientu;
//    }
    public void setDientu(String dientu) {
        this.dientu = Utils.toBoolean(dientu);
    }

    public boolean isDientu() {
        return dientu;
    }

    public void setTransid(String transid) {
        this.transid = transid;
    }

    public String getTransid() {
        return transid;
    }


    public String getActualBeginOfficeId(){
        if (this.getAtxSpc() != null && this.getAtxSpc().getSpcid() != null)
            return this.getAtxSpc().getSpcid();
        if (this.getAtxSpp() != null && this.getAtxSpp().getSppid() != null)
            return this.getAtxSpp().getSpcid();
        if (this.getAtxPol() != null && this.getAtxPol().getPoliceid() != null)
            return this.getAtxPol().getPoliceid();
        if (this.getAtxArmy() != null && this.getAtxArmy().getArmyid() != null)
            return this.getAtxArmy().getArmyid();
        if (this.getAtxRanger() != null && this.getAtxRanger().getRangid() != null)
            return this.getAtxRanger().getRangid();
        if (this.getAtxCustoms() != null && this.getAtxCustoms().getCustomid() != null)
            return this.getAtxCustoms().getCustomid();
        if (this.getAtxBorderGuards() != null && this.getAtxBorderGuards().getBorguaid() != null)
            return this.getAtxBorderGuards().getBorguaid();
        return null;
    }
}
