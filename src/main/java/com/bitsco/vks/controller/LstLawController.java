package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstLawSearchDTO;
import com.bitsco.vks.dto.LstRangerSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.entity.LstCustoms;
import com.bitsco.vks.entity.LstLaw;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstLawSearch1Request;
import com.bitsco.vks.models.LstRangerRequest;
import com.bitsco.vks.service.LstLawService;
import com.bitsco.vks.utils.PaginationUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/dm/LstLaw")
public class LstLawController {
    @Autowired
    private LstLawService lstLawService;

    @GetMapping("/autocomplete/{query}/{codeId}")
    @ApiOperation(value = "Get list objects by query", response = List.class)
    public ResponseEntity<?> getChildSPPs(@PathVariable String query, @PathVariable String codeId) throws SQLException {
        return new ResponseEntity(lstLawService.autocomplete(query, codeId), HttpStatus.OK);
    }
    @GetMapping("/search/{query}")
    @ApiOperation(value = "Get list objects by query", response = List.class)
    public ResponseEntity<?> search(@PathVariable String query) throws SQLException {
        return new ResponseEntity(lstLawService.search(query), HttpStatus.OK);
    }
    @GetMapping("/get/{lawcode}")
    @ApiOperation(value = "Get object by law code", response = LinkedCaseInsensitiveMap.class)
    public ResponseEntity<?> get(@PathVariable String lawcode) throws SQLException {
        return new ResponseEntity(lstLawService.get(lawcode), HttpStatus.OK);
    }

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstLawSearch1Request lstLawSearch1Request) throws ApplicationException {
        List<LstLawSearchDTO> page = lstLawService.searchLaw(pageable, lstLawSearch1Request);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getRowCount(), pageable.getPageNumber(), pageable.getPageSize(), page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstLawSearch1Request, pageable, "/dm/LstLaw/getList", page.get(0).getRowCount());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstLawSearch1Request, pageable, "/dm/LstLaw/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/insert")
    @ApiOperation(value = "Insert", response = String.class)
    public ResponseEntity<?> insert(@Valid @RequestBody LstLaw req, HttpServletRequest httpRequest) {
        return new ResponseEntity(lstLawService.insert(req, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Update", response = String.class)
    public ResponseEntity<?> update(@Valid @RequestBody LstLaw req, HttpServletRequest httpRequest) {
        return new ResponseEntity(lstLawService.update(req, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "delete", response = List.class)
    public ResponseEntity<?> delete(@Valid @RequestBody LstLaw req) {
        return new ResponseEntity(lstLawService.delete(req), HttpStatus.OK);
    }
}
