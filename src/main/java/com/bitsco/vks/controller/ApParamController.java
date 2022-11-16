package com.bitsco.vks.controller;

import com.bitsco.vks.dto.ApParamDTO;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.service.ApPramService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/dm/ApParam")
public class ApParamController {

    private final ApPramService apPramService;

    @Autowired
    public ApParamController(ApPramService apPramService) {
        this.apPramService = apPramService;
    }

    @GetMapping("/getParams")
    @ApiOperation(value = "Get params", response = List.class)
    public ResponseEntity<Object> getParams(@RequestParam String code) {
        List<ApParamDTO> lstApPram = apPramService.findApParamsByParamCodeAndStatus(code);
        return new ResponseEntity<>(lstApPram, HttpStatus.OK);
    }
}
