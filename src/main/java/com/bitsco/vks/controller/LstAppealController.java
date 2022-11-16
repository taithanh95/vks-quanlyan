package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstAppealSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstAppealRequest;
import com.bitsco.vks.service.LstAppealService;
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
@RequestMapping(value = "/dm/LstAppeal")
public class LstAppealController {
    @Autowired
    private LstAppealService lstAppealService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstAppealRequest lstAppealRequest) throws ApplicationException {
        List<LstAppealSearchDTO> page = lstAppealService.search(lstAppealRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getRowcount(),pageable.getPageNumber(),pageable.getPageSize(),page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstAppealRequest, pageable, "/dm/LstAppeal/getList", page.get(0).getRowcount());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstAppealRequest, pageable, "/dm/LstAppeal/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/save")
    @ApiOperation(value="handle insert or update appeal", response = String.class)
    public ResponseEntity<?> save(@RequestBody LstAppealRequest req, HttpServletRequest http) {
        return new ResponseEntity<>(lstAppealService.save(req, http.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value="handle delete by  appealid", response = String.class)
    public ResponseEntity<?> delete(@RequestParam String appealid) {
        return new ResponseEntity<>(lstAppealService.delete(appealid), HttpStatus.OK);
    }
}
