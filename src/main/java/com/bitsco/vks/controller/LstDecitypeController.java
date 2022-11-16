package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstDecitypeSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstDecitypeRequest;
import com.bitsco.vks.service.LstDecitypeService;
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
@RequestMapping(value = "/dm/LstDecitype")
public class LstDecitypeController {
    @Autowired
    private LstDecitypeService lstDecitypeService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstDecitypeRequest LstDecitypeRequest) throws ApplicationException {
        List<LstDecitypeSearchDTO> page = lstDecitypeService.search(LstDecitypeRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getROWCOUNT(),pageable.getPageNumber(),pageable.getPageSize(),page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(LstDecitypeRequest, pageable, "/dm/LstDecitype/getList", page.get(0).getROWCOUNT());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(LstDecitypeRequest, pageable, "/dm/LstDecitype/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/searchDecitypeAccu")
    @ApiOperation(value = "Get list for reason", response = List.class)
    public ResponseEntity<?> searchDecitypeAccu(@Valid @RequestParam String usefor) throws ApplicationException {
        return new ResponseEntity(lstDecitypeService.searchDecitypeAccu(usefor), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value="handle insert or update decitype", response = String.class)
    public ResponseEntity<?> save(@RequestBody LstDecitypeRequest req, HttpServletRequest http) {
        return new ResponseEntity<>(lstDecitypeService.save(req, http.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value="handle delete by decitypeid", response = String.class)
    public ResponseEntity<?> delete(@RequestParam String decitypeid) {
        return new ResponseEntity<>(lstDecitypeService.delete(decitypeid), HttpStatus.OK);
    }

    @GetMapping("/getLstDecitype")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getLstDecitype() {
        return new ResponseEntity(lstDecitypeService.getLst(), HttpStatus.OK);
    }
}
