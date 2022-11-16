package com.bitsco.vks.entity;

import java.util.Date;

public class SppPropoAssignEntity {
    public SppPropoAssignEntity() {
        super();
    }

    private String regicode;
    private String inspcode;
    private String assignins;
    private Date assigndate;
    private Date acceptdate;
    private Date begindate;
    private Date enddate;
    private String setnum;
    private Date indate;
    private String usefor;
    private String fullname ; // tÃªn TTV
    private String fullname_npc; // tÃªn ngÆ°á»�i phÃ¢n cÃ´ng
    private String position_type = null;
    private String position_ksv;
    protected LstInspector atxtIns;
    protected LstInspector atxtAssignIns;
    private Date finishdate;

    public void setInspcode(String inspcode) {
        this.inspcode = inspcode;
    }

    public String getInspcode() {
        return inspcode;
    }

    public void setAssignins(String assignins) {
        this.assignins = assignins;
    }

    public String getAssignins() {
        return assignins;
    }

    public void setAssigndate(Date assigndate) {
        this.assigndate = assigndate;
    }

    public Date getAssigndate() {
        return assigndate;
    }

    public void setAcceptdate(Date acceptdate) {
        this.acceptdate = acceptdate;
    }

    public Date getAcceptdate() {
        return acceptdate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Date getEnddate() {
        return enddate;
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

    public void setUsefor(String usefor) {
        this.usefor = usefor;
    }

    public String getUsefor() {
        return usefor;
    }


    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setAtxtIns(LstInspector atxtIns) {
        this.atxtIns = atxtIns;
    }

    public LstInspector getAtxtIns() {
        return atxtIns;
    }

    public void setAtxtAssignIns(LstInspector atxtAssignIns) {
        this.atxtAssignIns = atxtAssignIns;
    }

    public LstInspector getAtxtAssignIns() {
        return atxtAssignIns;
    }

    public void setFullname_npc(String fullname_npc) {
        this.fullname_npc = fullname_npc;
    }

    public String getFullname_npc() {
        return fullname_npc;
    }

    public void setPosition_type(String position_type) {
        this.position_type = position_type;
    }

    public String getPosition_type() {
        return position_type;
    }

    public void setRegicode(String regicode) {
        this.regicode = regicode;
    }

    public String getRegicode() {
        return regicode;
    }

    public void setFinishdate(Date finishdate) {
        this.finishdate = finishdate;
    }

    public Date getFinishdate() {
        return finishdate;
    }

    public void setPosition_ksv(String position_ksv) {
        this.position_ksv = position_ksv;
    }

    public String getPosition_ksv() {
        return position_ksv;
    }
}
