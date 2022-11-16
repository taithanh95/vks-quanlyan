package com.bitsco.vks.controller;

import com.bitsco.vks.dto.LstRangerSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.entity.LstRanger;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstRangerRequest;
import com.bitsco.vks.service.LstRangerService;
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
@RequestMapping(value = "/dm/LstRanger")
public class LstRangerController {
    @Autowired
    private LstRangerService lstRangerService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstRangerRequest lstRangerRequest) throws ApplicationException {
        List<LstRangerSearchDTO> page = lstRangerService.search(lstRangerRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getRowcount(),pageable.getPageNumber(),pageable.getPageSize(),page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstRangerRequest, pageable, "/dm/LstRanger/getList", page.get(0).getRowcount());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstRangerRequest, pageable, "/dm/LstRanger/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/autocomplete/{query}")
    @ApiOperation(value = "Get list objects by query", response = List.class)
    public ResponseEntity<?> getChildSPPs(@PathVariable String query){
        return new ResponseEntity(lstRangerService.autocomplete(query), HttpStatus.OK);

    }
    @PostMapping("/insert")
    @ApiOperation(value = "Insert new border guard", response = String.class)
    public ResponseEntity<?> insert(@Valid @RequestBody LstRanger request, BindingResult result) {
        return new ResponseEntity(lstRangerService.insert(request), HttpStatus.OK);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Update border guard", response = String.class)
    public ResponseEntity<?> update(@Valid @RequestBody LstRanger request, BindingResult result) {
        return new ResponseEntity(lstRangerService.update(request), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "Delete border guard", response = String.class)
    public ResponseEntity<?> delete(@Valid @RequestBody LstRanger request, BindingResult result) throws Exception {
        return new ResponseEntity(lstRangerService.delete(request), HttpStatus.OK);
    }

    @GetMapping("/getid")
    @ApiOperation(value = "GET ID", response = String.class)
    public ResponseEntity<?> getid(@RequestParam @Valid String sppid, @RequestParam @Valid Integer spplevel){
        return new ResponseEntity(lstRangerService.getid(sppid,spplevel), HttpStatus.OK);
    }

    @GetMapping("/getTreeData")
    @ApiOperation(value = "get Tree Data", response = List.class)
    public ResponseEntity<?> getTreeData(@RequestParam String id, @RequestParam String level, @RequestParam String sppid){
        return new ResponseEntity(lstRangerService.getFnFindTreeData(id, level, sppid), HttpStatus.OK);
    }

    @GetMapping("/getRangerBySppId")
    @ApiOperation(value = "getRangerBySppId", response = List.class)
    public ResponseEntity<?> getRangerBySppId(@RequestParam String sppid){
        return new ResponseEntity(lstRangerService.getRangerBySppId(sppid), HttpStatus.OK);
    }
}
