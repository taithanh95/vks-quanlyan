package com.bitsco.vks.entity;

import com.bitsco.vks.utils.Utils;

import java.util.Date;
import java.util.List;

public class LstInspector {
    private String inspcode;
    private String sppid;
    private String depart;
    private String name;
    private String departname;
    private String fullname;
    private String address;
    private String tel;
    private String jobtitle;
    private String status;
    private String position;
    private String stt;
    private String changeid;
    private String jobname;
    private String regicode;
    private String position_;
    private String position_name;
    private String position_type;
    private String setnum_regi;
    private String assignins;
    private String setnum_regins;
    private Date assigndate_regins;
    private boolean ks;
    private boolean dt;
    private boolean ld;
    private boolean kh;
    private Date finishdate;


    private List<LstSPP> spp;

    public LstInspector() {
        super();
    }

    public void setInspcode(String inspcode) {
        this.inspcode = inspcode;
    }

    public String getInspcode() {
        return inspcode;
    }

    public void setSppid(String sppid) {
        this.sppid = sppid;
    }

    public String getSppid() {
        return sppid;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setStatus(String status) {
        this.status = status;
        //this.stt = Utils.getTextFromBundle(null, Constants.CATEGORIES.Status_Acc, this.status);
    }

    public String getStatus() {
        return status;
    }

    public void setChangeid(String changeid) {
        this.changeid = changeid;
    }

    public String getChangeid() {
        return changeid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

//    public String getStt() {
//        return stt = Utils.getTextFromBundle(null, Constants.CATEGORIES.Status_Acc, this.status);
//    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getJobname() {
        return jobname;
    }

    public void setPosition(String position) {
        this.position = position;
        String u = "";
        if(this.getPosition() != null){
            String [] arr = this.getPosition().split(",");
            for(int i=0; i < arr.length; i++){
                if(arr[i].equalsIgnoreCase("KH")){
                    u += "KhÃ¡c, ";
                }
                if(arr[i].equalsIgnoreCase("KS")){
                    u += "Kiá»ƒm sÃ¡t viÃªn, ";
                }
                if(arr[i].equalsIgnoreCase("DT")){
                    u += "Ä�iá»�u tra viÃªn, ";
                }
                if(arr[i].equalsIgnoreCase("LD")){
                    u += "LÃ£nh Ä‘áº¡o, ";
                }
                if(u.length() > 0){
                    this.position_ = u.substring(0, u.length() -2);
                    //      this.position_ = u.substring(u.length() -1, u.length());
                }
                else
                    this.position_ = "";
            }
//            for(int i= arr.length - 1; i<= arr.length; i++){
//                if(arr[i].equalsIgnoreCase(",")){
//                    arr[i].replace(',', ' ');
//                    }
//                }
        }
    }

    public String getPosition() {
        return position;
    }

    public String getPosition_() {
        return position_;
    }

//    public void setKs(boolean ks) {
//        this.ks = ks;
//    }
    public void setKs(String ks) {
        this.ks = Utils.toBoolean(ks);
    }

    public boolean isKs() {
        return ks;
    }

//    public void setDt(boolean dt) {
//        this.dt = dt;
//    }
    public void setDt(String dt) {
        this.dt = Utils.toBoolean(dt);
    }

    public boolean isDt() {
        return dt;
    }

//    public void setLd(boolean ld) {
//        this.ld = ld;
//    }
public void setLd(String ld) {
        this.ld = Utils.toBoolean(ld);
    }

    public boolean isLd() {
        return ld;
    }

//    public void setKh(boolean kh) {
//        this.kh = kh;
//    }
public void setKh(String kh) {
        this.kh = Utils.toBoolean(kh);
    }

    public boolean isKh() {
        return kh;
    }

    public void setRegicode(String regicode) {
        this.regicode = regicode;
    }

    public String getRegicode() {
        return regicode;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public String getPosition_name() {
        if(position_name != null)
            if(position_name.equals("KS")){
                this.setPosition_type("KS");
                this.setPosition_name("Kiá»ƒm sÃ¡t viÃªn");
            } else if(position_name.equals("DT")){
                this.setPosition_type("DT");
                this.setPosition_name("Ä�iá»�u tra viÃªn");
            } else if(position_name.equals("PC")){
                this.setPosition_type("PC");
                this.setPosition_name("KSV Ä‘Æ°á»£c phÃ¢n cÃ´ng");
            } else if(position_name.equals("TG")){
                this.setPosition_type("TG");
                this.setPosition_name("KSV tham gia phiÃªn tÃ²a");
            }
        return position_name;
    }

    public void setSetnum_regi(String setnum_regi) {
        this.setnum_regi = setnum_regi;
    }

    public String getSetnum_regi() {
        return setnum_regi;
    }

    public void setAssignins(String assignins) {
        this.assignins = assignins;
    }

    public String getAssignins() {
        return assignins;
    }

    public void setSetnum_regins(String setnum_regins) {
        this.setnum_regins = setnum_regins;
    }

    public String getSetnum_regins() {
        return setnum_regins;
    }

    public void setAssigndate_regins(Date assigndate_regins) {
        this.assigndate_regins = assigndate_regins;
    }

    public Date getAssigndate_regins() {
        return assigndate_regins;
    }

    public void setPosition_type(String position_type) {
        this.position_type = position_type;
    }

    public String getPosition_type() {
        return position_type;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    public String getDepartname() {
        return departname;
    }

    public void setFinishdate(Date finishdate) {
        this.finishdate = finishdate;
    }

    public Date getFinishdate() {
        return finishdate;
    }
}
