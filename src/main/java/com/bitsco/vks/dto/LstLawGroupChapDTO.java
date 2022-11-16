package com.bitsco.vks.dto;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 12/05/2022
 * Time: 9:20 AM
 */
@Data
public class LstLawGroupChapDTO {
    private Long ROWCOUNT;
    private Integer RNUM;
    private String ID;
    private String GROUPID;
    private String GROUPNAME;
    private String FULLNAME;
    private String CRTDATE;
    private String CRTUSER;
    private String MDFDATE;
    private String MDFUSER;
}
