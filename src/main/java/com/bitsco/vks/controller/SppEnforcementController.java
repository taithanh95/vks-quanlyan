package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.models.SppEnforceDeleteRequest;
import com.bitsco.vks.models.SppEnforceSaveRequest;
import com.bitsco.vks.service.SppEnforcementService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping(value="/SppEnforcement")
public class SppEnforcementController {

    @Autowired
    private SppEnforcementService sppEnforcementService;

    public SppEnforcementController(){ }

    @PostMapping("/update")
    @ApiOperation(value = "Handle update enforce", response = String.class)
    public ResponseEntity<?> getListUpdateInfo(@Valid @RequestBody SppEnforceSaveRequest request, HttpServletRequest http) {
        return new ResponseEntity(sppEnforcementService.save(request,http.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value="Handle delete enforce", response = String.class)
    public ResponseEntity<?> deleteEnforce(@Valid @RequestBody SppEnforceDeleteRequest request){
        return new ResponseEntity(sppEnforcementService.delete(request),HttpStatus.OK);
    }
}
