package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.models.SppCenPenalTotalSaveRequest;
import com.bitsco.vks.models.SppCenPenaltySaveRequest;
import com.bitsco.vks.models.SppCenPenaltySaveResponse;
import com.bitsco.vks.service.SppCenPenaltyService;
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
@RequestMapping(value="/SppCenPenalty")
public class SppCenPenaltyController {

    @Autowired
    private SppCenPenaltyService sppCenPenaltyService;

    @GetMapping("/search")
    @ApiOperation(value="Search list cenpenalty",response = List.class)
    public ResponseEntity<?> saerchCenpenalty(@RequestParam String centcode, @RequestParam String lawcode,
                                              @RequestParam String accucode, @RequestParam boolean isCheckspppenal){
        return new ResponseEntity(sppCenPenaltyService.search(centcode,lawcode,accucode,isCheckspppenal), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value="handle insert update delete CenPenalty",response = SppCenPenaltySaveResponse.class)
    public ResponseEntity<?> updateCenpenalty(@Valid @RequestBody SppCenPenaltySaveRequest req, HttpServletRequest httpRequest){
        return new ResponseEntity(sppCenPenaltyService.updateCenPenalty(req,httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/inserUpdTotal")
    @ApiOperation(value="handle insert update total cenpenaltyty",response = String.class)
    public ResponseEntity<?> updateTotalCenPenalty(@Valid @RequestBody SppCenPenalTotalSaveRequest req, HttpServletRequest httpRequest){
        return new ResponseEntity(sppCenPenaltyService.updateTotalCenPenalty(req,httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }
}
