package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.AdmDepartmentsRequestDTO;
import com.bitsco.vks.service.AdmDepartmentsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/dm/AdmDepertments")
public class AdmDepartmentsController {

    @Autowired
    private AdmDepartmentsService admDepartmentsService;

    @GetMapping("/getList")
    @ApiOperation(value="get lst adm groups", response = List.class)
    private ResponseEntity<?> getLst(@PageableDefault(size = 10) Pageable pageable,
                                     AdmDepartmentsRequestDTO req) {
        return new ResponseEntity<>(admDepartmentsService.getLst(pageable,req), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value="handle inser or update adm group", response = String.class)
    private ResponseEntity<?> save(@RequestBody AdmDepartmentsRequestDTO req, HttpServletRequest http) {
        return new ResponseEntity<>(admDepartmentsService.save(req,http.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("delete")
    @ApiOperation(value="handle delete adm group", response=String.class)
    private ResponseEntity<?> delete(@RequestParam @Valid String departid){
        return new ResponseEntity<>(admDepartmentsService.delete(departid), HttpStatus.OK);
    }

    @GetMapping("/getListSpp")
    @ApiOperation(value="get lst Spp", response = List.class)
    private ResponseEntity<?> getLst(@RequestParam String sppid) {
        return new ResponseEntity<>(admDepartmentsService.getLstSpp(sppid), HttpStatus.OK);
    }
}
