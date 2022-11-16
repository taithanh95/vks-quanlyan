package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.RequestTransfer;
import com.bitsco.vks.models.SppSppSendSaveRequest;
import com.bitsco.vks.models.SppSppSendSearchNameRequest;
import com.bitsco.vks.models.SppSppSendSearchRequest;
import com.bitsco.vks.service.SppSppSendService;
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
@RequestMapping(value = "/SppSend")
public class SppSppSendController {

    @Autowired
    private SppSppSendService sppSppSendService;

    @PostMapping(value = "/getListSppSend")
    @ApiOperation(value = "Get list spp send", response = List.class)
    public ResponseEntity<?> getList(@Valid @RequestBody SppSppSendSearchRequest req) throws ApplicationException {
        return new ResponseEntity<>(sppSppSendService.search(req), HttpStatus.OK);
    }

    @GetMapping(value = "/getListSpp")
    @ApiOperation(value = "Get list spp", response = List.class)
    public ResponseEntity<?> getListSpp(SppSppSendSearchNameRequest req) {
        return new ResponseEntity<>(sppSppSendService.getListSpp(req), HttpStatus.OK);
    }

    @GetMapping(value = "/getListTransfer")
    @ApiOperation(value = "Get list transfer", response = List.class)
    public ResponseEntity<?> getListTransfer(@RequestParam String userforregis,
                                             @RequestParam String userfor,
                                             @RequestParam String sppid) {
        return new ResponseEntity<>(sppSppSendService.getListTransfer(userforregis, userfor, sppid), HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "update spp send", response = String.class)
    public ResponseEntity<?> updateSpp(@Valid @RequestBody SppSppSendSaveRequest req, HttpServletRequest httpRequest) {
        return new ResponseEntity<>(sppSppSendService.update(req, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping(value = "/searchRequest")
    @ApiOperation(value = "Search Request", response = List.class)
    public ResponseEntity<?> searchRequest(@Valid @RequestBody SppSppSendSearchRequest req) throws ApplicationException {
        return new ResponseEntity<>(sppSppSendService.searchRequest(req), HttpStatus.OK);
    }

    @PostMapping(value = "/insertRequest")
    @ApiOperation(value = "Insert Request", response = String.class)
    public ResponseEntity<?> insertRequest(@RequestBody RequestTransfer req, HttpServletRequest httpRequest) {
        return new ResponseEntity<>(sppSppSendService.insertRequest(req.getRegicode(), req.getCentcode(), req.getStatus(), httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }


    @GetMapping(value = "/getListSppTinh")
    @ApiOperation(value = "Get list spp tỉnh", response = List.class)
    public ResponseEntity<?> getListSppTinh(String req) {
        return new ResponseEntity<>(sppSppSendService.getListSppTinh(req), HttpStatus.OK);
    }


    @GetMapping(value = "/getListSppHuyen")
    @ApiOperation(value = "Get list spp huyện", response = List.class)
    public ResponseEntity<?> getListSppHuyen(@Valid @RequestParam String sppid) {
        return new ResponseEntity<>(sppSppSendService.getListSppHuyen(sppid), HttpStatus.OK);
    }
}
