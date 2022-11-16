package com.bitsco.vks.dto;

import com.bitsco.vks.models.BaseListRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdmGroupsRequestDTO extends BaseListRequest {

    private String groupid;

    private String groupname;

    private String sppid;

    private String action;
}
