package com.bitsco.vks.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdmFunctionsResponseDTO {
    private String funcid;
    private String funcname;
    private String path;
    private String parentid;
    private String module;
    private String groupid;
    private String userid;
    private String groupname;
    private String menuorder;
    private String submenu;
}
