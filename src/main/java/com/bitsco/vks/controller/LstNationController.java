package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstNationSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstNationRequest;
import com.bitsco.vks.service.LstNationService;
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
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/dm/LstNation")
public class LstNationController {
    @Autowired
    private LstNationService lstNationService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstNationRequest lstNationRequest) throws ApplicationException {
        List<LstNationSearchDTO> page = lstNationService.search(lstNationRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getROWCOUNT(), pageable.getPageNumber(), pageable.getPageSize(), page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstNationRequest, pageable, "/dm/LstNation/getList", page.get(0).getROWCOUNT());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstNationRequest, pageable, "/dm/LstNation/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/save")
    @ApiOperation(value="/handle insert or update nation", response = String.class)
    public ResponseEntity<?> save(@RequestBody LstNationRequest req, HttpServletRequest http) {
        return new ResponseEntity<>(lstNationService.save(req, http.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value="/handle delete nation by natiId ", response = String.class)
    public ResponseEntity<?> delete(@RequestParam String natiid) {
        return new ResponseEntity<>(lstNationService.delete(natiid), HttpStatus.OK);
    }

    @GetMapping("/getNation")
    @ApiOperation(value = "Get Nation by query", response = Class.class)
    public ResponseEntity<?> getNation(@RequestParam String query) {
        return new ResponseEntity(lstNationService.getNation(query), HttpStatus.OK);
    }
}
