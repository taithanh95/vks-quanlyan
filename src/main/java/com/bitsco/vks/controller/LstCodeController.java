package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstCodeDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.entity.LstCode;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstCodeRequest;
import com.bitsco.vks.service.LstCodeService;
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

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 11/05/2022
 * Time: 3:37 PM
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/dm/LstCode")
public class LstCodeController {

    @Autowired
    private LstCodeService lstCodeService;


    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstCodeRequest lstCodeRequest) throws ApplicationException {
        List<LstCodeDTO> page = lstCodeService.search(lstCodeRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getROWCOUNT(), pageable.getPageNumber(), pageable.getPageSize(), page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstCodeRequest, pageable, "/dm/LstCode/getList", page.get(0).getROWCOUNT());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstCodeRequest, pageable, "/dm/LstCode/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/insertOrUpdate")
    @ApiOperation(value = "Insert Or Update", response = String.class)
    public ResponseEntity<?> insertUpdate(@Valid @RequestBody LstCode req, HttpServletRequest httpRequest) {
        return new ResponseEntity(lstCodeService.insertUpdate(req, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "delete", response = List.class)
    public ResponseEntity<?> delete(@Valid @RequestBody LstCode req) {
        return new ResponseEntity(lstCodeService.delete(req), HttpStatus.OK);
    }

    @GetMapping("/autocomplete/{query}")
    @ApiOperation(value = "Get list objects by query", response = List.class)
    public ResponseEntity<?> getListCode(@PathVariable String query){
        return new ResponseEntity(lstCodeService.autocomplete(query), HttpStatus.OK);
    }
}
