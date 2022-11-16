package com.bitsco.vks.controller;

import com.bitsco.vks.dto.LstBorderGuardsSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.entity.LstBorderGuards;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.*;
import com.bitsco.vks.service.LstBorderGuardsService;
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
@RequestMapping(value="/dm/LstBorderGuards")
public class LstBorderGuardsController {
    @Autowired
    private LstBorderGuardsService lstBorderGuardsService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstBorderGuardsRequest lstBorderGuardsRequest) throws ApplicationException {
        List<LstBorderGuardsSearchDTO> page = lstBorderGuardsService.search(lstBorderGuardsRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getROWCOUNT(),pageable.getPageNumber(),pageable.getPageSize(),page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstBorderGuardsRequest, pageable, "/dm/LstBorderGuards/getList", page.get(0).getROWCOUNT());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstBorderGuardsRequest, pageable, "/dm/LstBorderGuards/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/insert")
    @ApiOperation(value = "Insert new border guard", response = String.class)
    public ResponseEntity<?> insert(@Valid @RequestBody LstBorderGuards request, BindingResult result) {
        return new ResponseEntity(lstBorderGuardsService.insert(request), HttpStatus.OK);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Update border guard", response = String.class)
    public ResponseEntity<?> update(@Valid @RequestBody LstBorderGuards request, BindingResult result) {
        return new ResponseEntity(lstBorderGuardsService.update(request), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "Delete border guard", response = String.class)
    public ResponseEntity<?> delete(@Valid @RequestBody LstBorderGuards request, BindingResult result){
        return new ResponseEntity(lstBorderGuardsService.delete(request), HttpStatus.OK);
    }

    @GetMapping("/autocomplete/{query}")
    @ApiOperation(value = "Get list objects by query", response = List.class)
    public ResponseEntity<?> getChildSPPs(@PathVariable String query) {
        return new ResponseEntity(lstBorderGuardsService.autocomplete(query), HttpStatus.OK);

    }

    @GetMapping("/getid")
    @ApiOperation(value = "GET ID", response = String.class)
    public ResponseEntity<?> getid(@RequestParam @Valid String sppid, @RequestParam @Valid Integer spplevel){
        return new ResponseEntity(lstBorderGuardsService.getid(sppid,spplevel), HttpStatus.OK);
    }

    @GetMapping("/getTreeData")
    @ApiOperation(value = "get Tree Data", response = List.class)
    public ResponseEntity<?> getTreeData(@RequestParam String id, @RequestParam String level, @RequestParam String sppid) {
        return new ResponseEntity(lstBorderGuardsService.getFnFindTreeData(id, level, sppid), HttpStatus.OK);
    }

    @GetMapping("/getBorderGuardsBySppId")
    @ApiOperation(value = "getBorderGuardsBySppId", response = List.class)
    public ResponseEntity<?> getBorderGuardsBySppId(@RequestParam String sppid) {
        return new ResponseEntity(lstBorderGuardsService.getBorderGuardsBySppId(sppid), HttpStatus.OK);
    }
}
