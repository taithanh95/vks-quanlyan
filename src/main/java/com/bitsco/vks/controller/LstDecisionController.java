package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstDecisionSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstDecisionRequest;
import com.bitsco.vks.models.LstDecisionSaveRequest;
import com.bitsco.vks.service.LstDecisionService;
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
@RequestMapping(value = "/dm/LstDecision")
public class LstDecisionController {
    @Autowired
    private LstDecisionService lstDecisionService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstDecisionRequest lstDecisionRequest) throws ApplicationException {
        List<LstDecisionSearchDTO> page = lstDecisionService.search(lstDecisionRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getROWCOUNT(), pageable.getPageNumber(), pageable.getPageSize(), page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstDecisionRequest, pageable, "/dm/LstDecision/getList", page.get(0).getROWCOUNT());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstDecisionRequest, pageable, "/dm/LstDecision/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/getListApplyForTBTG")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getListApplyForTBTG(@PageableDefault(size = 10) Pageable pageable, String search,
                                                 @RequestParam(name = "sortFields", defaultValue = "deciname") String sortFields,
                                                 @RequestParam(name = "sortOrder", defaultValue = "ASC") String sortOrder) throws ApplicationException {
        List<LstDecisionSearchDTO> page = lstDecisionService.getListApplyForTBTG(pageable, search, sortFields, sortOrder);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getROWCOUNT(), pageable.getPageNumber(), pageable.getPageSize(), page);
            return new ResponseEntity<>(pageDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/searchForHS")
    @ApiOperation(value = "Get list for HS", response = List.class)
    public ResponseEntity<?> searchForHS(@Valid @RequestParam String usefor, @Valid @RequestParam String applyfor, @Valid @RequestParam String decitype) throws ApplicationException {
        return new ResponseEntity(lstDecisionService.searchForHS(usefor, applyfor, decitype), HttpStatus.OK);
    }

    @GetMapping("/getDecisionById")
    @ApiOperation(value = "Get decision by id", response = List.class)
    public ResponseEntity<?> getDecisionById(@Valid @RequestParam String deciid){
        return new ResponseEntity(lstDecisionService.getDecisionById(deciid), HttpStatus.OK);
    }

    @GetMapping("/autocomplete")
    @ApiOperation(value = "Get decision by query", response = List.class)
    public ResponseEntity<?> getAutocomplete(@RequestParam String query){
        return new ResponseEntity(lstDecisionService.autocomplete(query), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value="handle insert or update decision", response = String.class)
    public ResponseEntity<?> save(@RequestBody LstDecisionSaveRequest req, HttpServletRequest http) {
        return new ResponseEntity<>(lstDecisionService.save(req, http.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value="handle delete by deciid", response = String.class)
    public ResponseEntity<?> delete(@RequestParam String deciid) {
        return new ResponseEntity<>(lstDecisionService.delete(deciid), HttpStatus.OK);
    }

    @GetMapping("/find")
    @ApiOperation(value="handle find for TreeData", response = String.class)
    public ResponseEntity<?> fnFind(@RequestParam String deciid, @RequestParam String decilevel) {
        return new ResponseEntity<>(lstDecisionService.findTreeData(deciid,decilevel), HttpStatus.OK);
    }
}
