package com.bitsco.vks.models;

import lombok.Data;

@Data
public class SppCentenLawSaveRequest extends BaseListRequest{
    public String action;
    public String centcode;
    public String lawcode;
}
