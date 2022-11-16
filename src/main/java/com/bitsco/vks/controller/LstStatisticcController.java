package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.StatisticcRequestDTO;
import com.bitsco.vks.service.LstStatisticcService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/dm/LstStatisticc")
@CrossOrigin("*")
public class LstStatisticcController {

    @Autowired
    private LstStatisticcService lstStatisticcService;

    @GetMapping("/getList")
    @ApiOperation(value="get list statistacc", response = List.class)
    private ResponseEntity<?> getlist(@PageableDefault(size = 20) Pageable page,
                                      StatisticcRequestDTO req) {
        return new ResponseEntity<>(lstStatisticcService.getLst(page,req), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value = "save statisticc", response = String.class)
    private ResponseEntity<?> save(@RequestBody StatisticcRequestDTO req, HttpServletRequest http) {
        return new ResponseEntity<>(lstStatisticcService.save(req, http.getHeader(Constant.KEY.USERNAME)),HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "delete statisticc", response = String.class)
    private ResponseEntity<?> delete(@RequestParam String statid) {
        return new ResponseEntity<>(lstStatisticcService.delete(statid),HttpStatus.OK);
    }

}
