package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstPolSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.entity.LstPol;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstPolRequest;
import com.bitsco.vks.service.LstPolService;
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
@RequestMapping(value = "/dm/LstPol")
public class LstPolController {
    @Autowired
    private LstPolService lstPolService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstPolRequest lstPolRequest) throws ApplicationException {
        List<LstPolSearchDTO> page = lstPolService.search(lstPolRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getROWCOUNT(),pageable.getPageNumber(),pageable.getPageSize(),page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstPolRequest, pageable, "/dm/LstPol/getList", page.get(0).getROWCOUNT());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstPolRequest, pageable, "/dm/LstPol/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "Get All list", response = List.class)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity(lstPolService.getAll(),HttpStatus.OK);
    }
    @PostMapping("/insertOrUpdate")
    @ApiOperation(value = "Insert Or Update", response = String.class)
    public ResponseEntity<?> insertUpdate(@Valid @RequestBody LstPol req, HttpServletRequest httpRequest) {
        return new ResponseEntity(lstPolService.insertUpdate(req, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }
    @PostMapping("/delete")
    @ApiOperation(value = "delete", response = List.class)
    public ResponseEntity<?> delete(@Valid @RequestBody LstPol req) {
        return new ResponseEntity(lstPolService.delete(req), HttpStatus.OK);
    }
}
