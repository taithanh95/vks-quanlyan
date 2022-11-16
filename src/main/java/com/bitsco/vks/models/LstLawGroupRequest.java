package com.bitsco.vks.models;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 12/05/2022
 * Time: 9:22 AM
 */
@Data
public class LstLawGroupRequest implements Serializable {
    private String sortField;
    private String sortOrder;
    private String groupid;
    private String groupname;
    private String codeid;
}
