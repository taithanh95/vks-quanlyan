package com.bitsco.vks.models;

import lombok.Data;

@Data
public class SppCenLawSaveRequest extends BaseListRequest{
    public String regicode;
    public String centcode;
    public String lawcode;
    public String accucode;
    public String userfor;
}
