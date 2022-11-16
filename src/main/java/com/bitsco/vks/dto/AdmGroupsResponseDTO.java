package com.bitsco.vks.dto;

import com.bitsco.vks.models.BaseListRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdmGroupsResponseDTO extends BaseListRequest {

    private String groupid;

    private String groupname;

    private String sppid;

    private String sppname;

    private String userid;
}
