package com.bitsco.vks.controller;


import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstAgainstResultSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstAgainstResultRequest;
import com.bitsco.vks.service.LstAgainstResultService;
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
@RequestMapping(value = "/dm/LstAgainstResult")
public class LstAgainstResultController {
    @Autowired
    private LstAgainstResultService lstAgainstResultService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstAgainstResultRequest lstAgainstResultRequest) throws ApplicationException {
        return new ResponseEntity<>(lstAgainstResultService.search(lstAgainstResultRequest, pageable), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value="handle insert or update againstResult", response = String.class)
    public ResponseEntity<?> save(@RequestBody LstAgainstResultRequest req, HttpServletRequest http) {
        return new ResponseEntity<>(lstAgainstResultService.save(req, http.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value="handle delete by resultid", response = String.class)
    public ResponseEntity<?> delete(@RequestParam String resultid) {
        return new ResponseEntity<>(lstAgainstResultService.delete(resultid), HttpStatus.OK);
    }
}
