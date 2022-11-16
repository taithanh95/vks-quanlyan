package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.entity.PreventMeasures;
import com.bitsco.vks.service.PreventMeasuresService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 20/01/2022
 * Time: 4:56 PM
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/preventMeasures")
public class PreventMeasuresController {
    @Autowired
    PreventMeasuresService preventMeasuresService;

    @GetMapping("/search")
    @ApiOperation(value = "Get list Prevent Measures", response = List.class)
    public ResponseEntity<?> search(PreventMeasures request) {
        return new ResponseEntity<>(preventMeasuresService.search(request), HttpStatus.OK);
    }

    @PostMapping("/insertOrUpdate")
    @ApiOperation(value = "Insert or update", response = String.class)
    public ResponseEntity<?> insertOrUpdate(@Valid @RequestBody PreventMeasures request, HttpServletRequest httpRequest) {
        return new ResponseEntity<>(preventMeasuresService.insertOrUpdate(request, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "delete record", response = String.class)
    public ResponseEntity<?> delete(@Valid @RequestParam String accucode) {
        return new ResponseEntity<>(preventMeasuresService.delete(accucode), HttpStatus.OK);
    }
}
