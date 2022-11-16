package com.bitsco.vks.models;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 17/05/2022
 * Time: 1:36 PM
 */
@Data
public class LstLawPenaltyRequest {
    private String sortField;
    private String sortOrder;
    private String lawid;
    private String item;
    private String point;
    private String lawname;
    private String codeid;
    private String groupid;
}
