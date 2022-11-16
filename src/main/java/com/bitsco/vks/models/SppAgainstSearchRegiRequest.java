package com.bitsco.vks.models;

import lombok.Data;

@Data
public class SppAgainstSearchRegiRequest extends BaseListRequest {
    public String regicode;
    public String userfor;
    public String sppid;
}
