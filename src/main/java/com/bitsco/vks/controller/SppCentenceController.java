package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.InsertUpdateCentenceDTO;
import com.bitsco.vks.entity.SppCentAccu;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.*;
import com.bitsco.vks.service.SppCentenceService;
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
@RequestMapping(value="/SppCentence")
public class SppCentenceController {
    @Autowired
    private SppCentenceService sppCentenceService;

    public SppCentenceController(){

    }

    @GetMapping("/search")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     SppCentenceSearchRequest sppCentenceSearchRequest) throws ApplicationException {
        return new ResponseEntity(sppCentenceService.search(sppCentenceSearchRequest, pageable), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value = "Save centence", response = InsertUpdateCentenceDTO.class)
    public ResponseEntity<?> save(@Valid @RequestBody SppCentenceSaveRequest request, BindingResult result) {
        return new ResponseEntity(sppCentenceService.insertUpdateUpdateInfo(request), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "Delete centence", response = String.class)
    public ResponseEntity<?> delete(@Valid @RequestBody SppCentenceDeleteRequest request){
        return new ResponseEntity<>(sppCentenceService.delete(request), HttpStatus.OK);
    }
    @GetMapping("/getaccufromcentcode")
    @ApiOperation(value = "Get accu from centcode", response = List.class)
    public ResponseEntity<?> getaccufromcentcode(@Valid @RequestParam String centcode) {
        return new ResponseEntity(sppCentenceService.getaccufromcentcode(centcode), HttpStatus.OK);
    }

    @PostMapping("/deleteUpdateinfo")
    @ApiOperation(value = "Process centence", response = InsertUpdateCentenceDTO.class)
    public ResponseEntity<?> insertUpdateDelete(@Valid @RequestBody ProcessCentenceRequest request, BindingResult result, HttpServletRequest httpRequest) {
        return new ResponseEntity(sppCentenceService.deleteUpdateinfo(request, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @GetMapping("/getCentDetail")
    @ApiOperation(value = "Get centence by centcode and sppid", response = Object.class)
    public ResponseEntity<?> getCentDetail(@Valid @RequestParam String centcode, @Valid @RequestParam String sppid) {
        return new ResponseEntity(sppCentenceService.getCentDetail(centcode,sppid), HttpStatus.OK);
    }

    @GetMapping("/searchCentApped")
    @ApiOperation(value = "Get list centence by centcode", response = List.class)
    public ResponseEntity<?> searchCentApped(@Valid @RequestParam String regicode, @Valid @RequestParam String type) {
        return new ResponseEntity(sppCentenceService.searchCentApped(regicode,type), HttpStatus.OK);
    }

    @GetMapping("/getCentAccu")
    @ApiOperation(value = "Get centaccu by centcode and accucode", response = List.class)
    public ResponseEntity<?> searchCentAccu(@Valid @RequestParam String centcode, @Valid @RequestParam String accucode) {
        return new ResponseEntity(sppCentenceService.getCentAccu(centcode,accucode), HttpStatus.OK);
    }

    @PostMapping("/saveCentAccu")
    @ApiOperation(value = "Insert or update centaccu ", response = List.class)
    public ResponseEntity<?> saveCentAccu(@Valid @RequestBody SppCentAccu req, HttpServletRequest httpRequest) {
        return new ResponseEntity(sppCentenceService.saveCentAccu(req,httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/deleteCentAccu")
    @ApiOperation(value = "delete CentAccu", response = List.class)
    public ResponseEntity<?> deleteCentAccu(@Valid @RequestBody SppCentAccu req) {
        return new ResponseEntity(sppCentenceService.deleteCentAccu(req.getCentcode(), req.getAccucode(), req.getRegicode()), HttpStatus.OK);
    }
}
