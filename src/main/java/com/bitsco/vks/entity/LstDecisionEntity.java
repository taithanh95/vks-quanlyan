package com.bitsco.vks.entity;

import com.bitsco.vks.utils.Utils;

public class LstDecisionEntity {
    private String deciid;
    private String deciname;
    private String decitypeid;  // Loáº¡i Ã¡n
    private String decitypename; // tÃªn loáº¡i quyáº¿t Ä‘á»‹nh


    private String settime;
    private String setunit;
    private String setunit_; //hien thi trong datagrid & detail
    private String status;
    //private byte[] template;
    private String usefor;

    private String usefor_; //hien thi trong datagrid & detail

    private String status_; //hien thi trong datagrid & detail

    private String thoihan_tu;
    private String thoihan_den;
    //loáº¡i Ã¡n
    private String type; //dan su D, hon nhan H, hanh chinh A, kinh te K, lao dong L
    private String type_; //dan su D, hon nhan H, hanh chinh A, kinh te K, lao dong L

    private String applyfor; //bi can/vu an
    private String applyfor_dis;
    private String applyfinish;
    private String applyfinish_dis;
    private String appealtype;
    private String appealtype_dis;
    private int decilevel; // dÃ¹ng cho tree
    private String decitemp;
    private String type_ins; // kiá»ƒu thÃªm má»›i cha hay con
    private String temp;
    private String filetype;
    private boolean limittime; // quyáº¿t Ä‘á»‹nh cÃ³ thá»�i háº¡n Y, khÃ´ng cÃ³ thá»�i háº¡n N
    private String timelimit;
    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTemp() {
        return temp;
    }
    private boolean g1;
    private boolean g2;
    private boolean g3;
    private boolean g4;
    private boolean g5;
    private boolean g6;

    public String getApplyfor() {
        return applyfor;
    }

    public void setApplyfor(String applyfor) {
        this.applyfor = applyfor;
//        this.applyfor_dis =
//                Utils.getTextFromBundle(Constants.BUNDLE_QLA, Constants.CATEGORIES.Applyfor, this.applyfor);
    }

    public String getApplyfor_dis() {
        return applyfor_dis;
    }

    public String getApplyfinish() {
        return applyfinish;
    }

    public void setApplyfinish(String applyfinish) {
        this.applyfinish = applyfinish;
//        this.applyfinish_dis =
//                Utils.getTextFromBundle(Constants.BUNDLE_QLA, Constants.CATEGORIES.applyfinish, this.applyfinish);
    }

    public String getApplyfinish_dis() {
        return applyfinish_dis;
    }

    public String getAppealtype() {
        return appealtype;
    }

    public void setAppealtype(String appealtype) {
        this.appealtype = appealtype;
//        this.appealtype_dis =
//                Utils.getTextFromBundle(Constants.BUNDLE_QLA, Constants.CATEGORIES.appealtype, this.appealtype);
    }

    public String getAppealtype_dis() {
        return appealtype_dis;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
//        this.type_ = Utils.getTextFromBundle(Constants.BUNDLE_QLA, Constants.CATEGORIES.CaseType, this.type);
    }

