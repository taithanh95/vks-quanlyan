package com.bitsco.vks.controller;

import com.bitsco.vks.models.MonitorRequest;
import com.bitsco.vks.service.MonitorDecisonService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 21/07/2022
 * Time: 10:44 AM
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/monitorDecison")
public class MonitorDecisonController {

    @Autowired
    MonitorDecisonService monitorDecisonService;

    @PostMapping("/monitorDecison1")
    @ApiOperation(value = "Monitor Decison 1", response = String.class)
    public ResponseEntity<?> monitorDecison1(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorDecisonService.monitorDecison1(monitorRequest), HttpStatus.OK);
    }

    @PostMapping("/monitorDecison2")
    @ApiOperation(value = "Monitor Decison 2", response = String.class)
    public ResponseEntity<?> monitorDecison2(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorDecisonService.monitorDecison2(monitorRequest), HttpStatus.OK);
    }

    @PostMapping("/monitorDecison3")
    @ApiOperation(value = "Monitor Decison 3", response = String.class)
    public ResponseEntity<?> monitorDecison3(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorDecisonService.monitorDecison3(monitorRequest), HttpStatus.OK);
    }

    @PostMapping("/monitorDecison4")
    @ApiOperation(value = "Monitor Decison 4", response = String.class)
    public ResponseEntity<?> monitorDecison4(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorDecisonService.monitorDecison4(monitorRequest), HttpStatus.OK);
    }

    @PostMapping("/monitorDecison5")
    @ApiOperation(value = "Monitor Decison 5", response = String.class)
    public ResponseEntity<?> monitorDecison5(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorDecisonService.monitorDecison5(monitorRequest), HttpStatus.OK);
    }
}
