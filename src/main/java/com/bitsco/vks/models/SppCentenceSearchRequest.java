package com.bitsco.vks.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SppCentenceSearchRequest extends BaseListRequest {
    @Getter
    @Setter
    public String regicode;
    @Getter
    @Setter
    public String userfor;
    @Getter
    @Setter
    public String sppid;
    @Getter
    @Setter
    public String casecode;
}
