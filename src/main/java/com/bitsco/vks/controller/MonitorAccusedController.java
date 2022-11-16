package com.bitsco.vks.controller;

import com.bitsco.vks.models.MonitorRequest;
import com.bitsco.vks.service.MonitorAccusedService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/monitorAccused")
public class MonitorAccusedController {

    @Autowired
    MonitorAccusedService monitorAccusedService;

    @PostMapping("/type_1")
    @ApiOperation(value = "monitorAccused 1", response = String.class)
    public ResponseEntity<?> monitorAccused_1(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorAccusedService.MonitorAccusedService_1(monitorRequest), HttpStatus.OK);
    }
    @PostMapping("/type_2")
    @ApiOperation(value = "monitorAccused 2", response = String.class)
    public ResponseEntity<?> monitorAccused_2(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorAccusedService.MonitorAccusedService_2(monitorRequest), HttpStatus.OK);
    }
    @PostMapping("/type_3")
    @ApiOperation(value = "monitorAccused 3", response = String.class)
    public ResponseEntity<?> monitorAccused_3(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorAccusedService.MonitorAccusedService_3(monitorRequest), HttpStatus.OK);
    }
    @PostMapping("/type_4")
    @ApiOperation(value = "monitorAccused 4", response = String.class)
    public ResponseEntity<?> monitorAccused_4(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorAccusedService.MonitorAccusedService_4(monitorRequest), HttpStatus.OK);
    }
    @PostMapping("/type_5")
    @ApiOperation(value = "monitorAccused 5", response = String.class)
    public ResponseEntity<?> monitorAccused_5(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorAccusedService.MonitorAccusedService_5(monitorRequest), HttpStatus.OK);
    }
    @PostMapping("/type_6")
    @ApiOperation(value = "monitorAccused 6", response = String.class)
    public ResponseEntity<?> monitorAccused_6(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorAccusedService.MonitorAccusedService_6(monitorRequest), HttpStatus.OK);
    }
    @PostMapping("/type_7")
    @ApiOperation(value = "monitorAccused 7", response = String.class)
    public ResponseEntity<?> monitorAccused_7(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorAccusedService.MonitorAccusedService_7(monitorRequest), HttpStatus.OK);
    }
    @PostMapping("/type_8")
    @ApiOperation(value = "monitorAccused 8", response = String.class)
    public ResponseEntity<?> monitorAccused_8(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorAccusedService.MonitorAccusedService_8(monitorRequest), HttpStatus.OK);
    }
    @PostMapping("/type_11")
    @ApiOperation(value = "monitorAccused 11", response = String.class)
    public ResponseEntity<?> monitorAccused_11(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorAccusedService.MonitorAccusedService_11(monitorRequest), HttpStatus.OK);
    }
}
