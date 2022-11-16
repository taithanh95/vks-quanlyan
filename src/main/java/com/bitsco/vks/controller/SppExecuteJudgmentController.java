package com.bitsco.vks.controller;

import com.bitsco.vks.models.*;
import com.bitsco.vks.service.SppExecutaJudgmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/SppExecuteJudgment")
public class SppExecuteJudgmentController {

    @Autowired
    private SppExecutaJudgmentService sppService;



    public SppExecuteJudgmentController(){

    }

    @PostMapping("/getListUpdateInfo")
    @ApiOperation(value = "Get list UpdateInfo G6", response = List.class)
    public ResponseEntity<?> getListUpdateInfo(@Valid @RequestBody UpdateInfoG6SearchRequest request) {
        return new ResponseEntity(sppService.doSearch(request), HttpStatus.OK);
    }
}
