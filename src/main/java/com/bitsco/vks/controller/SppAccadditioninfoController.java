package com.bitsco.vks.controller;

import com.bitsco.vks.service.SppAccadditioninfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/SppAccadditioninfo")
public class SppAccadditioninfoController {
    @Autowired
    private SppAccadditioninfoService sppAccadditioninfoService;

    @GetMapping("/getSppAccadditioninfoByAcuucode")
    @ApiOperation(value = "Get SppAccaddition", response = Object.class)
    public ResponseEntity<?> getSppAccadditioninfoByAcuucode(String accucode) {
        return new ResponseEntity<>(sppAccadditioninfoService.getByAccucode(accucode), HttpStatus.OK);
    }
}
