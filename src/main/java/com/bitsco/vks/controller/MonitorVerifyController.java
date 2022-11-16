package com.bitsco.vks.controller;

import com.bitsco.vks.models.MonitorRequest;
import com.bitsco.vks.service.MonitorVerifyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/monitorVerify")
public class MonitorVerifyController {
    @Autowired
    MonitorVerifyService monitorVerifyService;
    @PostMapping("/list")
    @ApiOperation(value = "Monitor verify ", response = String.class)
    public ResponseEntity<?> monitorVerifyList(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorVerifyService.getList(monitorRequest), HttpStatus.OK);
    }

}
