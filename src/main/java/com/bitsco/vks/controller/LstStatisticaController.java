package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.StatisticaRequestDTO;
import com.bitsco.vks.service.LstStatisticaService;
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
@RequestMapping(value = "/dm/LstStatistica")
@CrossOrigin("*")
public class LstStatisticaController {

    @Autowired
    private LstStatisticaService lstStatisticaService;

    @GetMapping("/getList")
    @ApiOperation(value="get list statistaca", response = List.class)
    private ResponseEntity<?> getlist(@PageableDefault(size = 20) Pageable page,
                                      StatisticaRequestDTO req) {
        return new ResponseEntity<>(lstStatisticaService.getLst(page,req), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value = "save statistica", response = String.class)
    private ResponseEntity<?> save(@RequestBody StatisticaRequestDTO req, HttpServletRequest http) {
        return new ResponseEntity<>(lstStatisticaService.save(req, http.getHeader(Constant.KEY.USERNAME)),HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "delete statistica", response = String.class)
    private ResponseEntity<?> delete(@RequestParam String statid) {
        return new ResponseEntity<>(lstStatisticaService.delete(statid),HttpStatus.OK);
    }

}
