package com.bitsco.vks.models;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 11/05/2022
 * Time: 4:06 PM
 */
@Data
public class LstCodeRequest implements Serializable {
    private String sortField;
    private String sortOrder;
    private String codeid;
    private String codename;
}
