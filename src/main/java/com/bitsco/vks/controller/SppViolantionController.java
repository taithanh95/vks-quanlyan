package com.bitsco.vks.controller;

import com.bitsco.vks.service.SppViolantionService;
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
@RequestMapping(value = "/SppViolantion")
public class SppViolantionController {
    @Autowired
    private SppViolantionService sppViolantionService;

    @GetMapping("/getSppViolantionByAcuucode")
    @ApiOperation(value = "Get list SppViolantion", response = List.class)
    public ResponseEntity<?> getSppViolantionByAcuucode(String accucode) {
        return new ResponseEntity<>(sppViolantionService.getSppViolantionByAccucode(accucode), HttpStatus.OK);
    }

    @GetMapping("/deleteById")
    @ApiOperation(value = "Delete SppViolantion")
    public ResponseEntity<?> deleteById(Long idViolantion) {
        sppViolantionService.deleteById(idViolantion);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
