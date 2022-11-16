package com.bitsco.vks.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetSppRegisterRequest  implements Serializable {
    public String casecode;
    public String usefor;
    public String csppid;
}
