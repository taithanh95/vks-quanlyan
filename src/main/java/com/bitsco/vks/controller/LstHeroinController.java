package com.bitsco.vks.controller;

import com.bitsco.vks.service.LstHeroinService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/dm/LstHeroin")
public class LstHeroinController {
    @Autowired
    private LstHeroinService lstHeroinService;

    @GetMapping("/getall")
    @ApiOperation(value = "Get list objects by query", response = List.class)
    public ResponseEntity<?> getall() throws SQLException {
        return new ResponseEntity(lstHeroinService.getall(), HttpStatus.OK);
    }
}
