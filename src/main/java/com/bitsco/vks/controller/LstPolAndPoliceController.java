package com.bitsco.vks.controller;

import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.service.LstPolAndPoliceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/dm/LstPolAndPolice")
public class LstPolAndPoliceController {

    @Autowired
    private LstPolAndPoliceService lstPolAndPoliceService;

    @GetMapping("/getListComboBox")
    @ApiOperation(value = "Get list combobox", response = List.class)
    public ResponseEntity<Object> getList(@RequestParam String name) throws ApplicationException {
        return new ResponseEntity(lstPolAndPoliceService.searchByName(name), HttpStatus.OK);
    }

}
