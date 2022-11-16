package com.bitsco.vks.dto;

import com.bitsco.vks.entity.SppAgainst;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 15/02/2022
 * Time: 8:37 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SppAgainstDTO extends SppAgainst {
    private String arragainstid;
    private String arragainstname;
    private String regisuserfor;
}
