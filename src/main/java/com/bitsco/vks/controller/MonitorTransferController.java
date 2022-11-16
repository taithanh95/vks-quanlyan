package com.bitsco.vks.controller;

import com.bitsco.vks.models.MonitorRequest;
import com.bitsco.vks.service.MonitorTransferService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/monitorTransfer")
public class MonitorTransferController {
    @Autowired
    MonitorTransferService monitorTransferService;

    @PostMapping("/type_cqdt_vks")
    @ApiOperation(value = "monitorTransfer Cơ quan điều tra - Viện kiểm sát", response = String.class)
    public ResponseEntity<?> monitorTransfer_cqdt_vks(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorTransferService.monitorTransferService_cqdt_vks(monitorRequest), HttpStatus.OK);
    }
    @PostMapping("/type_vks_ta")
    @ApiOperation(value = "monitorTransfer Viện kiểm sát - Tòa án", response = String.class)
    public ResponseEntity<?> monitorTransfer_vks_ta(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorTransferService.monitorTransferService_vks_ta(monitorRequest), HttpStatus.OK);
    }
    @PostMapping("/type_vks_vks")
    @ApiOperation(value = "monitorTransfer Viện kiểm sát - Viện kiểm sát", response = String.class)
    public ResponseEntity<?> monitorTransfer_vks_vks(@RequestBody MonitorRequest monitorRequest) throws Exception {
        return new ResponseEntity<>(monitorTransferService.monitorTransferService_vks_vks(monitorRequest), HttpStatus.OK);
    }
}
