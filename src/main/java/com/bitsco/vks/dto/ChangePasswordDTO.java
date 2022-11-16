package com.bitsco.vks.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 15/08/2022
 * Time: 10:26 AM
 */
@NoArgsConstructor
@Data
public class ChangePasswordDTO {

    String userid;

    String passwordOld;

    String passwordNew;
}
