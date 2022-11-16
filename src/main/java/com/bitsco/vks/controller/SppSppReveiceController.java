package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.*;
import com.bitsco.vks.service.SppSppReveiceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/SppReveice")
public class SppSppReveiceController {

    @Autowired
    private SppSppReveiceService sppSppReveiceService;

    @PostMapping(value="/getList")
    @ApiOperation(value="Get list spp reveice",response = List.class)
    public ResponseEntity<?> getList(@Valid @RequestBody SppSppReveiceSearchRequest req) throws ApplicationException {
        return new ResponseEntity<>(sppSppReveiceService.search(req), HttpStatus.OK);
    }

    @GetMapping(value="/getTransferByTransId")
    @ApiOperation(value="Get transfer", response = List.class)
    public ResponseEntity<?> getTransfer(@Valid @RequestParam String transid){
        return new ResponseEntity<>(sppSppReveiceService.getTransferByTransId(transid), HttpStatus.OK);
    }

    @PostMapping(value="/update")
    @ApiOperation(value="update spp send", response = String.class)
    public ResponseEntity<?> updateSpp(@Valid @RequestBody SppSppReveiceSaveRequest req, HttpServletRequest httpRequest){
        return new ResponseEntity<>(sppSppReveiceService.update(req,httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }
}
