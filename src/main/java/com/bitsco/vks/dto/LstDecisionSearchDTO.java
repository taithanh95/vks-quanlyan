package com.bitsco.vks.dto;

import java.io.Serializable;

public class LstDecisionSearchDTO implements Serializable {
    private Long ROWCOUNT;
    private Integer RNUM;
    private String DECIID;
    private String DECINAME;
    private String APPLYFOR;
    private String SETTIME;
    private String SETUNIT;
    private String STATUS;
    private String CRTDATE;
    private String CRTUSER;
    private String MDFDATE;
    private String MDFUSER;
    private String APPLYFINISH;
    private String USERFOR;
    private String DECITYPEID;
    private String DECILEVEL;
    private String TIMELIMIT;
    private String CONTENT;
    private String USEFOR;
    private String DECITYPENAME;

    private String LIMITTIME;
    private String SETUNIT_DIS;
    private String USEFOR_DIS;
    private String STATUS_DIS;
    private String APPLYFOR_DIS;
    private String APPLYFINISH_DIS;
    private String APPEALTYPE_DIS;
    
    private String plusChildren;

    public LstDecisionSearchDTO(){

    }

    public String getPlusChildren() { return plusChildren; }

    public void setPlusChildren(String plusChildren) { this.plusChildren = plusChildren; }

    public Long getROWCOUNT() {
        return ROWCOUNT;
    }

    public void setROWCOUNT(Long ROWCOUNT) {
        this.ROWCOUNT = ROWCOUNT;
    }

    public Integer getRNUM() {
        return RNUM;
    }

    public void setRNUM(Integer RNUM) {
        this.RNUM = RNUM;
    }

    public String getDECIID() {
        return DECIID;
    }

    public void setDECIID(String DECIID) {
        this.DECIID = DECIID;
    }

    public String getDECINAME() {
        return DECINAME;
    }

    public void setDECINAME(String DECINAME) {
        this.DECINAME = DECINAME;
    }

    public String getAPPLYFOR() {
        return APPLYFOR;
    }

    public void setAPPLYFOR(String APPLYFOR) {
        this.APPLYFOR = APPLYFOR;

        if("C".equalsIgnoreCase(APPLYFOR)){
            APPLYFOR = "Vụ án";
        }else if("A".equalsIgnoreCase(APPLYFOR)){
            APPLYFOR = "Bị can";
        }else if("T".equalsIgnoreCase(APPLYFOR)){
            APPLYFOR = "Tin báo";
        }else{
            APPLYFOR = "";
        }
        this.APPLYFOR_DIS = APPLYFOR;
    }

    public String getSETTIME() {
        return SETTIME;
    }

    public void setSETTIME(String SETTIME) {
        this.SETTIME = SETTIME;
    }

    public String getSETUNIT() {
        return SETUNIT;
    }

    public void setSETUNIT(String SETUNIT) {
        this.SETUNIT = SETUNIT;

        if ("D".equalsIgnoreCase(SETUNIT))
            SETUNIT = "Ngày";
        else if ("M".equalsIgnoreCase(SETUNIT))
            SETUNIT = "Tháng";
        else if ("Y".equalsIgnoreCase(SETUNIT))
            SETUNIT = "Năm";
        else SETUNIT = "";

        this.SETUNIT_DIS = SETUNIT;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;

        if("N".equalsIgnoreCase(STATUS)){
            STATUS = "Không";
        }else if("Y".equalsIgnoreCase(STATUS)){
            STATUS = "Có";
        }else{
            STATUS = "";
        }
        this.STATUS_DIS = STATUS;
    }

    public String getCRTDATE() {
        return CRTDATE;
    }

    public void setCRTDATE(String CRTDATE) {
        this.CRTDATE = CRTDATE;
    }

    public String getCRTUSER() {
        return CRTUSER;
    }

    public void setCRTUSER(String CRTUSER) {
        this.CRTUSER = CRTUSER;
    }

    public String getMDFDATE() {
        return MDFDATE;
    }

    public void setMDFDATE(String MDFDATE) {
        this.MDFDATE = MDFDATE;
    }

    public String getMDFUSER() {
        return MDFUSER;
    }

    public void setMDFUSER(String MDFUSER) {
        this.MDFUSER = MDFUSER;
    }

    public String getAPPLYFINISH() {
        return APPLYFINISH;
    }

    public void setAPPLYFINISH(String APPLYFINISH) {
        this.APPLYFINISH = APPLYFINISH;

        if("N".equalsIgnoreCase(APPLYFINISH)){
            APPLYFINISH = "Không";
        }else if("Y".equalsIgnoreCase(APPLYFINISH)){
            APPLYFINISH = "Có";
        }else{
            APPLYFINISH = "";
        }
        this.APPLYFINISH_DIS = APPLYFINISH;
    }

    public String getUSERFOR() {
        return USERFOR;
    }

    public void setUSERFOR(String USERFOR) {

        this.USERFOR = USERFOR;
    }

    public String getDECITYPEID() {
        return DECITYPEID;
    }

