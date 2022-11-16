package com.bitsco.vks.service;

import com.bitsco.vks.dto.ChangePasswordDTO;
import com.bitsco.vks.dto.UserSaveDTO;
import com.bitsco.vks.entity.AdmUsers;
import com.bitsco.vks.models.SppCaseInsertRequest;

import java.util.List;

public interface UserService {
    List<AdmUsers> getUserLogin(String userId, String password);
    List<AdmUsers> getUserInfo(String userId);

    String handleInsOrUpdUserOld(UserSaveDTO user, String username) throws Exception;

    String handleDeleteUserOld(UserSaveDTO user, String username) throws Exception;

    String changePassword(ChangePasswordDTO req) throws Exception;
}
