package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.exception.CommonException;
import com.bitsco.vks.models.RegisterDecisionResponse;
import com.bitsco.vks.request.RegisterDecisionCaseRequest;
import com.bitsco.vks.response.Response;
import com.bitsco.vks.response.ResponseBody;
import com.bitsco.vks.service.RegisterDecisionService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/register-decision")
public class RegisterDecisionController {

    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.CONTROLLER);

    @Autowired
    private RegisterDecisionService registerDecisionService;

    @GetMapping("{id}")
    @ApiOperation(value = "Get RegisterDecision", response = RegisterDecisionResponse.class)
    public ResponseEntity<?> getRegisterDecision(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(new com.bitsco.vks.response.ResponseBody(Response.SUCCESS, Response.SUCCESS.getResponseMessage(), registerDecisionService.findById(id)), HttpStatus.OK);
        } catch (CommonException e) {
            return new ResponseEntity<>(new com.bitsco.vks.response.ResponseBody(e.getResponse().getResponseCode(), e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Exception when /api/v1/register-decision/" + id + " ", e);
            return new ResponseEntity<>(new ResponseBody(Response.SYSTEM_ERROR, e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/get-list")
    @ApiOperation(value = "Lấy danh sách Cấp lệnh, quyết định", response = List.class)
    public ResponseEntity<?> getListRegisterDecision(@RequestBody RegisterDecisionCaseRequest request) {
        try {
            return new ResponseEntity<>(new com.bitsco.vks.response.ResponseBody(Response.SUCCESS, Response.SUCCESS.getResponseMessage(), registerDecisionService.findAll(request)), HttpStatus.OK);
        } catch (CommonException e) {
            return new ResponseEntity<>(new com.bitsco.vks.response.ResponseBody(e.getResponse().getResponseCode(), e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Exception when /api/v1/register-decision/get-list ", e);
            return new ResponseEntity<>(new ResponseBody(Response.SYSTEM_ERROR, e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/delete/{id}")
    @ApiOperation(value = "Xóa bản ghi theo ID")
    public ResponseEntity<?> delete(@PathVariable("id") Long id, @RequestParam("mdfuser") String mdfuser) {
        try {
            return new ResponseEntity<>(new ResponseBody(Response.SUCCESS, Response.SUCCESS.getResponseMessage(), registerDecisionService.deleteById(id, mdfuser)), HttpStatus.OK);
        } catch (CommonException e) {
            return new ResponseEntity<>(new ResponseBody(e.getResponse().getResponseCode(), e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Exception when /api/v1/register-decision/delete/" + id + " ", e);
            return new ResponseEntity<>(new ResponseBody(Response.SYSTEM_ERROR, e.getMessage()), HttpStatus.OK);
        }
    }

}
