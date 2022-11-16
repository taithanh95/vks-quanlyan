package com.bitsco.vks.service;

import com.bitsco.vks.dto.AdmFunctionsRequestDTO;
import com.bitsco.vks.dto.AdmFunctionsResponseDTO;
import com.bitsco.vks.dto.AdmGroupsResponseDTO;

import java.util.List;

public interface MenuService {
    List<AdmFunctionsResponseDTO> getFunctionsTreeForGroup(String module, String groupid);
    String grantFunctionsToGroup(AdmFunctionsRequestDTO req, String username);

    List<AdmFunctionsResponseDTO> getFunctionsTreeForUser(String userid, String module);
    String grantFunctionsToUser(AdmFunctionsRequestDTO req, String username);

    List<AdmFunctionsResponseDTO> getLstGroupSpp(String csppid, String sppid);

    List<AdmGroupsResponseDTO> getGroups(String userid, String sppid);
    String grantGroupsToUser(String userid, List<String> lstGroups, String username);

    List<AdmFunctionsResponseDTO> getMenuByModule(String module, String username);

}
