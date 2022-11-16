package com.bitsco.vks.entity;

import java.util.Date;

public class LstLawGroup {
    private String action;
    private String groupid;

    private String groupname;

    private String codeid;

    private String codename;

    private Date lawdate;
    private String changeid;

    private String id;
    private String fullname;

    //private List<LstCode> codes;
    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String value) {
        groupid = value;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String value) {
        groupname = value;
    }

    public String getCodeid() {
        return codeid;
    }

    public void setCodeid(String value) {
        codeid = value;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public String getCodename() {
        return codename;
    }

//    public List<LstCode> getCodes() throws Exception {
//        if (this.codes == null) {
//            LstCodeDAO _dao = new LstCodeDAO();
//            this.codes = _dao.search(0, Integer.MAX_VALUE, new LstCode());
//        }
//        return this.codes;
//    }

    public void setLawdate(Date lawdate) {
        this.lawdate = lawdate;
    }

    public Date getLawdate() {
        return lawdate;
    }

    public void setChangeid(String changeid) {
        this.changeid = changeid;
    }

    public String getChangeid() {
        return changeid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }
}
