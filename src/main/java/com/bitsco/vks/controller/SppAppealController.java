package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.*;
import com.bitsco.vks.service.SppAppealService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/SppAppeal")
public class SppAppealController {
    private static final Logger LOGGER = LogManager.getLogger("SppAppealController");

    @Autowired
    private SppAppealService sppAppealService;

    @GetMapping("/searchByRegicode")
    @ApiOperation(value = "Get list by regicode", response = List.class)
    public ResponseEntity<?> searchByRegicode(@PageableDefault(size = 10) Pageable pageable,
                                     SppAppealSearchRequest request) throws ApplicationException {
        return new ResponseEntity(sppAppealService.searchByRegicode(request, pageable), HttpStatus.OK);
    }

    @GetMapping("/searchByCasecode")
    @ApiOperation(value = "Get list by regicode", response = List.class)
    public ResponseEntity<?> searchByCasecode(@PageableDefault(size = 10) Pageable pageable,
                                              SppAppealSearchCaseRequest request) throws ApplicationException {
        return new ResponseEntity(sppAppealService.searchByCase(request, pageable), HttpStatus.OK);
    }

    @GetMapping("/lstAppeals")
    @ApiOperation(value = "lstAppeals", response = List.class)
    public ResponseEntity<?> lstAppeals() throws ApplicationException {
        return new ResponseEntity(sppAppealService.lstAppeals(null), HttpStatus.OK);
    }

    @GetMapping("/getAppealAcc")
    @ApiOperation(value = "getAppealAcc", response = List.class)
    public ResponseEntity<?> getAppealAcc(@RequestParam String appecode) throws ApplicationException {
        return new ResponseEntity(sppAppealService.getAppealAcc(appecode), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value = "Save SppAgainst", response = SppAppealSaveResponse.class)
    public ResponseEntity<?> insert(@Valid @RequestBody SppAppealSaveRequest request, BindingResult result, HttpServletRequest httpRequest) {
        LOGGER.info("Username: " + httpRequest.getHeader(Constant.KEY.USERNAME) + ", token: " + httpRequest.getHeader("Authorization"));
        return new ResponseEntity(sppAppealService.insertUpdate(request, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@Valid @RequestParam String code) {
        return new ResponseEntity<>(sppAppealService.delete(code), HttpStatus.OK);
    }
}
