package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstCountrySearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstCountryRequest;
import com.bitsco.vks.service.LstCountryService;
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
@RequestMapping(value = "/dm/LstCountry")
public class LstCountryController {
    @Autowired
    private LstCountryService lstCountryService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstCountryRequest lstCountryRequest) throws ApplicationException {
        List<LstCountrySearchDTO> page = lstCountryService.search(lstCountryRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getROWCOUNT(),pageable.getPageNumber(),pageable.getPageSize(),page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstCountryRequest, pageable, "/dm/LstCountry/getList", page.get(0).getROWCOUNT());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstCountryRequest, pageable, "/dm/LstCountry/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/save")
    @ApiOperation(value="/handle insert or update country", response = String.class)
    public ResponseEntity<?> save(@RequestBody LstCountryRequest req, HttpServletRequest http) {
        return new ResponseEntity<>(lstCountryService.save(req, http.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value="/handle delete country by counid ", response = String.class)
    public ResponseEntity<?> delete(@RequestParam String counid) {
        return new ResponseEntity<>(lstCountryService.delete(counid), HttpStatus.OK);
    }

    @GetMapping("/getCountry")
    @ApiOperation(value = "Get Country by query", response = Class.class)
    public ResponseEntity<?> getCountry(@RequestParam String query) {
        return new ResponseEntity(lstCountryService.getCountry(query), HttpStatus.OK);
    }
}
