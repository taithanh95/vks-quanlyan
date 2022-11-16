package com.bitsco.vks.models;

import com.bitsco.vks.entity.LstLaw;
import lombok.Data;

@Data
public class SppCentenLawSearchRequest extends BaseListRequest{
    public LstLaw law;
    public String centcode;
    public int pageindex;
    public int pagesize;
}
