package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.entity.ReportAppeal;
import com.bitsco.vks.service.ReportAppealService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 20/01/2022
 * Time: 10:30 AM
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/reportAppeal")
public class ReportAppealController {
    @Autowired
    ReportAppealService reportAppealService;

    @PostMapping("/search")
    @ApiOperation(value = "Search", response = String.class)
    public ResponseEntity<?> search(@Valid @RequestBody ReportAppeal request) {
        return new ResponseEntity<>(reportAppealService.search(request), HttpStatus.OK);
    }

    @PostMapping("/insertOrUpdate")
    @ApiOperation(value = "Insert or update", response = String.class)
    public ResponseEntity<?> insertOrUpdate(@Valid @RequestBody ReportAppeal request, HttpServletRequest httpRequest) {
        return new ResponseEntity<>(reportAppealService.insertOrUpdate(request, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "delete record", response = String.class)
    public ResponseEntity<?> delete(@Valid @RequestParam Long id) {
        return new ResponseEntity<>(reportAppealService.delete(id), HttpStatus.OK);
    }
}
