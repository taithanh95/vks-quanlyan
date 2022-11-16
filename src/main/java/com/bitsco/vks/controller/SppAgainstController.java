package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.*;
import com.bitsco.vks.service.SppAgainstService;
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
@RequestMapping(value = "/SppAgainst")
public class SppAgainstController {
    private static final Logger LOGGER = LogManager.getLogger("SppAgainstController");

    @Autowired
    private SppAgainstService service;

    @GetMapping("/searchByRegicode")
    @ApiOperation(value = "Get list by regicode", response = List.class)
    public ResponseEntity<?> searchByRegicode(@PageableDefault(size = 10) Pageable pageable,
                                              SppAgainstSearchRegiRequest request) throws ApplicationException {
        return new ResponseEntity(service.searchByRegicode(request, pageable), HttpStatus.OK);
    }

    @GetMapping("/searchByCasecode")
    @ApiOperation(value = "Get list by regicode", response = List.class)
    public ResponseEntity<?> searchByCasecode(@PageableDefault(size = 10) Pageable pageable,
                                              SppAgainstSearchCaseRequest request) throws ApplicationException {
        return new ResponseEntity(service.searchcase(request, pageable), HttpStatus.OK);
    }

    @GetMapping("/loadLstAgainsts")
    @ApiOperation(value = "loadLstAgainsts", response = List.class)
    public ResponseEntity<?> loadLstAgainsts() throws ApplicationException {
        return new ResponseEntity(service.loadLstAgainsts(null), HttpStatus.OK);
    }

    @GetMapping("/loadLstAgainstResult")
    @ApiOperation(value = "loadLstAgainstResult", response = List.class)
    public ResponseEntity<?> loadLstAgainstResult() throws ApplicationException {
        return new ResponseEntity(service.loadLstAgainstResult(null), HttpStatus.OK);
    }

    @GetMapping("/getAgacase")
    @ApiOperation(value = "getAgacase", response = List.class)
    public ResponseEntity<?> getAgacase(@RequestParam String againstcode) throws ApplicationException {
        return new ResponseEntity(service.getAgacase(againstcode), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value = "Save SppAgainst", response = SppAgainstSaveResponse.class)
    public ResponseEntity<?> insert(@Valid @RequestBody SppAgainstSaveRequest request, BindingResult result, HttpServletRequest httpRequest) {
        LOGGER.info("Username: " + httpRequest.getHeader(Constant.KEY.USERNAME) + ", token: " + httpRequest.getHeader("Authorization"));
        return new ResponseEntity(service.insertUpdate(request, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "Delete SppAgainst", response = String.class)
    public ResponseEntity<?> insert(@Valid @RequestBody SppAgainstDeleteRequest request, BindingResult result, HttpServletRequest httpRequest) {
        return new ResponseEntity(service.delete(request), HttpStatus.OK);
    }

    @GetMapping("/isCheckTransdate")
    @ApiOperation(value = "isCheck trans", response = List.class)
    public ResponseEntity<?> isCheckTrans(@RequestParam String regicode) throws ApplicationException {
        return new ResponseEntity(service.isCheckTrans(regicode), HttpStatus.OK);
    }

    @GetMapping("/isCheck")
    @ApiOperation(value = "isCheck", response = Integer.class)
    public ResponseEntity<?> isCheck(@RequestParam String regicode) throws ApplicationException {
        return new ResponseEntity(service.isCheckDisable(regicode), HttpStatus.OK);
    }

    @GetMapping("/searchForUpdateResult")
    @ApiOperation(value = "Search For Update Result", response = List.class)
    public ResponseEntity<?> searchForUpdateResult(@PageableDefault(size = 10) Pageable pageable,
                                              SppAgainstSearchCaseRequest request) throws ApplicationException {
        return new ResponseEntity(service.searchForUpdateResult(request, pageable), HttpStatus.OK);
    }

    @PostMapping("/updateResult")
    @ApiOperation(value = "Update Result", response = SppAgainstSaveResponse.class)
    public ResponseEntity<?> updateResult(@Valid @RequestBody SppAgainstSaveRequest request, BindingResult result, HttpServletRequest httpRequest) {
        LOGGER.info("Username: " + httpRequest.getHeader(Constant.KEY.USERNAME) + ", token: " + httpRequest.getHeader("Authorization"));
        return new ResponseEntity(service.updateResult(request, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }
}
