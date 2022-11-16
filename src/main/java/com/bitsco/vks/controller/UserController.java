package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.ChangePasswordDTO;
import com.bitsco.vks.dto.UserSaveDTO;
import com.bitsco.vks.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 02/06/2022
 * Time: 1:53 PM
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/handleInsOrUpdUserOld")
    @ApiOperation(value = "InsOrUpdUserOld", response = Boolean.class)
    public ResponseEntity<?> handleInsOrUpdUserOld(@RequestBody UserSaveDTO user, HttpServletRequest httpRequest) throws Exception {
        return new ResponseEntity(userService.handleInsOrUpdUserOld(user, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/handleDeleteUserOld")
    @ApiOperation(value = "DeleteUserOld", response = Boolean.class)
    public ResponseEntity<?> handleDeleteUserOld(@RequestBody UserSaveDTO user, HttpServletRequest httpRequest) throws Exception {
        return new ResponseEntity(userService.handleDeleteUserOld(user, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/changePassword")
    @ApiOperation(value = "Change Password", response = Boolean.class)
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO request) throws Exception {
        return new ResponseEntity(userService.changePassword(request), HttpStatus.OK);
    }
}
