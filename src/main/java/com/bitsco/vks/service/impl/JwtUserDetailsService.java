package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.AdmUsers;
import com.bitsco.vks.repository.AdmUsersRepository;
import com.bitsco.vks.service.AuthUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Configurable
public class JwtUserDetailsService implements AuthUserDetailsService {

    @Autowired
    private AdmUsersRepository admUsersRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AdmUsers user = admUsersRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUserid(), user.getPassword(), new ArrayList<>());
    }

    public AdmUsers getUserLogin(String p_userid, String p_password)
    {
        List<AdmUsers> usersList = admUsersRepository.getUserLogin(p_userid, p_password);
        if (usersList.size() > 0)
        {
            AdmUsers users =  usersList.get(0);
            return users;
        }
        return null;
    }

    @Override
    public AdmUsers loadAdmUserByUsername(String username) throws UsernameNotFoundException {
        AdmUsers user = admUsersRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return user;
        //return new org.springframework.security.core.userdetails.User(user.getUserid(), user.getPassword(), new ArrayList<>());
    }
}
