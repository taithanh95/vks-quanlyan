package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.models.ProcessCaseStaticc;
import com.bitsco.vks.models.SppStattisticaSaveRequest;
import com.bitsco.vks.service.SppStatisticaService;
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
@RequestMapping(value = "/SppStatistica")
public class SppStatisticaController {

    @Autowired
    private SppStatisticaService sppStatisticaService;

    @GetMapping("/search")
    @ApiOperation(value = "Search list statica", response = List.class)
    public ResponseEntity<?> searchStaticaLawcode(@RequestParam String regicode, @RequestParam String centcode,
                                                  @RequestParam String accucode, @RequestParam String lawcode,
                                                  @RequestParam String userfor) {
        return new ResponseEntity(sppStatisticaService.search(regicode, centcode, accucode, lawcode, userfor), HttpStatus.OK);
    }

    @GetMapping("/searchStaticcLawcodeUpdateInfo")
    @ApiOperation(value = "Search list statica", response = List.class)
    public ResponseEntity<?> searchStaticcLawcodeUpdateInfo(@RequestParam String regicode, @RequestParam String centcode, @RequestParam String lawcode,
                                                  @RequestParam String userfor) {
        return new ResponseEntity(sppStatisticaService.searchStaticcLawcodeUpdateInfo(regicode, centcode, lawcode, userfor), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value = "Search list statica", response = String.class)
    public ResponseEntity<?> updateStatica(@Valid @RequestBody SppStattisticaSaveRequest req, HttpServletRequest httpRequest) {
        return new ResponseEntity(sppStatisticaService.insert(req, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/insertCaseStatis")
    @ApiOperation(value = "Search list statica", response = String.class)
    public ResponseEntity<?> insertCaseStatis(@Valid @RequestBody ProcessCaseStaticc request, HttpServletRequest httpRequest) {
        return new ResponseEntity(sppStatisticaService.insertCaseStatis(request, request.userfor, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }
}
