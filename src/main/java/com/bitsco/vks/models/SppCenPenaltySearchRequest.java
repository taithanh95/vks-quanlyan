package com.bitsco.vks.models;

import lombok.Data;

@Data
public class SppCenPenaltySearchRequest extends BaseListRequest{
    public String centcode;
    public String lawcode;
    public String accucode;
    public boolean isCheckspppenal;
}
