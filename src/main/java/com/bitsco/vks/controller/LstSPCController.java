package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstSPCSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.entity.LstCustoms;
import com.bitsco.vks.entity.LstSPC;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstSPCRequest;
import com.bitsco.vks.service.LstSPCService;
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
import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/dm/LstSPC")
public class LstSPCController {
    @Autowired
    private LstSPCService lstSPCService;
    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstSPCRequest lstSPCRequest) throws ApplicationException {
        List<LstSPCSearchDTO> page = lstSPCService.search(lstSPCRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getRowcount(),pageable.getPageNumber(),pageable.getPageSize(),page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstSPCRequest, pageable, "/dm/LstSPC/getList", page.get(0).getRowcount());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstSPCRequest, pageable, "/dm/LstSPC/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/autocomplete/{query}")
    @ApiOperation(value = "Get list objects by query", response = List.class)
    public ResponseEntity<?> getChildSPPs(@PathVariable String query){
        return new ResponseEntity(lstSPCService.autocomplete(query), HttpStatus.OK);
    }

    @GetMapping("/getfromspp/{query}")
    @ApiOperation(value = "Get list objects by spcid", response = List.class)
    public ResponseEntity<?> getLstById(@PathVariable String query){
        return new ResponseEntity(lstSPCService.getFromSpp(query),HttpStatus.OK);
    }

    @GetMapping("/getfromspp2022/{query}")
    @ApiOperation(value = "Get list objects by spcid", response = List.class)
    public ResponseEntity<?> getLstById2022(@PathVariable String query){
        return new ResponseEntity(lstSPCService.getFromSpp2022(query),HttpStatus.OK);
    }

    @GetMapping("/getid")
    @ApiOperation(value = "Get id", response = List.class)
    public ResponseEntity<?> getid(@RequestParam String spcid, @RequestParam Integer spclevel) {
        return new ResponseEntity(lstSPCService.getid(spcid, spclevel), HttpStatus.OK);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "Insert", response = String.class)
    public ResponseEntity<?> insert(@Valid @RequestBody LstSPC req, HttpServletRequest httpRequest) {
        return new ResponseEntity(lstSPCService.insert(req, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Update", response = String.class)
    public ResponseEntity<?> update(@Valid @RequestBody LstSPC req, HttpServletRequest httpRequest) {
        return new ResponseEntity(lstSPCService.update(req, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "delete", response = List.class)
    public ResponseEntity<?> delete(@Valid @RequestBody LstSPC req) {
        return new ResponseEntity(lstSPCService.delete(req), HttpStatus.OK);
    }

    @GetMapping("/getListSpc")
    @ApiOperation(value = "Get list SPC", response = List.class)
    public ResponseEntity<?> getListSpc(@RequestParam String query) throws SQLException {
        return new ResponseEntity(lstSPCService.getListSpc(query), HttpStatus.OK);
    }

    @GetMapping("/getTreeData")
    @ApiOperation(value = "get Tree Data", response = List.class)
    public ResponseEntity<?> getTreeData(@RequestParam String spcid, @RequestParam String level, @RequestParam String sppid) {
        return new ResponseEntity(lstSPCService.getFnFindTreeData(spcid,level,sppid),HttpStatus.OK);
    }
}
