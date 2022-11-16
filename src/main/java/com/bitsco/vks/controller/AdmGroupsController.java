package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.AdmGroupsRequestDTO;
import com.bitsco.vks.exception.CommonException;
import com.bitsco.vks.response.Response;
import com.bitsco.vks.response.ResponseBody;
import com.bitsco.vks.service.AdmGroupsService;
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
@RequestMapping(value = "/dm/AdmGroups")
public class AdmGroupsController {

    @Autowired
    private AdmGroupsService admGroupsService;

    @GetMapping("/getList")
    @ApiOperation(value = "get lst adm groups", response = List.class)
    private ResponseEntity<?> getLst(@PageableDefault(size = 10) Pageable pageable,
                                     AdmGroupsRequestDTO req) {
        return new ResponseEntity<>(admGroupsService.getLst(pageable, req), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value = "handle inser or update adm group", response = String.class)
    private ResponseEntity<?> save(@RequestBody AdmGroupsRequestDTO req, HttpServletRequest http) {
//        return new ResponseEntity<>(admGroupsService.save(req,http.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
        try {
            return new ResponseEntity<>(new ResponseBody(Response.SUCCESS, Response.SUCCESS.getResponseMessage(),
                    admGroupsService.save(req, http.getHeader(Constant.KEY.USERNAME))), HttpStatus.OK);
        } catch (CommonException e) {
            return new ResponseEntity<>(new com.bitsco.vks.response.ResponseBody(e.getResponse().getResponseCode(), e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseBody(Response.SYSTEM_ERROR, e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("delete")
    @ApiOperation(value = "handle delete adm group", response = String.class)
    private ResponseEntity<?> delete(@RequestParam @Valid String groupid) {
//        return new ResponseEntity<>(admGroupsService.delete(groupid), HttpStatus.OK);
        try {
            return new ResponseEntity<>(new ResponseBody(Response.SUCCESS, Response.SUCCESS.getResponseMessage(),
                    admGroupsService.delete(groupid)), HttpStatus.OK);
        } catch (CommonException e) {
            return new ResponseEntity<>(new com.bitsco.vks.response.ResponseBody(e.getResponse().getResponseCode(), e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseBody(Response.SYSTEM_ERROR, e.getMessage()), HttpStatus.OK);
        }
    }

}
