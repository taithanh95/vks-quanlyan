package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.entity.AdmUsers;
import com.bitsco.vks.models.JwtRequest;
import com.bitsco.vks.models.JwtResponse;
import com.bitsco.vks.models.UpdateInfoRequest;
import com.bitsco.vks.service.UserService;
import com.bitsco.vks.service.impl.JwtUserDetailsService;
import com.bitsco.vks.utils.Md5;
import io.jsonwebtoken.ExpiredJwtException;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@CrossOrigin({"*"})
public class AuthController {
    private static final Logger LOGGER = LogManager.getLogger("DB");

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private UserService userService;

//    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
//
//        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//
//        final AdmUsers userDetails = jwtUserDetailsService.loadAdmUserByUsername(authenticationRequest.getUsername());
//        final String token = jwtToken.generateToken(userDetails);
//
//        return ResponseEntity.ok(new JwtResponse(token, userDetails.getUserid()));
//
//    }
//
    @PostMapping("/validate")
    @ApiOperation(value = "Validate token", response = Boolean.class)
    public ResponseEntity<?> validateToken(HttpServletRequest request) {

        return new ResponseEntity(true, HttpStatus.OK);
    }

    @GetMapping("/getUserLogin")
    @ApiOperation(value = "Get user login", response = List.class)
    public ResponseEntity<?> getUserLogin(HttpServletRequest httpRequest) {
        LOGGER.info("--------------------USERNAME CONTROLLER-----------------------------: " + httpRequest.getHeader(Constant.KEY.USERNAME));
        return new ResponseEntity(userService.getUserInfo(httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {

        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, Md5.encode(password)));

        } catch (DisabledException e) {

            throw new Exception("USER_DISABLED", e);

        } catch (BadCredentialsException e) {

            throw new Exception("INVALID_CREDENTIALS", e);

        }

    }

}
