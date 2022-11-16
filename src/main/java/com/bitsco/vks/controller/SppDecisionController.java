package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.entity.SppDecision;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.*;
import com.bitsco.vks.service.SppDecisionService;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping(value="/SppDecision")
public class SppDecisionController {
    @Autowired
    private SppDecisionService sppDecisionService;

    public SppDecisionController(){

    }

    @GetMapping("/search")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     SppDecisionSearchRequest sppDecisionSearchRequest) throws ApplicationException {
        return new ResponseEntity(sppDecisionService.search(sppDecisionSearchRequest, pageable), HttpStatus.OK);
    }

    @GetMapping("/searchDecitype")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> searchDecitype(@Valid @RequestParam String applyfor, @Valid @RequestParam String usefor) throws ApplicationException {
        return new ResponseEntity(sppDecisionService.searchDecitypeHS(applyfor, usefor), HttpStatus.OK);
    }

    @GetMapping("/searchGH")
    @ApiOperation(value = "Get list gia han", response = List.class)
    public ResponseEntity<?> searchGH(@Valid @RequestParam String usefor, @Valid @RequestParam String applyfor, @Valid @RequestParam String deciid) throws ApplicationException {
        return new ResponseEntity(sppDecisionService.search_gh(usefor, applyfor, deciid), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value = "Save Decision", response = String.class)
    public ResponseEntity<?> save(@Valid @RequestBody SppDecisionSaveRequest request, BindingResult result, HttpServletRequest httpRequest) {
        return new ResponseEntity(sppDecisionService.insertUpdate(request.action, request.decision, httpRequest.getHeader(Constant.KEY.USERNAME), request.sppid), HttpStatus.OK);
    }
    @PostMapping("/saveAcc")
    @ApiOperation(value = "Save Decision", response = String.class)
    public ResponseEntity<?> saveAcc(@Valid @RequestBody SppDecisionSaveRequest request, BindingResult result, HttpServletRequest httpRequest) {
        return new ResponseEntity(sppDecisionService.insertUpdateAcc(request.action, request.decision, httpRequest.getHeader(Constant.KEY.USERNAME), request.sppid), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "Delete decision", response = String.class)
    public ResponseEntity<?> delete(@Valid @RequestBody SppDecision decision){
        return new ResponseEntity<>(sppDecisionService.delete(decision), HttpStatus.OK);
    }
    @PostMapping("/deleteAcc")
    @ApiOperation(value = "Delete decision acc", response = String.class)
    public ResponseEntity<?> deleteAcc(@Valid @RequestParam String decicode){
        return new ResponseEntity<>(sppDecisionService.deleteAcc(decicode), HttpStatus.OK);
    }

    @GetMapping("/getDeciDetail")
    @ApiOperation(value = "Get decision by decicode", response = Object.class)
    public ResponseEntity<?> getCentDetail(@Valid @RequestParam String decicode) {
        return new ResponseEntity(sppDecisionService.getDeciDetail(decicode), HttpStatus.OK);
    }
}
