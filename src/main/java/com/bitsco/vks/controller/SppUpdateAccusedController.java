package com.bitsco.vks.controller;

import com.bitsco.vks.models.SppAccusedSaveRequest;
import com.bitsco.vks.models.SppUpdateAccusedInsertDeleteRequest;
import com.bitsco.vks.service.SppUpdateAccusedService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping(value="/SppUpdateAccused")
public class SppUpdateAccusedController {
    @Autowired
    private SppUpdateAccusedService sppUpdateAccusedService;

    @PostMapping("/insertDelete")
    @ApiOperation(value = "Save Accused", response = String.class)
    public ResponseEntity<?> insert(@Valid @RequestBody SppUpdateAccusedInsertDeleteRequest request, BindingResult result) {
        return new ResponseEntity(sppUpdateAccusedService.insertUpdate(request), HttpStatus.OK);
    }
}
