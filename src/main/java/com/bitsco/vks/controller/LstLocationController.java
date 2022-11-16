package com.bitsco.vks.controller;

import com.bitsco.vks.dto.LstLocationSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.entity.LstBorderGuards;
import com.bitsco.vks.entity.LstLocation;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstLocationRequest;
import com.bitsco.vks.service.LstLocationService;
import com.bitsco.vks.utils.PaginationUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@CrossOrigin
@RequestMapping(value = "/dm/LstLocation")
public class LstLocationController {
    @Autowired
    private LstLocationService lstLocationService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstLocationRequest lstLocationRequest) throws ApplicationException {
        List<LstLocationSearchDTO> page = lstLocationService.search(lstLocationRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getROWCOUNT(), pageable.getPageNumber(), pageable.getPageSize(), page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstLocationRequest, pageable, "/dm/LstLocation/getList", page.get(0).getROWCOUNT());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstLocationRequest, pageable, "/dm/LstLocation/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/autocomplete/{query}")
    @ApiOperation(value = "Get list objects by query", response = List.class)
    public ResponseEntity<?> getChildSPPs(@PathVariable String query){
        return new ResponseEntity(lstLocationService.autocomplete(query), HttpStatus.OK);

    }

    @GetMapping("/autocomplete2/{query}&{level}")
    @ApiOperation(value = "Get list objects by query", response = List.class)
    public ResponseEntity<?> getChildSPPs2(@PathVariable String query, @PathVariable Integer level){
        return new ResponseEntity(lstLocationService.autocomplete2(query, level), HttpStatus.OK);

    }

    @GetMapping("/getLocationId/{id}")
    @ApiOperation(value="Get Location by locaId", response = Object.class)
    public ResponseEntity<?> getLocaById(@PathVariable String id){
        return new ResponseEntity(lstLocationService.getLocationById(id),HttpStatus.OK);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "Insert new border guard", response = String.class)
    public ResponseEntity<?> insert(@Valid @RequestBody LstLocation request, BindingResult result) {
        return new ResponseEntity(lstLocationService.insert(request), HttpStatus.OK);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Update border guard", response = String.class)
    public ResponseEntity<?> update(@Valid @RequestBody LstLocation request, BindingResult result) {
        return new ResponseEntity(lstLocationService.update(request), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "Delete border guard", response = String.class)
    public ResponseEntity<?> delete(@Valid @RequestBody LstLocation request, BindingResult result) throws Exception {
        return new ResponseEntity(lstLocationService.delete(request), HttpStatus.OK);
    }

    @GetMapping("/getid")
    @ApiOperation(value = "GET ID", response = String.class)
    public ResponseEntity<?> getid(@RequestParam @Valid String locaid, @RequestParam @Valid Integer localevel){
        return new ResponseEntity(lstLocationService.getid(locaid,localevel), HttpStatus.OK);
    }

    @GetMapping("/getTreeData")
    @ApiOperation(value = "get Tree Data", response = List.class)
    public ResponseEntity<?> getTreeData(@RequestParam String locaid, @RequestParam String localevel, @RequestParam String sppid) {
        return new ResponseEntity(lstLocationService.getFnFindTreeData(locaid, localevel, sppid), HttpStatus.OK);
    }
}
