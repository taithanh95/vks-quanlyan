package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstCustomsSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.entity.LstCustoms;
import com.bitsco.vks.entity.LstParty;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstCustomsRequest;
import com.bitsco.vks.service.LstCustomsService;
import com.bitsco.vks.utils.Md5;
import com.bitsco.vks.utils.PaginationUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
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
@RequestMapping(value = "/dm/LstCustoms")
public class LstCustomsController {
    @Autowired
    private LstCustomsService lstCustomsService;

//    @GetMapping("/getList")
//    @ApiOperation(value = "Get list", response = List.class)
//    public ResponseEntity<?> getList(@RequestParam(value = "rowIndex", defaultValue = "0") Integer rowIndex,
//                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
//                                     @RequestParam(value = "sortField", defaultValue = "customid") String sortField,
//                                     @RequestParam(value = "sortOrder", defaultValue = "ASC") String sortOrder,
//                                     @RequestParam(value = "sppid", required = false) String sppid,
//                                     @RequestParam(value = "name", required = false) String name,
//                                     @RequestParam(value = "addr", required = false) String addr,
//                                     @RequestParam(value = "tel", required = false) String tel,
//                                     @RequestParam(value = "fax", required = false) String fax,
//                                     @RequestParam(value = "spcid", required = false) String spcid
//    ) {
//        return new ResponseEntity(lstCustomsService.search(rowIndex, pageSize, sortField, sortOrder, sppid, name, addr, tel, fax, spcid), HttpStatus.OK);
//    }

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstCustomsRequest lstCustomsRequest) throws ApplicationException {
        List<LstCustomsSearchDTO> page = lstCustomsService.search(lstCustomsRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getROWCOUNT(),pageable.getPageNumber(),pageable.getPageSize(),page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstCustomsRequest, pageable, "/dm/LstCustoms/getList", page.get(0).getROWCOUNT());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstCustomsRequest, pageable, "/dm/LstCustoms/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/autocomplete/{query}")
    @ApiOperation(value = "Get list objects by query", response = List.class)
    public ResponseEntity<?> getChildSPPs(@PathVariable String query) {
        return new ResponseEntity(lstCustomsService.autocomplete(query), HttpStatus.OK);
    }

    @GetMapping("/getid")
    @ApiOperation(value = "Get id", response = List.class)
    public ResponseEntity<?> getid(@RequestParam String sppid, @RequestParam Integer spplevel) {
        return new ResponseEntity(lstCustomsService.getid(sppid, spplevel), HttpStatus.OK);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "Insert", response = String.class)
    public ResponseEntity<?> insert(@Valid @RequestBody LstCustoms req, HttpServletRequest httpRequest) {
        return new ResponseEntity(lstCustomsService.insert(req, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Update", response = String.class)
    public ResponseEntity<?> update(@Valid @RequestBody LstCustoms req, HttpServletRequest httpRequest) {
        return new ResponseEntity(lstCustomsService.update(req, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "delete", response = List.class)
    public ResponseEntity<?> delete(@Valid @RequestBody LstCustoms req) {
        return new ResponseEntity(lstCustomsService.delete(req), HttpStatus.OK);
    }

    @GetMapping("/getTreeData")
    @ApiOperation(value = "Get Tree Data", response = List.class)
    public ResponseEntity<?> getTreeData(@RequestParam String id, @RequestParam String level, @RequestParam String sppid) throws ApplicationException {
        return new ResponseEntity(lstCustomsService.getFnFindTreeData(id, level,sppid), HttpStatus.OK);
    }

    @GetMapping("/getCustomsBySppId")
    @ApiOperation(value = "getCustomsBySppId", response = List.class)
    public ResponseEntity<?> getCustomsBySppId(@RequestParam String sppid) throws ApplicationException {
        return new ResponseEntity(lstCustomsService.getCustomsBySppId(sppid), HttpStatus.OK);
    }
}
