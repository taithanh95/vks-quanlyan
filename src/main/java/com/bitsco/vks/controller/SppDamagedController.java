package com.bitsco.vks.controller;

import com.bitsco.vks.request.SppDamagedRequest;
import com.bitsco.vks.service.SppDamagedService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "sppdamaged")
public class SppDamagedController {
    @Autowired
    SppDamagedService sppDamagedService;

    @ApiOperation(value = "Thêm mới/Cập nhật")
    @CrossOrigin(origins = "*")
    @PostMapping("/insert/")
    public ResponseEntity<?> insert(@RequestBody SppDamagedRequest sppDamagedRequest) throws Exception {
        sppDamagedService.insertUpdate(sppDamagedRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @ApiOperation(value = "Xóa")
    @CrossOrigin(origins = "*")
    @PostMapping("/deleteById/")
    public ResponseEntity<?> deleteById(@RequestBody SppDamagedRequest sppDamagedRequest) throws Exception {
        sppDamagedService.deleteByID(sppDamagedRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @ApiOperation(value = "Truy vấn danh sách theo casecode")
    @CrossOrigin(origins = "*")
    @PostMapping("/findByIdCaseCode/")
    public ResponseEntity<?> findByIdCaseCode(@RequestBody SppDamagedRequest sppDamagedRequest) throws Exception {
        return new ResponseEntity<>(sppDamagedService.getByCaseCode(sppDamagedRequest), HttpStatus.OK);
    }
}
