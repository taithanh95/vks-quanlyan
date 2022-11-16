package com.bitsco.vks.models;

import lombok.Data;

@Data
public class SppCenPenalTotalSaveRequest extends BaseListRequest{
    public String centcode;
    public String regicode;
    public String accucode;
    public boolean isCheckspppenal;
}
