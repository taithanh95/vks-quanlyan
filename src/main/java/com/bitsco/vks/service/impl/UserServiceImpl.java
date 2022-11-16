package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.ChangePasswordDTO;
import com.bitsco.vks.dto.UserSaveDTO;
import com.bitsco.vks.entity.AdmUsers;
import com.bitsco.vks.repository.AdmUsersRepository;
import com.bitsco.vks.service.UserService;
import com.bitsco.vks.utils.StringCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AdmUsersRepository admUsersRepository;

    @Override
    public List<AdmUsers> getUserLogin(String userId, String password) {
        return  admUsersRepository.getUserLogin(userId, password);
    }

    @Override
    public List<AdmUsers> getUserInfo(String userId) {
        return  admUsersRepository.getUserInfo(userId);
    }

    @Override
    public String handleInsOrUpdUserOld(UserSaveDTO user, String username) throws Exception {
        try {
            String _res = admUsersRepository.insOrUpd(user, username);
            if (StringCommon.isNullOrBlank(_res)) return null;
            if ("adm_Users.messages.accountExist".equalsIgnoreCase(_res))
                throw new Exception("Tài khoản đã tồn tại trong CSDL");
            if ("adm_Users.messages.canNotEdit".equalsIgnoreCase(_res))
                throw new Exception("Bạn không được phép cập nhật ngày hết hạn, tình trạng khóa hoặc thay đổi VKS của tài khoản này.");
            if ("adm_Users.messages.valueTooLarge".equalsIgnoreCase(_res))
                throw new Exception("Giá trị nhập vào có độ dài quá lớn. Bạn hãy kiểm tra lại.");
        } catch (Exception e) {
            throw (e);
        }
        return null;
    }

    @Override
    public String handleDeleteUserOld(UserSaveDTO user, String username) throws Exception {
        try {
            String _res = admUsersRepository.delete(user, username);
            if (!StringCommon.isNullOrBlank(_res)) return null;
            if ("adm_Users.messages.canNotDelete".equalsIgnoreCase(_res))
                throw new Exception("Không thể xóa (những) tài khoản này (admin, danhmuc, fpt).");
        }catch (Exception e) {
            throw (e);
        }
        return null;
    }

    @Override
    public String changePassword(ChangePasswordDTO req) throws Exception {
        try {
            String _res = admUsersRepository.changePassword(req);
            if (!StringCommon.isNullOrBlank(_res)) return null;
            if ("adm_Users.messages.wrongPassword".equalsIgnoreCase(_res))
                throw new Exception("Mật khẩu cũ không chính xác.");
        }catch (Exception e) {
            throw (e);
        }
        return null;
    }
}
