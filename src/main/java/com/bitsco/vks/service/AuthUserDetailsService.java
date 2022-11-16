package com.bitsco.vks.service;

import com.bitsco.vks.entity.AdmUsers;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthUserDetailsService extends UserDetailsService {
    AdmUsers loadAdmUserByUsername(String var1) throws UsernameNotFoundException;
}
