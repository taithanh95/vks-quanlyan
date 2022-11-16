package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.models.SppJudgementSaveRequest;
import com.bitsco.vks.models.SppJudgementSaveResponse;
import com.bitsco.vks.service.SppJudgementService;
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
@RequestMapping(value="/SppJudgement")
public class SppJudgementController {

    @Autowired
    private SppJudgementService sppJudgementService;

    @GetMapping("/search")
    @ApiOperation(value="Search list judgement",response = List.class)
    public ResponseEntity<?> saerchJudgement(@RequestParam String regicode, @RequestParam String centcode,
                                             @RequestParam String accucode, @RequestParam boolean isCheckspppenal){
        return new ResponseEntity(sppJudgementService.search(regicode,centcode,accucode,isCheckspppenal), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value="handle insert update delete judgement",response = SppJudgementSaveResponse.class)
    public ResponseEntity<?> updateJudgement(@Valid @RequestBody SppJudgementSaveRequest req, HttpServletRequest httpRequest){
        return new ResponseEntity(sppJudgementService.updateJudgement(req,httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }
}
