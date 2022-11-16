package com.bitsco.vks.entity;

import java.util.Date;

public class SppInvestment {
    public SppInvestment(){super();}
    private String invecode;
    private String invetype;
    private boolean has_inspector;
    private String reason;
    private Date invedate;
    private String invetype_name;
    private String investor;
    private String inspcode;
    private String insp_fullname;
    private String identify;
    private String content_results;
    private String remark;
    private String casecode;
    private Date crtdate;

    public Date getCrtdate() {return crtdate;}

    public void setCrtdate(Date crtdate) {this.crtdate = crtdate;}

    public String getInsp_fullname() {return insp_fullname;}

    public void setInsp_fullname(String insp_fullname) {this.insp_fullname = insp_fullname;}

    public String getInvecode() {return invecode;}

    public void setInvecode(String invecode) {this.invecode = invecode;}

    public String getInvetype() {return invetype;}

    public void setInvetype(String invetype) {this.invetype = invetype;}

    public boolean isHas_inspector() {return has_inspector;}

    public void setHas_inspector(boolean has_inspector) {this.has_inspector = has_inspector;}

    public String getReason() {return reason;}

    public void setReason(String reason) {this.reason = reason;}

    public Date getInvedate() {return invedate;}

    public void setInvedate(Date invedate) {this.invedate = invedate;}

    public String getInvetype_name() {return invetype_name;}

    public void setInvetype_name(String invetype_name) {this.invetype_name = invetype_name;}

    public String getInvestor() {return investor;}

    public void setInvestor(String investor) {this.investor = investor;}

    public String getInspcode() {return inspcode;}

    public void setInspcode(String inspcode) {this.inspcode = inspcode;}

    public String getIdentify() {return identify;}

    public void setIdentify(String identify) {this.identify = identify;}

    public String getContent_results() {return content_results;}

    public void setContent_results(String content_results) {this.content_results = content_results;}

    public String getRemark() {return remark;}

    public void setRemark(String remark) {this.remark = remark;}

    public String getCasecode() {return casecode;}

    public void setCasecode(String casecode) {this.casecode = casecode;}
}
