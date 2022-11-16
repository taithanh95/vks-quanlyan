package com.bitsco.vks.config;

import com.bitsco.vks.entity.AdmUsers;
import com.bitsco.vks.repository.AdmUsersRepository;
import com.bitsco.vks.service.UserService;
import com.bitsco.vks.service.impl.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
@Configurable
public class CustomAuthenticationProvider implements AuthenticationProvider, Serializable {
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;
    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String name = authentication.getName();
        // You can get the password here
        String password = authentication.getCredentials().toString();
        List<AdmUsers> lstUsers = userService.getUserLogin(name, password);

        /*if (users == null || !users.getUserid().equalsIgnoreCase(name)) {
            throw new BadCredentialsException("Username not found.");
        }*/

        if (lstUsers != null)
        {
            AdmUsers users = lstUsers.get(0);
            Authentication auth = new UsernamePasswordAuthenticationToken(users.getUserid(),  users.getPassword());
            return auth;
        }

        return null;
    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
