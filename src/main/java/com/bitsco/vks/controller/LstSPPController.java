package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstSPPSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.entity.LstSPC;
import com.bitsco.vks.entity.LstSPP;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstSppSearchRequest;
import com.bitsco.vks.service.SppService;
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
@RequestMapping(value = "/dm/LstSPP")
@CrossOrigin("*")
public class LstSPPController {
    @Autowired
    private SppService sppService;

    @GetMapping("/autocomplete/{query}")
    @ApiOperation(value = "Get list objects by query", response = List.class)
    public ResponseEntity<?> getChildSPPs(@PathVariable String query) throws SQLException {
        return new ResponseEntity(sppService.autocomplete(query), HttpStatus.OK);
    }
    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstSppSearchRequest lstSppSearchRequest) throws ApplicationException {
        List<LstSPPSearchDTO> page = sppService.search(pageable, lstSppSearchRequest);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getRowCount(), pageable.getPageNumber(), pageable.getPageSize(), page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstSppSearchRequest, pageable, "/dm/LstSPP/getList", page.get(0).getRowCount());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstSppSearchRequest, pageable, "/dm/LstSPP/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/getNameBySppId/{sppId}")
    @ApiOperation(value = "Get name by spp id", response = List.class)
    public ResponseEntity<Object> getNameBySppId(@PathVariable Long sppId) {
        return new ResponseEntity<>(sppService.findNameSppBySppId(sppId), HttpStatus.OK);
    }

    @GetMapping("{sppId}")
    @ApiOperation(value = "Get SPP by SPPID")
    public ResponseEntity<?> getSpp(@PathVariable("sppId") String sppId) {
        return new ResponseEntity<>(sppService.getSPP(sppId), HttpStatus.OK);
    }
    @GetMapping("/spps/{id}")
    @ApiOperation(value = "Get list children SPP", response = List.class)
    public ResponseEntity<?> getChildrenSPPs(@PathVariable String id) {
        return new ResponseEntity(sppService.getChildSPPs(id), HttpStatus.OK);

    }

    @GetMapping("/autocompleteForChangeInsp/{query}/{sppid}")
    @ApiOperation(value = "Get list objects by query", response = List.class)
    public ResponseEntity<?> getChildSPPForChangeInsp(@PathVariable String query, @PathVariable String sppid) throws SQLException {
        return new ResponseEntity(sppService.autocompleteForChangeInsp(query, sppid), HttpStatus.OK);
    }

    @GetMapping("/getListSpp")
    @ApiOperation(value = "Get list SPP", response = List.class)
    public ResponseEntity<?> getListSpp(@RequestParam String query, @RequestParam String sppid) throws SQLException {
        return new ResponseEntity(sppService.getListSpp(query, sppid), HttpStatus.OK);
    }

    @GetMapping("/getid")
    @ApiOperation(value = "Get id", response = List.class)
    public ResponseEntity<?> getid(@RequestParam String sppid, @RequestParam Integer spplevel) {
        return new ResponseEntity(sppService.getid(sppid, spplevel), HttpStatus.OK);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "Insert", response = String.class)
    public ResponseEntity<?> insert(@Valid @RequestBody LstSPP req, HttpServletRequest httpRequest) {
        return new ResponseEntity(sppService.insert(req, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Update", response = String.class)
    public ResponseEntity<?> update(@Valid @RequestBody LstSPP req, HttpServletRequest httpRequest) {
        return new ResponseEntity(sppService.update(req, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "delete", response = List.class)
    public ResponseEntity<?> delete(@Valid @RequestBody LstSPP req) {
        return new ResponseEntity(sppService.delete(req), HttpStatus.OK);
    }

    @GetMapping("/getBySppid")
    @ApiOperation(value = "Get Spp by Sppid", response = Class.class)
    public ResponseEntity<?> getid(@RequestParam String sppid) {
        return new ResponseEntity(sppService.getBySppid(sppid), HttpStatus.OK);
    }

    @GetMapping("/getSpps")
    @ApiOperation(value = "Get Spp by Sppid and query", response = Class.class)
    public ResponseEntity<?> getSpps(@RequestParam String sppid, @RequestParam String query) {
        return new ResponseEntity(sppService.getSpps(sppid,query), HttpStatus.OK);
    }

    @GetMapping("/getTreeData")
    @ApiOperation(value = "get Tree Data", response = List.class)
    public ResponseEntity<?> getTreeData(@RequestParam String id, @RequestParam String level, @RequestParam String sppid) {
        return new ResponseEntity(sppService.getFnFindTreeData(id, level, sppid), HttpStatus.OK);
    }
}
