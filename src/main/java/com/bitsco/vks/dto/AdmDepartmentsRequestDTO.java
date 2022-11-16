package com.bitsco.vks.dto;

import com.bitsco.vks.models.BaseListRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdmDepartmentsRequestDTO extends BaseListRequest {
    private String action;
    private String departid;
    private String name;
    private String atxtSpp;
    private String sppid;
    private Boolean activetha;
}
