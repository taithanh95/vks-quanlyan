package com.bitsco.vks.models;

import lombok.Data;

@Data
public class SppCenLawSearchRequest extends BaseListRequest{
    public String regicode;
    public String centcode;
    public String accucode;
    public String userfor;
}
