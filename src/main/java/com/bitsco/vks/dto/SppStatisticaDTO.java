package com.bitsco.vks.dto;

import java.util.Date;

public class SppStatisticaDTO {
    private String statid;
    private String statname;
    private String status;
    private String accucode;
    private String centcode;
    private String regicode;
    private String lawcode;
    private Date crtdate;
    private Date crtuser;

    public String getStatid() {return statid;}

    public void setStatid(String statid) {this.statid = statid;}

    public String getStatname() {return statname;}

    public void setStatname(String statname) {this.statname = statname;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    public String getAccucode() {return accucode;}

    public void setAccucode(String accucode) {this.accucode = accucode;}

    public String getCentcode() {return centcode;}

    public void setCentcode(String centcode) {this.centcode = centcode;}

    public String getRegicode() {return regicode;}

    public void setRegicode(String regicode) {this.regicode = regicode;}

    public String getLawcode() {return lawcode;}

    public void setLawcode(String lawcode) {this.lawcode = lawcode;}

    public Date getCrtdate() {return crtdate;}

    public void setCrtdate(Date crtdate) {this.crtdate = crtdate;}

    public Date getCrtuser() {return crtuser;}

    public void setCrtuser(Date crtuser) {this.crtuser = crtuser;}
}
