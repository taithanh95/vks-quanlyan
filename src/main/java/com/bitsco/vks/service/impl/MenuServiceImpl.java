package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.AdmFunctionsRequestDTO;
import com.bitsco.vks.dto.AdmFunctionsResponseDTO;
import com.bitsco.vks.dto.AdmGroupsResponseDTO;
import com.bitsco.vks.repository.MenuReporsitory;
import com.bitsco.vks.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuReporsitory menuReporsitory;

    @Override
    public List<AdmFunctionsResponseDTO> getFunctionsTreeForGroup(String module, String groupid) {
        return menuReporsitory.getFunctionsTreeForGroup(module,groupid);
    }

    @Override
    public String grantFunctionsToGroup(AdmFunctionsRequestDTO req, String username) {
        return menuReporsitory.grantFunctionsToGroup(req.getGroupid(), req.getModule(), req.getLstFunc(), username);
    }

    @Override
    public List<AdmFunctionsResponseDTO> getFunctionsTreeForUser(String userid, String module) {
        return menuReporsitory.getFunctionsTreeForUser(userid, module);
    }

    @Override
    public String grantFunctionsToUser(AdmFunctionsRequestDTO req, String username) {
        return menuReporsitory.grantFunctionsToUser(req.getUserid(), req.getModule(), req.getLstFunc(), username);
    }

    @Override
    public List<AdmFunctionsResponseDTO> getLstGroupSpp(String csppid, String sppid) {
        return menuReporsitory.getLstGroupSpp(csppid, sppid);
    }

    @Override
    public List<AdmGroupsResponseDTO> getGroups(String userid, String sppid) {
        return menuReporsitory.getGroups(userid, sppid);
    }

    @Override
    public String grantGroupsToUser(String userid, List<String> lstGroups, String username) {
        return menuReporsitory.grantGroupsToUser(userid, lstGroups, username);
    }

    @Override
    public List<AdmFunctionsResponseDTO> getMenuByModule(String module, String username) {
        return menuReporsitory.getMenuByModule(username,module);
    }
}
