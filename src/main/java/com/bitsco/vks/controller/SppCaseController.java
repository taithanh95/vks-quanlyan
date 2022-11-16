package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.entity.SppInvestment;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.*;
import com.bitsco.vks.service.SppCaseService;
import com.bitsco.vks.service.SppService;
import com.bitsco.vks.service.UserService;
import com.bitsco.vks.utils.PaginationUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/SppCase")
public class SppCaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private SppCaseService sppCaseService;
    @Autowired
    private SppService sppService;


    public SppCaseController(){

    }

    @PostMapping("/getListUpdateInfo")
    @ApiOperation(value = "Get list UpdateInfo", response = List.class)
    public ResponseEntity<?> getListUpdateInfo(@Valid @RequestBody UpdateInfoRequest request, BindingResult result) {
        return new ResponseEntity(sppCaseService.doSearch(request), HttpStatus.OK);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "Insert SppCase", response = String.class)
    public ResponseEntity<?> insert(@Valid @RequestBody SppCaseInsertRequest request, BindingResult result) {
        return new ResponseEntity(sppCaseService.insert(request), HttpStatus.OK);
    }
    @PostMapping("/update")
    @ApiOperation(value = "Update SppCase", response = String.class)
    public ResponseEntity<?> update(@Valid @RequestBody SppCaseInsertRequest request, BindingResult result) {
        return new ResponseEntity(sppCaseService.update(request), HttpStatus.OK);
    }

    @GetMapping("/getListCaseLaw")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     UpdateInfoSearchRequest sppRegisterSearchRequest) throws ApplicationException {
        List<LinkedCaseInsensitiveMap> page = sppCaseService.searchCaswlaw(sppRegisterSearchRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(((Number) page.get(0).get("ROWCOUNT")).longValue(),pageable.getPageNumber(),pageable.getPageSize(),page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(sppRegisterSearchRequest, pageable, "/SppCase/getListCaseLaw", ((Number) page.get(0).get("ROWCOUNT")).longValue()); //page.get(0).ROWCOUNT
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(sppRegisterSearchRequest, pageable, "/SppCase/getListCaseLaw", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/getTransidByCase")
    @ApiOperation(value = "Get transid by case", response = String.class)
    public ResponseEntity<?> getTransidByCase(@Valid @RequestParam String casecode,@Valid @RequestParam String usefor,@Valid @RequestParam String sppid, BindingResult result) {
        return new ResponseEntity(sppCaseService.getTransidByCase(casecode, usefor, sppid), HttpStatus.OK);
    }
    @GetMapping("/searchLawByCase")
    @ApiOperation(value = "Search Law By Case", response = List.class)
    public ResponseEntity<?> searchLawByCase(@Valid @RequestParam String casecode, @Valid @RequestParam String userfor) {
        return new ResponseEntity(sppCaseService.searchLawByCase(casecode,userfor), HttpStatus.OK);
    }
    @PostMapping("/updateCaselawcodewithwarn")
    @ApiOperation(value = "Update case law code with warn", response = String.class)
    public ResponseEntity<?> updateCaselawcodewithwarn(@Valid @RequestBody UpdateCaseLawWithWarnRequest request, BindingResult result, HttpServletRequest httpRequest) {
        return new ResponseEntity(sppCaseService.updateCaselawcodewithwarn(request, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/insertUpdateDeleteCaseLaw")
    @ApiOperation(value = "Insert/update/delete case law with warn", response = String.class)
    public ResponseEntity<?> insertUpdateDeleteCaseLaw(@Valid @RequestBody ProcessCaseLawRequest request, BindingResult result, HttpServletRequest httpRequest) {
        return new ResponseEntity(sppCaseService.insertUpdateDeleteCaseLaw(request, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/deleteCaseLawUpdateInfo")
    @ApiOperation(value = "Delete case law", response = String.class)
    public ResponseEntity<?> deleteCaseLawUpdateInfo(@Valid @RequestBody ProcessCaseLawRequest request, BindingResult result, HttpServletRequest httpRequest) {
        return new ResponseEntity(sppCaseService.deleteCaseLawUpdateInfo(request, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "Delete sppCase", response = String.class)
    public ResponseEntity<?> delete(@Valid @RequestParam String casecode, HttpServletRequest httpRequest) {
        return new ResponseEntity(sppCaseService.delete(casecode, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }
    @GetMapping("/searchCaseStatic")
    @ApiOperation(value = "Search Static By Case", response = List.class)
    public ResponseEntity<?> searchCaseStatic(@Valid @RequestParam String casecode, @Valid @RequestParam String lawcode) {
        return new ResponseEntity(sppCaseService.searchCaseStatic(casecode, lawcode), HttpStatus.OK);
    }
    @GetMapping("/searchHeroin")
    @ApiOperation(value = "Search Heroin By Case", response = List.class)
    public ResponseEntity<?> searchHeroin(@Valid @RequestParam String casecode, @Valid @RequestParam String lawcode) {
        return new ResponseEntity(sppCaseService.searchHeroin(casecode, lawcode), HttpStatus.OK);
    }
    @GetMapping("/searchExhibit")
    @ApiOperation(value = "Search CaseExhibit By Case", response = List.class)
    public ResponseEntity<?> searchExhibit(@Valid @RequestParam String casecode, @Valid @RequestParam String lawcode) {
        return new ResponseEntity(sppCaseService.searchExhibit(casecode, lawcode), HttpStatus.OK);
    }

    @PostMapping("/insertStaticcBegin")
    @ApiOperation(value = "Insert SppStaticcBegin with warn", response = String.class)
    public ResponseEntity<?> insertStaticcBegin(@Valid @RequestBody ProcessStaticcBeginRequest request, BindingResult result, HttpServletRequest httpRequest) {
        return new ResponseEntity(sppCaseService.insertStaticcBegin(request, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/insertCaseHeroin")
    @ApiOperation(value = "Insert CaseHeroin", response = String.class)
    public ResponseEntity<?> insertCaseHeroin(@Valid @RequestBody ProcessCaseHeroinRequest request, BindingResult result, HttpServletRequest httpRequest) {
        return new ResponseEntity(sppCaseService.insertCaseHeroin(request, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/updateCaseHeroin")
    @ApiOperation(value = "Update SppStaticcBegin", response = String.class)
    public ResponseEntity<?> updateCaseHeroin(@Valid @RequestBody ProcessCaseHeroinRequest request, BindingResult result, HttpServletRequest httpRequest) {
        return new ResponseEntity(sppCaseService.updateCaseHeroin(request, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/insertCaseExhibit")
    @ApiOperation(value = "Insert CaseExhibit", response = String.class)
    public ResponseEntity<?> insertCaseExhibit(@Valid @RequestBody ProcessCaseExhibitRequest request, BindingResult result, HttpServletRequest httpRequest) {
        return new ResponseEntity(sppCaseService.insertCaseExhibit(request, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @GetMapping("/searchInvestment")
    @ApiOperation(value="Search Investment By Case",response = List.class)
    public ResponseEntity<?> searchInvestment(@Valid @RequestParam String casecode){
        return new ResponseEntity(sppCaseService.searchInvestment(casecode), HttpStatus.OK);
    }

    @GetMapping("/getSppCase")
    @ApiOperation(value="Get sppcase by casecode", response = Object.class)
    public ResponseEntity<?> getfnc(@Valid @RequestParam String casecode){
        return new ResponseEntity<>(sppCaseService.getSppCaseByCaseCode(casecode), HttpStatus.OK);
    }

    @PostMapping("/searchListCaseLaw")
    @ApiOperation(value= "Search list caselaws",response = List.class)
    public ResponseEntity<?> getList (@Valid @RequestBody SppCaseLawSearchRequest req) {
        return new ResponseEntity(sppCaseService.searchListCaseLaw(req), HttpStatus.OK);
    }

}
