package com.bitsco.vks.dto;

import com.bitsco.vks.entity.AdmFunctions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdmFunctionsRequestDTO {
    private String sppid;
    private String userid;
    private String groupid;
    private String module;
    private List<AdmFunctions> lstFunc;
    private List<String> lstGroups;
}
