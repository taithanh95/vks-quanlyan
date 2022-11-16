package com.bitsco.vks.controller;

import com.bitsco.vks.dto.LstPoliceSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.entity.LstPolice;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstPoliceSearchRequest;
import com.bitsco.vks.service.LstPoliceService;
import com.bitsco.vks.utils.PaginationUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/dm/LstPolice")
public class LstPoliceController {
    @Autowired
    private LstPoliceService lstPoliceService;

    @GetMapping("/autocomplete/{query}")
    @ApiOperation(value = "Get list objects by query", response = List.class)
    public ResponseEntity<?> getChildSPPs(@PathVariable String query){
        return new ResponseEntity(lstPoliceService.autocomplete(query), HttpStatus.OK);

    }
    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstPoliceSearchRequest lstPoliceSearchRequest) throws ApplicationException {
        List<LstPoliceSearchDTO> page = lstPoliceService.search(pageable, lstPoliceSearchRequest);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getRowCount(), pageable.getPageNumber(), pageable.getPageSize(), page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstPoliceSearchRequest, pageable, "/dm/LstPolice/getList", page.get(0).getRowCount());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstPoliceSearchRequest, pageable, "/dm/LstPolice/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/getNameBySppId/{sppid}")
    @ApiOperation(value = "Get Name By SppId", response = Object.class)
    public ResponseEntity<Object> getChildSPPs(@PathVariable Long sppid){
        return new ResponseEntity<>(lstPoliceService.findPoliceBySppId(sppid), HttpStatus.OK);

    }
    @GetMapping("/getfromspp")
    @ApiOperation(value = "Get list from spp", response = LstPolice.class)
    public ResponseEntity<?> getfromspp(@Valid @RequestParam String sppid) throws ApplicationException {
        return new ResponseEntity(lstPoliceService.getfromspp(sppid), HttpStatus.OK);
    }
    @PostMapping("/insert")
    @ApiOperation(value = "Insert new border guard", response = String.class)
    public ResponseEntity<?> insert(@Valid @RequestBody LstPolice request, BindingResult result) {
        return new ResponseEntity(lstPoliceService.insert(request), HttpStatus.OK);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Update border guard", response = String.class)
    public ResponseEntity<?> update(@Valid @RequestBody LstPolice request, BindingResult result) {
        return new ResponseEntity(lstPoliceService.update(request), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "Delete border guard", response = String.class)
    public ResponseEntity<?> delete(@Valid @RequestBody LstPolice request, BindingResult result){
        return new ResponseEntity(lstPoliceService.delete(request), HttpStatus.OK);
    }

    @GetMapping("/getid")
    @ApiOperation(value = "GET ID", response = String.class)
    public ResponseEntity<?> getid(@RequestParam @Valid String sppid, @RequestParam @Valid Integer spplevel){
        return new ResponseEntity(lstPoliceService.getid(sppid,spplevel), HttpStatus.OK);
    }

    @GetMapping("/getTreeData")
    @ApiOperation(value = "get Tree Data", response = List.class)
    public ResponseEntity<?> getTreeData(@RequestParam String id, @RequestParam String level, @RequestParam String sppid) {
        return new ResponseEntity(lstPoliceService.getFnFindTreeData(id, level, sppid), HttpStatus.OK);
    }

    @GetMapping("/getPoliceByQuery")
    @ApiOperation(value = "Get Country by query", response = Class.class)
    public ResponseEntity<?> getPoliceLst(@RequestParam String query) {
        return new ResponseEntity(lstPoliceService.getPoliceLst(query), HttpStatus.OK);
    }
}
