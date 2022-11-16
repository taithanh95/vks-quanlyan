package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstLawSearchRequest;
import com.bitsco.vks.models.SppAccusedSaveRequest;
import com.bitsco.vks.models.SppAccusedSearchRequest;
import com.bitsco.vks.service.SppAccusedService;
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
@RequestMapping(value = "/SppAccused")
public class SppAccusedController {
    private static final Logger LOGGER = LogManager.getLogger("SppAccusedController");

    @Autowired
    private SppAccusedService sppAccusedService;


    public SppAccusedController() {

    }

    @GetMapping("/search")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     SppAccusedSearchRequest sppRegisterSearchRequest) throws ApplicationException {
        return new ResponseEntity(sppAccusedService.search_bc(sppRegisterSearchRequest, pageable), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value = "Save Accused", response = String.class)
    public ResponseEntity<?> insert(@Valid @RequestBody SppAccusedSaveRequest request, BindingResult result, HttpServletRequest httpRequest) {
        LOGGER.info("Username: " + httpRequest.getHeader(Constant.KEY.USERNAME) + ", token: " + httpRequest.getHeader("Authorization"));
        return new ResponseEntity(sppAccusedService.save(request, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@Valid @RequestParam String code) {
        return new ResponseEntity<>(sppAccusedService.delete(code), HttpStatus.OK);
    }

    @GetMapping("/findLawcode")
    @ApiOperation(value = "Get list lawcode", response = List.class)
    public ResponseEntity<?> getList(@Valid @RequestParam String accucode) throws ApplicationException {
        return new ResponseEntity(sppAccusedService.findLawcodeByAccused(accucode), HttpStatus.OK);
    }

    @GetMapping("/searchLaw")
    @ApiOperation(value = "Get list law", response = List.class)
    public ResponseEntity<?> getListLaw(@PageableDefault(size = 10) Pageable pageable,
                                        LstLawSearchRequest lstLawSearchRequest) throws ApplicationException {
        return new ResponseEntity(sppAccusedService.searchLaw(lstLawSearchRequest, pageable), HttpStatus.OK);
    }

    @GetMapping("/getListCode")
    @ApiOperation(value = "Get list code", response = List.class)
    public ResponseEntity<?> getListCode(@Valid @RequestParam String code) throws ApplicationException {
        return new ResponseEntity(sppAccusedService.getLstCode(code), HttpStatus.OK);
    }

    @GetMapping("/getListLawGroup")
    @ApiOperation(value = "Get list law group", response = List.class)
    public ResponseEntity<?> getListLawGroup(@Valid @RequestParam String code) throws ApplicationException {
        return new ResponseEntity(sppAccusedService.getLstLawGroup(code), HttpStatus.OK);
    }

    @GetMapping("/findCaseCode")
    @ApiOperation(value="Get List CaseCode",response = List.class)
    public ResponseEntity<?> getListCaseCode(@Valid @RequestParam String arresteeId){
        return new ResponseEntity(sppAccusedService.findCaseCodeByArresteenId(arresteeId), HttpStatus.OK);
    }
}
