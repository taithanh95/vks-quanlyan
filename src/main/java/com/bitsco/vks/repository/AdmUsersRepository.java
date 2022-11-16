package com.bitsco.vks.repository;

import com.bitsco.vks.dto.ChangePasswordDTO;
import com.bitsco.vks.dto.UserSaveDTO;
import com.bitsco.vks.entity.AdmUsers;
import com.bitsco.vks.entity.LstInspector;

import java.util.List;


public interface AdmUsersRepository {
    List<AdmUsers> getUserLogin(String p_userid, String p_password);
    List<AdmUsers> getUserInfo(String p_userid);
    AdmUsers findByUsername(String username);

    List<LstInspector> getLstInspectors(String sppid);

    String insOrUpd(UserSaveDTO req, String username);

    String delete(UserSaveDTO req, String username);

    String changePassword(ChangePasswordDTO req);
}
