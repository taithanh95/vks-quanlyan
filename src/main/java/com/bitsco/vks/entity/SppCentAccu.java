package com.bitsco.vks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SppCentAccu implements Serializable {
    public String centcode;
    public String regicode;
    public String accucode;
    public boolean presence;
    public Date actdate;
    public String concid;
    public String concidspp;
    public Date crtdate;
    public String crtuser;
    public Date mdfdate;
    public String mdfuser;
    public Date last_time;
    public String userfor;
    public Date indate;
}
