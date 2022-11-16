package com.bitsco.vks.controller;

import com.bitsco.vks.service.AdmUsersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/dm/AdmUsers")
public class AdmUsersController {

    @Autowired
    AdmUsersService admUsersService;

    @GetMapping("/getLstInspector")
    @ApiOperation(value = "get list inspector", response = List.class)
    private ResponseEntity<?> getLstInspector(@RequestParam String sppid) {
        return new ResponseEntity<>(admUsersService.getLstInspectors(sppid), HttpStatus.OK);
    }

}
