package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstReasonSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstReasonRequest;
import com.bitsco.vks.service.LstReasonService;
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
@RequestMapping(value = "/dm/LstReason")
public class LstReasonController {
    @Autowired
    private LstReasonService lstReasonService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstReasonRequest lstReasonRequest) throws ApplicationException {
        List<LstReasonSearchDTO> page = lstReasonService.search(lstReasonRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getROWCOUNT(), pageable.getPageNumber(), pageable.getPageSize(), page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstReasonRequest, pageable, "/dm/LstReason/getList", page.get(0).getROWCOUNT());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstReasonRequest, pageable, "/dm/LstReason/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/loadLstReason")
    @ApiOperation(value = "Get list for reason", response = List.class)
    public ResponseEntity<?> loadLstReason(@Valid @RequestParam String usefor, @Valid @RequestParam String applyfor, @Valid @RequestParam String deciid) throws ApplicationException {
        return new ResponseEntity(lstReasonService.loadLstReason(usefor, applyfor, deciid), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value="/handle insert or update reason", response = String.class)
    public ResponseEntity<?> save(@RequestBody LstReasonRequest req, HttpServletRequest http) {
        return new ResponseEntity<>(lstReasonService.save(req, http.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value="/handle delete reason by reasonid ", response = String.class)
    public ResponseEntity<?> delete(@RequestParam String reasonid) {
        return new ResponseEntity<>(lstReasonService.delete(reasonid), HttpStatus.OK);
    }
}
