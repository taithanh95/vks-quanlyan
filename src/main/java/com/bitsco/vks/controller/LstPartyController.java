package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstPartySearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.entity.LstParty;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstPartyRequest;
import com.bitsco.vks.service.LstPartyService;
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

@RestController
@CrossOrigin
@RequestMapping(value = "/dm/LstParty")
public class LstPartyController {
    @Autowired
    private LstPartyService lstPartyService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstPartyRequest lstPartyRequest) throws ApplicationException {
        List<LstPartySearchDTO> page = lstPartyService.search(lstPartyRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getROWCOUNT(), pageable.getPageNumber(), pageable.getPageSize(), page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstPartyRequest, pageable, "/dm/LstParty/getList", page.get(0).getROWCOUNT());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstPartyRequest, pageable, "/dm/LstParty/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/insertOrUpdate")
    @ApiOperation(value = "Insert Or Update", response = String.class)
    public ResponseEntity<?> insertUpdate(@Valid @RequestBody LstParty req, HttpServletRequest httpRequest) {
        return new ResponseEntity(lstPartyService.insertUpdate(req, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "delete", response = List.class)
    public ResponseEntity<?> delete(@Valid @RequestBody LstParty req) {
        return new ResponseEntity(lstPartyService.delete(req), HttpStatus.OK);
    }
}
