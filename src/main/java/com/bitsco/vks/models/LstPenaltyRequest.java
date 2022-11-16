package com.bitsco.vks.models;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 17/05/2022
 * Time: 9:58 AM
 */
@Data
public class LstPenaltyRequest implements Serializable {
    private String sortField;
    private String sortOrder;
    private String penaltyid;
    private String penaltyname;
    private String penaltyfor;
}
