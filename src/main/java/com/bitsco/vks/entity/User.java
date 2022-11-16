package com.bitsco.vks.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 02/06/2022
 * Time: 1:12 PM
 */
@NoArgsConstructor
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
    private Long groupUserId;
    private Integer type;
    private Integer emailVerified;
    private String imageUrl;
    private Date expiredate;
    private String inspcode;
    private String sppid;
    private String departid;
    private String groupid;
}
