package com.bitsco.vks.models;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 11/03/2022
 * Time: 3:56 PM
 */
@Data
public class RequestTransfer {
    private String regicode;
    private String centcode;
    private String sppid;
    private String status;
}
