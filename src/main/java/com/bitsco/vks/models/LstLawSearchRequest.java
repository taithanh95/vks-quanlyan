package com.bitsco.vks.models;

import com.bitsco.vks.entity.LstLaw;
import lombok.Data;

@Data
public class LstLawSearchRequest extends BaseListRequest {
    public LstLaw law;
    public String regicode;
    public String centcode;
    public String accucode;
    public String userfor;
    public int pageindex;
    public int pagesize;
}
