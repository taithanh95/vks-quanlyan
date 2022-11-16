package com.bitsco.vks.controller;

import com.bitsco.vks.models.MonitorRequest;
import com.bitsco.vks.service.MonitorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 04/07/2022
 * Time: 1:50 PM
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/monitor")
public class MonitorController {
    @Autowired
    private MonitorService monitorService;

    @PostMapping("/monitorRegister")
    @ApiOperation(value = "Monitor Register", response = String.class)
    public ResponseEntity<?> monitorRegister(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorService.monitorRegister(monitorRequest), HttpStatus.OK);
    }

    @GetMapping("/getLstLawGroupChap")
    @ApiOperation(value = "Get List Law Group Chap", response = String.class)
    public ResponseEntity<?> getLstLawGroupChap() throws Exception {
        return new ResponseEntity<>(monitorService.getLstLawGroupChap(), HttpStatus.OK);
    }

    @PostMapping("/monitorCase1")
    @ApiOperation(value = "Monitor case 1", response = String.class)
    public ResponseEntity<?> monitorCase1(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorService.monitorCase1(monitorRequest), HttpStatus.OK);
    }

    @PostMapping("/monitorCase2")
    @ApiOperation(value = "Monitor case 2", response = String.class)
    public ResponseEntity<?> monitorCase2(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorService.monitorCase2(monitorRequest), HttpStatus.OK);
    }

    @PostMapping("/monitorCase3")
    @ApiOperation(value = "Monitor case 3", response = String.class)
    public ResponseEntity<?> monitorCase3(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorService.monitorCase3(monitorRequest), HttpStatus.OK);
    }

    @PostMapping("/monitorCase4")
    @ApiOperation(value = "Monitor case 4", response = String.class)
    public ResponseEntity<?> monitorCase4(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorService.monitorCase4(monitorRequest), HttpStatus.OK);
    }

    @PostMapping("/monitorCase5")
    @ApiOperation(value = "Monitor case 5", response = String.class)
    public ResponseEntity<?> monitorCase5(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorService.monitorCase5(monitorRequest), HttpStatus.OK);
    }

    @PostMapping("/monitorCase6")
    @ApiOperation(value = "Monitor case 6", response = String.class)
    public ResponseEntity<?> monitorCase6(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorService.monitorCase6(monitorRequest), HttpStatus.OK);
    }

    @PostMapping("/monitorCase7")
    @ApiOperation(value = "Monitor case 7", response = String.class)
    public ResponseEntity<?> monitorCase7(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorService.monitorCase7(monitorRequest), HttpStatus.OK);
    }

    @PostMapping("/monitorCase8")
    @ApiOperation(value = "Monitor case 8", response = String.class)
    public ResponseEntity<?> monitorCase8(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorService.monitorCase8(monitorRequest), HttpStatus.OK);
    }

    @PostMapping("/monitorCase9")
    @ApiOperation(value = "Monitor case 9", response = String.class)
    public ResponseEntity<?> monitorCase9(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorService.monitorCase9(monitorRequest), HttpStatus.OK);
    }

    @PostMapping("/monitorLaw")
    @ApiOperation(value = "Monitor Law", response = String.class)
    public ResponseEntity<?> monitorLaw(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorService.monitorLaw(monitorRequest), HttpStatus.OK);
    }

    @PostMapping("/monitorPenalty")
    @ApiOperation(value = "Monitor Penalty", response = String.class)
    public ResponseEntity<?> monitorPenalty(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorService.monitorPenalty(monitorRequest), HttpStatus.OK);
    }

    @PostMapping("/monitorAgainst")
    @ApiOperation(value = "Monitor Against", response = String.class)
    public ResponseEntity<?> monitorAgainst(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorService.monitorAgainst(monitorRequest), HttpStatus.OK);
    }

    @PostMapping("/monitorAppeal")
    @ApiOperation(value = "Monitor Appeal", response = String.class)
    public ResponseEntity<?> monitorAppeal(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorService.monitorAppeal(monitorRequest), HttpStatus.OK);
    }
}
