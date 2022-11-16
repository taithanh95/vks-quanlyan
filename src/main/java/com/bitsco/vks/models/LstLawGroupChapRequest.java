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
public class LstLawGroupChapRequest implements Serializable {
    private String sortField;
    private String sortOrder;
    private String id;
    private String groupid;
    private String fullname;
    private String groupname;
}
