package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstOccupationSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstOccupationRequest;
import com.bitsco.vks.service.LstOccupationService;
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
@RequestMapping(value = "/dm/LstOccupation")
public class LstOccupationController {
    @Autowired
    private LstOccupationService lstOccupationService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstOccupationRequest lstOccupationRequest) throws ApplicationException {
        List<LstOccupationSearchDTO> page = lstOccupationService.search(lstOccupationRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getROWCOUNT(), pageable.getPageNumber(), pageable.getPageSize(), page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstOccupationRequest, pageable, "/dm/LstOccupation/getList", page.get(0).getROWCOUNT());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstOccupationRequest, pageable, "/dm/LstOccupation/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/insert")
    @ApiOperation(value="handle insert or update occupation", response = String.class)
    public ResponseEntity<?> insert(@RequestBody LstOccupationRequest req, HttpServletRequest httpRequest) {
        return new ResponseEntity<>(lstOccupationService.insert(req,httpRequest.getHeader(Constant.KEY.USERNAME)),HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value="handle delete occupation by occuid", response = String.class)
    public ResponseEntity<?> insert(@RequestParam String occuid) {
        return new ResponseEntity<>(lstOccupationService.delete(occuid),HttpStatus.OK);
    }

    @GetMapping("/getOccupation")
    @ApiOperation(value = "Get Occupation by query", response = Class.class)
    public ResponseEntity<?> getOccupation(@RequestParam String query) {
        return new ResponseEntity(lstOccupationService.getOccupation(query), HttpStatus.OK);
    }

}
