package com.bitsco.vks.controller;

import com.bitsco.vks.dto.LstLawPenaltyDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.entity.LstLawPenalty;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstLawPenaltyRequest;
import com.bitsco.vks.service.LstLawPenaltyService;
import com.bitsco.vks.utils.PaginationUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 17/05/2022
 * Time: 2:07 PM
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/dm/LstLawPenalty")
public class LstLawPenaltyController {
    @Autowired
    private LstLawPenaltyService lstLawPenaltyService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstLawPenaltyRequest lstLawPenaltyRequest) throws ApplicationException {
        List<LstLawPenaltyDTO> page = lstLawPenaltyService.search(lstLawPenaltyRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getROWCOUNT(), pageable.getPageNumber(), pageable.getPageSize(), page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstLawPenaltyRequest, pageable, "/dm/LstLawPenalty/getList", page.get(0).getROWCOUNT());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstLawPenaltyRequest, pageable, "/dm/LstLawPenalty/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/insertOrUpdate")
    @ApiOperation(value = "Insert Or Update", response = String.class)
    public ResponseEntity<?> insertUpdate(@Valid @RequestBody LstLawPenalty req) {
        return new ResponseEntity(lstLawPenaltyService.insertUpdate(req), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "delete", response = List.class)
    public ResponseEntity<?> delete(@Valid @RequestBody LstLawPenalty req) {
        return new ResponseEntity(lstLawPenaltyService.delete(req), HttpStatus.OK);
    }
}
