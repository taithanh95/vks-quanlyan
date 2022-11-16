package com.bitsco.vks.controller;

import com.bitsco.vks.exception.CommonException;
import com.bitsco.vks.response.Response;
import com.bitsco.vks.response.ResponseBody;
import com.bitsco.vks.service.DetailCaseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 21/04/2022
 * Time: 10:26 AM
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/detailcase")
public class DetailCaseController {
    @Autowired
    DetailCaseService detailCaseService;

    @GetMapping("/exportPDF")
    @ApiOperation(value = "Export PDF", response = List.class)
    public ResponseEntity<?> requestReportPdf( @RequestParam String casecode, @RequestParam String regicode) throws Exception {
        try {
            return new ResponseEntity<>(new ResponseBody(Response.SUCCESS, detailCaseService.requestReportPdf(casecode, regicode)), HttpStatus.OK);
        } catch (CommonException e) {
            return new ResponseEntity<>(new ResponseBody(e.getResponse().getResponseCode(), e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseBody(Response.SYSTEM_ERROR, e.getMessage()), HttpStatus.OK);
        }
    }
}
