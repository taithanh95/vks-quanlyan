package com.bitsco.vks.repository;

import com.bitsco.vks.dto.AdmFunctionsResponseDTO;
import com.bitsco.vks.dto.AdmGroupsResponseDTO;
import com.bitsco.vks.entity.AdmFunctions;

import java.util.List;

public interface MenuReporsitory {
    List<AdmFunctionsResponseDTO> getFunctionsTreeForGroup(String module, String groupid);

    List<AdmFunctionsResponseDTO> getFunctionsTreeForUser(String userid, String module);

    String grantFunctionsToGroup(String groupid, String module, List<AdmFunctions> lstNodes, String username);

    String grantFunctionsToUser(String userid, String module, List<AdmFunctions> lstNodes, String username);

    String grantGroupsToUser(String userid, List<String> lstGroups, String username);

    List<AdmFunctionsResponseDTO> getLstGroupSpp(String scppid, String sppid);

    List<AdmGroupsResponseDTO> getGroups(String userid, String sppid);

    List<AdmFunctionsResponseDTO> getMenuByModule(String username, String module);
}
