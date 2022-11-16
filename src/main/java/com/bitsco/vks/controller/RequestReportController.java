package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.entity.RequestReport;
import com.bitsco.vks.service.RequestReportService;
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
 * Date: 29/12/2021
 * Time: 2:15 PM
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/requestReport")
public class RequestReportController {
    @Autowired
    private RequestReportService requestReportService;

    @PostMapping("/search")
    @ApiOperation(value = "Search", response = String.class)
    public ResponseEntity<?> search(@Valid @RequestBody RequestReport request) {
        return new ResponseEntity<>(requestReportService.search(request), HttpStatus.OK);
    }

    @PostMapping("/insertOrUpdate")
    @ApiOperation(value = "Insert or update", response = String.class)
    public ResponseEntity<?> insertOrUpdate(@Valid @RequestBody RequestReport request, HttpServletRequest httpRequest) {
        return new ResponseEntity<>(requestReportService.insertOrUpdate(request, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "delete record", response = String.class)
    public ResponseEntity<?> delete(@Valid @RequestParam Long id) {
        return new ResponseEntity<>(requestReportService.delete(id), HttpStatus.OK);
    }

}
