package com.bitsco.vks.dto;

import com.bitsco.vks.entity.User;
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
public class UserSaveDTO {

    User user;

    String action;

    Date expiredate;

    String inspcode;

    String sppid;

    boolean locked;

    String departid;

    String groupid;
}
