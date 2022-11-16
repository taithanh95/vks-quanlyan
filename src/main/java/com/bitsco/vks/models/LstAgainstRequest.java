package com.bitsco.vks.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class LstAgainstRequest implements Serializable {
    private String action;

    private String sortField;
    private String sortOrder;

    private String againstid;
    private String againstname;

    /**
     * Value
     * isEmpty: Vụ án - Bị can
     * C : Vụ án
     * A : bị can
     */
    private String applyfor;

    private int settime;
    private String setunit;

    private String thoihan_tu;
    private String thoihan_den;
}
