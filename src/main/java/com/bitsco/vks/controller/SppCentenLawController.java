package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.models.SppCentenLawSaveRequest;
import com.bitsco.vks.models.SppCentenLawSearchRequest;
import com.bitsco.vks.service.SppCentenLawService;
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
@RequestMapping(value="/SppCentenLaw")
public class SppCentenLawController {

    @Autowired
    private SppCentenLawService sppCentenLawService;


    @GetMapping("/getList")
    @ApiOperation(value= "Get list centenLaws by centcode",response = List.class)
    public ResponseEntity<?> getCentenLaw (@Valid @RequestParam String centcode) {
        return new ResponseEntity(sppCentenLawService.searchCentenLaw(centcode), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value="Insert or update centenlaw", response = String.class)
    public ResponseEntity<?> deleteCenlaw(@Valid @RequestBody SppCentenLawSaveRequest req, HttpServletRequest httpRequest){
        return new ResponseEntity(sppCentenLawService.insertCentenLawUpdateInfo(req,httpRequest.getHeader(Constant.KEY.USERNAME)),HttpStatus.OK);
    }

    @PostMapping("/search")
    @ApiOperation(value= "Search list centenLaws",response = List.class)
    public ResponseEntity<?> getList (@Valid @RequestBody SppCentenLawSearchRequest req) {
        return new ResponseEntity(sppCentenLawService.searchList(req), HttpStatus.OK);
    }
}
