package com.bitsco.vks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SppJoinSaveRequest implements Serializable {
    private String casecode;
    private List<String> lstCase;
    private String sppid;
    private String action;
}
