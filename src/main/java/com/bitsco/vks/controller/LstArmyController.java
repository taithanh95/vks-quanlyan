package com.bitsco.vks.controller;

import com.bitsco.vks.dto.LstArmySearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.entity.LstArmyEntity;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstArmyRequest;
import com.bitsco.vks.service.LstArmyService;
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
@CrossOrigin
@RequestMapping(value = "/dm/LstArmy")
public class LstArmyController {
    @Autowired
    private LstArmyService lstArmyService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstArmyRequest lstArmyRequest) throws ApplicationException {
        List<LstArmySearchDTO> page = lstArmyService.search(lstArmyRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getRowcount(),pageable.getPageNumber(),pageable.getPageSize(),page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstArmyRequest, pageable, "/dm/LstArmy/getList", page.get(0).getRowcount());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstArmyRequest, pageable, "/dm/LstArmy/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/autocomplete/{query}")
    @ApiOperation(value = "Get list objects by query", response = List.class)
    public ResponseEntity<?> getChildSPPs(@PathVariable String query) {
        return new ResponseEntity(lstArmyService.autocomplete(query), HttpStatus.OK);

    }
    @PostMapping("/insert")
    @ApiOperation(value = "Insert new border guard", response = String.class)
    public ResponseEntity<?> insert(@Valid @RequestBody LstArmyEntity request, BindingResult result) {
        return new ResponseEntity(lstArmyService.insert(request), HttpStatus.OK);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Update border guard", response = String.class)
    public ResponseEntity<?> update(@Valid @RequestBody LstArmyEntity request, BindingResult result) {
        return new ResponseEntity(lstArmyService.update(request), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "Delete border guard", response = String.class)
    public ResponseEntity<?> delete(@Valid @RequestBody LstArmyEntity request, BindingResult result) throws Exception {
        return new ResponseEntity(lstArmyService.delete(request), HttpStatus.OK);
    }

    @GetMapping("/getid")
    @ApiOperation(value = "GET ID", response = String.class)
    public ResponseEntity<?> getid(@RequestParam @Valid String sppid, @RequestParam @Valid Integer spplevel){
        return new ResponseEntity(lstArmyService.getid(sppid,spplevel), HttpStatus.OK);
    }

    @GetMapping("/getTreeData")
    @ApiOperation(value = "get Tree Data", response = List.class)
    public ResponseEntity<?> getTreeData(@RequestParam String id, @RequestParam String level, @RequestParam String sppid){
        return new ResponseEntity(lstArmyService.getFnFindTreeData(id, level, sppid),HttpStatus.OK);
    }

    @GetMapping("/getArmyBySppId")
    @ApiOperation(value = "getArmyBySppId", response = List.class)
    public ResponseEntity<?> getArmyBySppId(@RequestParam String sppid){
        return new ResponseEntity(lstArmyService.getArmyBySppId(sppid),HttpStatus.OK);
    }
}
