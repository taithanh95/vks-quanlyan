package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstLawSearchRequest;
import com.bitsco.vks.models.SppCenLawDeleteRequest;
import com.bitsco.vks.models.SppCenLawSaveRequest;
import com.bitsco.vks.service.SppCenLawService;
import com.bitsco.vks.utils.PaginationUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/SppCenLaw")
public class SppCenLawController {

    @Autowired
    private SppCenLawService sppCenLawService;

    @GetMapping("/searchFromAccuUpdateInfo")
    @ApiOperation(value= "Get list accu",response = List.class)
    public ResponseEntity<?> searchFromAccuUpdateInfo(@RequestParam String regicode, @RequestParam String centcode,
                                                      @RequestParam String accucode, @RequestParam String userfor){
        return new ResponseEntity(sppCenLawService.searchFromAccuUpdateInfo(regicode,centcode,accucode,userfor), HttpStatus.OK);
    }

    @PostMapping("/searchCenLaw")
    @ApiOperation(value= "Get list cenlaw",response = List.class)
    public ResponseEntity<?> searchLaw (@RequestBody LstLawSearchRequest lstLawSearchRequest) throws ApplicationException {
        return new ResponseEntity(sppCenLawService.searchCenLaw(lstLawSearchRequest), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value="Insert cenlaw update info",response = String.class)
    public ResponseEntity<?> insertCenlawUpdateInfo(@Valid @RequestBody SppCenLawSaveRequest req, HttpServletRequest httpRequest){
        return new ResponseEntity(sppCenLawService.insertCenLawUpdateInfo(req,httpRequest.getHeader(Constant.KEY.USERNAME)),HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value="Delete cenlaw", response = String.class)
    public ResponseEntity<?> deleteCenlaw(@Valid @RequestBody SppCenLawDeleteRequest req){
        return new ResponseEntity(sppCenLawService.deleteCenlaw(req),HttpStatus.OK);
    }
}
