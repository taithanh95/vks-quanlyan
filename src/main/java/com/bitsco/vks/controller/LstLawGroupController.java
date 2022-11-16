package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstLawGroupDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.entity.LstLawGroup;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstLawGroupRequest;
import com.bitsco.vks.service.LstLawGroupService;
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
 * Date: 12/05/2022
 * Time: 9:37 AM
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/dm/LstLawGroup")
public class LstLawGroupController {

    @Autowired
    private LstLawGroupService lstLawGroupService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstLawGroupRequest lstLawGroupRequest) throws ApplicationException {
        List<LstLawGroupDTO> page = lstLawGroupService.search(lstLawGroupRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getROWCOUNT(), pageable.getPageNumber(), pageable.getPageSize(), page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstLawGroupRequest, pageable, "/dm/LstLawGroup/getList", page.get(0).getROWCOUNT());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstLawGroupRequest, pageable, "/dm/LstLawGroup/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/insertOrUpdate")
    @ApiOperation(value = "Insert Or Update", response = String.class)
    public ResponseEntity<?> insertUpdate(@Valid @RequestBody LstLawGroup req, HttpServletRequest httpRequest) {
        return new ResponseEntity(lstLawGroupService.insertUpdate(req, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "delete", response = List.class)
    public ResponseEntity<?> delete(@Valid @RequestBody LstLawGroup req) {
        return new ResponseEntity(lstLawGroupService.delete(req), HttpStatus.OK);
    }
}
