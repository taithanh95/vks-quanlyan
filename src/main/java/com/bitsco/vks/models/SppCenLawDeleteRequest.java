package com.bitsco.vks.models;

import lombok.Data;

@Data
public class SppCenLawDeleteRequest extends BaseListRequest{
    public String centcode;
    public String lawcode;
    public String accucode;
}
