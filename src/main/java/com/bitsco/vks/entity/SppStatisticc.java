package com.bitsco.vks.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 25/07/2022
 * Time: 2:03 PM
 */
@Data
@NoArgsConstructor
public class SppStatisticc {
    private String centcode;
    private String regicode;
    private String lawcode;
    private String lawname;
    private String amount;
    private String statid;
    private String statname;
}
