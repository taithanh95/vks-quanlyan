package com.bitsco.vks.models;

import com.bitsco.vks.entity.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SppAccusedSaveRequest implements Serializable {
    public String action;
    public String casecode;
    public SppAccused accused;
    public LstLocation address;
    public LstLocation locaid;
    public String regicode;
    public LstSPC spc;
    public LstSPP spp;
    public LstPolice police;
    public LstArmyEntity army;
    public LstCustoms customs;
    public LstRanger ranger;
    public LstBorderGuards border;
    public LstCountryEntity country;
    public String sppid;
    public List<LstLaw> lawcode;
    public String phapnhan;
    //public String userId;
}