    public String getType_() {
        return type_;
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

    public String getDeciid() {
        return deciid;
        //deciid == null ? deciid : deciid.trim();
    }

    public void setDeciid(String deciid) {
        this.deciid = deciid;
    }

    public String getDeciname() {
        return deciname == null ? deciname : deciname.trim();
    }

    public void setDeciname(String deciname) {
        this.deciname = deciname;
    }


    public String getSettime() {
        return settime;
    }

    public void setSettime(String settime) {
        this.settime = settime;
    }

    public String getSetunit() {
        return setunit;
    }

    public void setSetunit(String setunit) {
        this.setunit = setunit;
//        this.setunit_ = Utils.getTextFromBundle(Constants.BUNDLE_DM, Constants.CATEGORIES.SetUnit, this.setunit);
    }

    public String getSetunit_() {
        return setunit_;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
//        this.status_ = Utils.getTextFromBundle(Constants.BUNDLE_QLA, Constants.CATEGORIES.YesNo, this.status);
    }

    public String getStatus_() {
        return status_;
    }
    public String getUsefor() {
        return usefor;
    }

    public void setUsefor(String usefor) {
        this.usefor = usefor;
//        this.usefor_ = Utils.getTextFromBundle(Constants.BUNDLE_QLA, Constants.CATEGORIES.Usefor_deci, this.usefor);
        String u = "";
        if(this.getUsefor() != null){
            String[] arrUserfor =  this.getUsefor().split(",");
            for(int i = 0; i < arrUserfor.length;i++){

                if(arrUserfor[i].equalsIgnoreCase("G1")) {

                    u += "Kiá»ƒm sÃ¡t Ä‘iá»�u tra,";
                }
                else if(arrUserfor[i].equalsIgnoreCase("G2")) {
                    u += "Truy tá»‘,";
                }
                else if(arrUserfor[i].equalsIgnoreCase("G3")) {
                    u += "SÆ¡ tháº©m,";
                }
                else if(arrUserfor[i].equalsIgnoreCase("G4")) {
                    u += "PhÃºc tháº©m,";
                }
                else if(arrUserfor[i].equalsIgnoreCase("G5")) {
                    u+= "GiÃ¡m Ä‘á»‘c tháº©m,";
                }
                else if(arrUserfor[i].equalsIgnoreCase("G6")) { // if(arrUserfor[i].equalsIgnoreCase("G6"))
                    u += "Thi hÃ nh Ã¡n,";
                }
                if( u.length()>0){
                    this.usefor_ = u.substring(0, u.length() - 1);
                }else{
                    this.usefor_ ="";
                }
            }
        }
    }

    public String getUsefor_() {
        return usefor_;
    }

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        this.id = this.deciid;
        return id;
    }
//    public void setG1(boolean g1) {
//        this.g1 = g1;
//    }
    public void setG1(String g1) {
        this.g1 = Utils.toBoolean(g1);
    }

    public boolean isG1() {
        return g1;
    }

//    public void setG2(boolean g2) {
//        this.g2 = g2;
//    }
    public void setG2(String g2) {
        this.g2 = Utils.toBoolean(g2);
    }

    public boolean isG2() {
        return g2;
    }

//    public void setG3(boolean g3) {
//        this.g3 = g3;
//    }
    public void setG3(String g3) {
        this.g3 = Utils.toBoolean(g3);
    }

    public boolean isG3() {
        return g3;
    }

//    public void setG4(boolean g4) {
//        this.g4 = g4;
//    }
    public void setG4(String g4) {
        this.g4 = Utils.toBoolean(g4);
    }

    public boolean isG4() {
        return g4;
    }

//    public void setG5(boolean g5) {
//        this.g5 = g5;
//    }
    public void setG5(String g5) {
        this.g5 = Utils.toBoolean(g5);
    }

    public boolean isG5() {
        return g5;
    }

//    public void setG6(boolean g6) {
//        this.g6 = g6;
//    }
    public void setG6(String g6) {
        this.g6 = Utils.toBoolean(g6);
    }

    public boolean isG6() {
        return g6;
    }


    public void setDecitypeid(String decitypeid) {
        this.decitypeid = decitypeid;
    }

    public String getDecitypeid() {
        return decitypeid;
    }


    public void setDecitypename(String name) {
        this.decitypename = name;
    }

    public String getDecitypename() {
        return decitypename;
    }


    public void setDecilevel(int decilevel) {
        this.decilevel = decilevel;
    }

    public int getDecilevel() {
        return decilevel;
    }

    public void setDecitemp(String decitemp) {
        this.decitemp = decitemp;
    }

    public String getDecitemp() {
        return decitemp;
    }

    public void setType_ins(String type_ins) {
        this.type_ins = type_ins;
    }

    public String getType_ins() {
        return type_ins;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getFiletype() {
        return filetype;
    }

//    public void setLimittime(boolean limittime) {
//        this.limittime = limittime;
//    }
    public void setLimittime(String limittime) {
        this.limittime = Utils.toBoolean(limittime);
    }
    public void setTimelimit(String timelimit) {
        this.timelimit = timelimit;
    }
    public String getTimelimit() {
        return timelimit;
    }

    public boolean isLimittime() {
        return limittime;
    }
}
