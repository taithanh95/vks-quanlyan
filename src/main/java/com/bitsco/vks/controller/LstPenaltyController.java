package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstPenaltyDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.entity.LstPenalty;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstPenaltyRequest;
import com.bitsco.vks.service.LstPenaltyService;
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

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 17/05/2022
 * Time: 10:07 AM
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/dm/LstPenalty")
public class LstPenaltyController {
    @Autowired
    private LstPenaltyService lstPenaltyService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstPenaltyRequest lstPenaltyRequest) throws ApplicationException {
        List<LstPenaltyDTO> page = lstPenaltyService.search(lstPenaltyRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getROWCOUNT(), pageable.getPageNumber(), pageable.getPageSize(), page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstPenaltyRequest, pageable, "/dm/LstPenalty/getList", page.get(0).getROWCOUNT());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstPenaltyRequest, pageable, "/dm/LstPenalty/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/insertOrUpdate")
    @ApiOperation(value = "Insert Or Update", response = String.class)
    public ResponseEntity<?> insertUpdate(@Valid @RequestBody LstPenalty req, HttpServletRequest httpRequest) {
        return new ResponseEntity(lstPenaltyService.insertUpdate(req, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "delete", response = List.class)
    public ResponseEntity<?> delete(@Valid @RequestBody LstPenalty req) {
        return new ResponseEntity(lstPenaltyService.delete(req), HttpStatus.OK);
    }

    @GetMapping("/getListPenalty")
    @ApiOperation(value = "Get list Penalty", response = List.class)
    public ResponseEntity<?> getListSpp(@RequestParam String query) throws SQLException {
        return new ResponseEntity(lstPenaltyService.getListPenalty(query), HttpStatus.OK);
    }
}
