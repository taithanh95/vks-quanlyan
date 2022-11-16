package com.bitsco.vks.entity;

public class LstCountryEntity {
    private String counid;
    private String counname;
    private String remark;


    public String getCounid() {
        return counid == null ? counid : counid.trim();
    }

    public void setCounid(String counid) {
        this.counid = counid;
    }

    public String getCounname() {
        return counname == null ? counname : counname.trim();
    }

    public void setCounname(String counname) {
        this.counname = counname;
    }

    public String getRemark() {
        return remark == null ? remark : remark.trim();
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {

        if (counid == null)
            return "";
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(counid);
            sb.append(" - ");
            sb.append(counname);
            if (remark != null && !remark.isEmpty()) {
                sb.append(" (");
                sb.append(remark);
                sb.append(")");
            }
            return sb.toString();
        }

    }
}
