package com.bitsco.vks.controller;


import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.SaveSppRegisterRequest;
import com.bitsco.vks.models.SppRegisterSearchRequest;
import com.bitsco.vks.models.SppSpcPolSaveRequest;
import com.bitsco.vks.models.SppSpcPolSearchRequest;
import com.bitsco.vks.service.SppSpcPolService;
import com.bitsco.vks.utils.PaginationUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/SppSpcPol")
public class SppSpcPolController {
    @Autowired
    private SppSpcPolService sppSpcPolService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     SppSpcPolSearchRequest sppSpcPolSearchRequest) throws ApplicationException {
        List<LinkedCaseInsensitiveMap> page = sppSpcPolService.search(sppSpcPolSearchRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(((Number) page.get(0).get("ROWCOUNT")).longValue(),pageable.getPageNumber(),pageable.getPageSize(),page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(sppSpcPolSearchRequest, pageable, "/SppSpcPol/getList", ((Number) page.get(0).get("ROWCOUNT")).longValue()); //page.get(0).ROWCOUNT
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(sppSpcPolSearchRequest, pageable, "/SppSpcPol/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "Save SppSpcPol", response = String.class)
    public ResponseEntity<?> insert(@Valid @RequestBody SppSpcPolSaveRequest request, BindingResult result) {
        return new ResponseEntity<>(sppSpcPolService.SaveSppSpcPol(request), HttpStatus.OK);
    }
}
