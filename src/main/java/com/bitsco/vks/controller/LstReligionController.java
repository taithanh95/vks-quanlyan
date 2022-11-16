package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstReligionSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstReligionRequest;
import com.bitsco.vks.service.LstReligionService;
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
@RequestMapping(value = "/dm/LstReligion")
public class LstReligionController {
    @Autowired
    private LstReligionService lstReligionService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstReligionRequest lstReligionRequest) throws ApplicationException {
        List<LstReligionSearchDTO> page = lstReligionService.search(lstReligionRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getROWCOUNT(), pageable.getPageNumber(), pageable.getPageSize(), page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstReligionRequest, pageable, "/dm/LstReligion/getList", page.get(0).getROWCOUNT());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstReligionRequest, pageable, "/dm/LstReligion/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/save")
    @ApiOperation(value="/handle insert or update resolve", response = String.class)
    public ResponseEntity<?> save(@RequestBody LstReligionRequest req, HttpServletRequest http) {
        return new ResponseEntity<>(lstReligionService.save(req, http.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value="/handle delete resolve by resolid ", response = String.class)
    public ResponseEntity<?> delete(@RequestParam String religionid) {
        return new ResponseEntity<>(lstReligionService.delete(religionid), HttpStatus.OK);
    }
}
