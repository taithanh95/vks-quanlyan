package com.bitsco.vks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 27/04/2022
 * Time: 10:31 AM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LstParty {
    private String partyid;
    private String partyname;
    private String setlevel;
    private String setcommittee;
    private String remark;
    private String action;
}
