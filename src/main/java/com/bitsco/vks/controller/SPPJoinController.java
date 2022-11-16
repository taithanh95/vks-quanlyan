package com.bitsco.vks.controller;

import com.bitsco.vks.models.SppJoinSaveRequest;
import com.bitsco.vks.models.SppJoinSearchRequest;
import com.bitsco.vks.service.SppJoinService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/SppJoinCase")
public class SPPJoinController {

    @Autowired
    private SppJoinService sppJoinService;

    @PostMapping("/getListJoin")
    @ApiOperation(value = "Get list join case", response = List.class)
    public ResponseEntity<?> getList(@Valid @RequestBody SppJoinSearchRequest req) {
        return new ResponseEntity<>(sppJoinService.getList(req), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value="insert or update join case", response = String.class)
    public ResponseEntity<?> save(@Valid @RequestBody SppJoinSaveRequest req) {
        return new ResponseEntity<>(sppJoinService.save(req), HttpStatus.OK);
    }
}
