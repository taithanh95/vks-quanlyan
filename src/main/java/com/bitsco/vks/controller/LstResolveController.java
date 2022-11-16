package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstResolveSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstResolveRequest;
import com.bitsco.vks.service.LstResolveService;
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
@RequestMapping(value = "/dm/LstResolve")
public class LstResolveController {
    @Autowired
    private LstResolveService lstResolveService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstResolveRequest lstResolveRequest) throws ApplicationException {
        List<LstResolveSearchDTO> page = lstResolveService.search(lstResolveRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getRowcount(),pageable.getPageNumber(),pageable.getPageSize(),page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstResolveRequest, pageable, "/dm/LstResolve/getList", page.get(0).getRowcount());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstResolveRequest, pageable, "/dm/LstResolve/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/save")
    @ApiOperation(value="/handle insert or update resolve", response = String.class)
    public ResponseEntity<?> save(@RequestBody LstResolveRequest req, HttpServletRequest http) {
        return new ResponseEntity<>(lstResolveService.save(req, http.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value="/handle delete resolve by resolid ", response = String.class)
    public ResponseEntity<?> delete(@RequestParam String resolid) {
        return new ResponseEntity<>(lstResolveService.delete(resolid), HttpStatus.OK);
    }
}
