package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstPrisonSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.entity.LstPrison;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstPrisonRequest;
import com.bitsco.vks.service.LstPrisonService;
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
@RequestMapping(value = "/dm/LstPrison")
public class LstPrisonController {
    @Autowired
    private LstPrisonService lstPrisonService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstPrisonRequest lstPrisonRequest) throws ApplicationException {
        List<LstPrisonSearchDTO> page = lstPrisonService.search(lstPrisonRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getROWCOUNT(),pageable.getPageNumber(),pageable.getPageSize(),page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstPrisonRequest, pageable, "/dm/LstPrison/getList", page.get(0).getROWCOUNT());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstPrisonRequest, pageable, "/dm/LstPrison/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/insertOrUpdate")
    @ApiOperation(value = "Insert Or Update", response = String.class)
    public ResponseEntity<?> insertUpdate(@Valid @RequestBody LstPrison req, HttpServletRequest httpRequest) {
        return new ResponseEntity(lstPrisonService.insertUpdate(req, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }
    @PostMapping("/delete")
    @ApiOperation(value = "delete", response = List.class)
    public ResponseEntity<?> delete(@Valid @RequestBody LstPrison req) {
        return new ResponseEntity(lstPrisonService.delete(req), HttpStatus.OK);
    }
}