    public void setDECITYPEID(String DECITYPEID) {
//        if(DECITYPEID.equalsIgnoreCase("GH")){
//            DECITYPEID = "Gia hạn thời hạn chuẩn bị xét xử";
//        }else if(DECITYPEID.equalsIgnoreCase("CVA")){
//            DECITYPEID = "Chuyển vụ án";
//        }else if(DECITYPEID.equalsIgnoreCase("THS")){
//            DECITYPEID = "Trả hồ sơ";
//        }else if(DECITYPEID.equalsIgnoreCase("QDH")){
//            DECITYPEID = "Quyết định về phiên họp";
//        }else if(DECITYPEID.equalsIgnoreCase("KXD")){
//            DECITYPEID = "Không xác định";
//        }else if(DECITYPEID.equalsIgnoreCase("RG")){
//            DECITYPEID = "Rút gọn";
//        }else if(DECITYPEID.equalsIgnoreCase("01")){
//            DECITYPEID = "Kết thúc thụ lý";
//        }else if(DECITYPEID.equalsIgnoreCase("02")){
//            DECITYPEID = "Truy tố";
//        }else{
//            DECITYPEID = "";
//        }
        this.DECITYPEID = DECITYPEID;
    }

    public String getDECILEVEL() {
        return DECILEVEL;
    }

    public void setDECILEVEL(String DECILEVEL) {
        this.DECILEVEL = DECILEVEL;
    }

    public String getTIMELIMIT() {
        return TIMELIMIT;
    }

    public void setTIMELIMIT(String TIMELIMIT) {
//        if(TIMELIMIT.equalsIgnoreCase("Y")){
//            TIMELIMIT = "Quyết định có thời hạn";
//        }else if (TIMELIMIT.equalsIgnoreCase("N")){
//            TIMELIMIT = "Quyết định không có thời hạn";
//        }else{
//            TIMELIMIT= "";
//        }
        this.TIMELIMIT = TIMELIMIT;
    }

    public String getCONTENT() {
        return CONTENT;
    }

    public void setCONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
    }

    public String getUSEFOR() {
        return USEFOR;
    }

    public void setUSEFOR(String USEFOR) {
        this.USEFOR = USEFOR;
//        this.usefor_ = Utils.getTextFromBundle(Constants.BUNDLE_QLA, Constants.CATEGORIES.Usefor_deci, this.usefor);
        String u = "";
        if(this.getUSEFOR() != null){
            String[] arrUserfor =  this.getUSEFOR().split(",");
            for(int i = 0; i < arrUserfor.length;i++){

                if(arrUserfor[i].equalsIgnoreCase("G1")) {

                    u += "Kiểm sát điều tra,";
                }
                else if(arrUserfor[i].equalsIgnoreCase("G2")) {
                    u += "Truy tố,";
                }
                else if(arrUserfor[i].equalsIgnoreCase("G3")) {
                    u += "Sơ thẩm,";
                }
                else if(arrUserfor[i].equalsIgnoreCase("G4")) {
                    u += "Phúc thẩm,";
                }
                else if(arrUserfor[i].equalsIgnoreCase("G5")) {
                    u+= "Giám đốc thẩm,";
                }
                else if(arrUserfor[i].equalsIgnoreCase("G6")) { // if(arrUserfor[i].equalsIgnoreCase("G6"))
                    u += "Thi hành án,";
                }
                else if(arrUserfor[i].equalsIgnoreCase("Tbtg")) { // if(arrUserfor[i].equalsIgnoreCase("G6"))
                    u += "Tin báo tố giác,";
                }
                if( u.length()>0){
                    this.USEFOR_DIS = u.substring(0, u.length() - 1);
                }else{
                    this.USEFOR_DIS ="";
                }
            }
        }
    }

    public String getLIMITTIME() {
        return LIMITTIME;
    }

    public void setLIMITTIME(String LIMITTIME) {
        this.LIMITTIME = LIMITTIME;
    }

    public String getDECITYPENAME() {
        return DECITYPENAME;
    }

    public void setDECITYPENAME(String DECITYPENAME) {
        this.DECITYPENAME = DECITYPENAME;
    }

    public String getSETUNIT_DIS() {
        return SETUNIT_DIS;
    }

    public void setSETUNIT_DIS(String SETUNIT_DIS) {
        this.SETUNIT_DIS = SETUNIT_DIS;
    }

    public String getUSEFOR_DIS() {
        return USEFOR_DIS;
    }

    public void setUSEFOR_DIS(String USEFOR_DIS) {
        this.USEFOR_DIS = USEFOR_DIS;
    }

    public String getSTATUS_DIS() {
        return STATUS_DIS;
    }

    public void setSTATUS_DIS(String STATUS_DIS) {
        this.STATUS_DIS = STATUS_DIS;
    }

    public String getAPPLYFOR_DIS() {
        return APPLYFOR_DIS;
    }

    public void setAPPLYFOR_DIS(String APPLYFOR_DIS) {
        this.APPLYFOR_DIS = APPLYFOR_DIS;
    }

    public String getAPPLYFINISH_DIS() {
        return APPLYFINISH_DIS;
    }

    public void setAPPLYFINISH_DIS(String APPLYFINISH_DIS) {
        this.APPLYFINISH_DIS = APPLYFINISH_DIS;
    }

    public String getAPPEALTYPE_DIS() {
        return APPEALTYPE_DIS;
    }

    public void setAPPEALTYPE_DIS(String APPEALTYPE_DIS) {
        this.APPEALTYPE_DIS = APPEALTYPE_DIS;
    }
}
