package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.RegisterDecisionCaseListResponse;
import com.bitsco.vks.exception.CommonException;
import com.bitsco.vks.models.RegisterDecisionCaseSearchRequest;
import com.bitsco.vks.request.RegisterDecisionCaseRequest;
import com.bitsco.vks.request.RegisterDecisionCaseSeqRequest;
import com.bitsco.vks.request.SppRequest;
import com.bitsco.vks.response.PageResponse;
import com.bitsco.vks.response.Response;
import com.bitsco.vks.response.ResponseBody;
import com.bitsco.vks.service.RegisterDecisionCaseService;
import com.bitsco.vks.service.RegisterDecisionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/register-decision-case")
public class RegisterDecisionCaseController {

    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.CONTROLLER);

    @Autowired
    private RegisterDecisionCaseService registerDecisionCaseService;

    @Autowired
    private RegisterDecisionService registerDecisionService;

    @PostMapping
    @ApiOperation(value = "Tìm kiếm Vụ án", response = PageResponse.class)
    public ResponseEntity<?> searchSppCase(@RequestBody RegisterDecisionCaseSearchRequest request) {
        try {
            return new ResponseEntity<>(new ResponseBody(Response.SUCCESS, Response.SUCCESS.getResponseMessage(), registerDecisionCaseService.findAll(request)), HttpStatus.OK);
        } catch (CommonException e) {
            return new ResponseEntity<>(new ResponseBody(e.getResponse().getResponseCode(), e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Exception when /api/v1/register-decision-case ", e);
            return new ResponseEntity<>(new ResponseBody(Response.SYSTEM_ERROR, e.getMessage()), HttpStatus.OK);
        }
    }

    @GetMapping("/search-decision")
    @ApiOperation(value = "Autocomplete tìm kiếm theo tên QĐ", response = List.class)
    public ResponseEntity<?> searchSppDecision(@RequestParam("q") String query) {
        try {
            return new ResponseEntity<>(new ResponseBody(Response.SUCCESS, Response.SUCCESS.getResponseMessage(), registerDecisionCaseService.findDeciIdAndDeciNameByDeciName(query)), HttpStatus.OK);
        } catch (CommonException e) {
            return new ResponseEntity<>(new ResponseBody(e.getResponse().getResponseCode(), e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Exception when /api/v1/register-decision-case/search-decision ", e);
            return new ResponseEntity<>(new ResponseBody(Response.SYSTEM_ERROR, e.getMessage()), HttpStatus.OK);
        }
    }

    @GetMapping("{caseCode}")
    @ApiOperation(value = "Lấy danh sách Đăng ký lệnh QĐ theo mã Vụ án", response = RegisterDecisionCaseListResponse.class)
    public ResponseEntity<?> findByCaseCode(@PathVariable("caseCode") String caseCode) {
        try {
            return new ResponseEntity<>(new ResponseBody(Response.SUCCESS, Response.SUCCESS.getResponseMessage(), registerDecisionCaseService.findByCaseCode(caseCode)), HttpStatus.OK);
        } catch (CommonException e) {
            return new ResponseEntity<>(new ResponseBody(e.getResponse().getResponseCode(), e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Exception when /api/v1/register-decision-case/{caseCode} ", e);
            return new ResponseEntity<>(new ResponseBody(Response.SYSTEM_ERROR, e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/save-or-update")
    @ApiOperation(value = "Thêm mới hoặc cập nhật Đăng ký lệnh/QĐ vụ án", response = RegisterDecisionCaseRequest.class)
    public ResponseEntity<?> saveOrUpdate(@RequestBody RegisterDecisionCaseRequest request) {
        try {
            return new ResponseEntity<>(new ResponseBody(Response.SUCCESS, Response.SUCCESS.getResponseMessage(), registerDecisionCaseService.saveOrUpdate(request)), HttpStatus.OK);
        } catch (CommonException e) {
            return new ResponseEntity<>(new ResponseBody(e.getResponse().getResponseCode(), e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Exception when /api/v1/register-decision-case/save ", e);
            return new ResponseEntity<>(new ResponseBody(Response.SYSTEM_ERROR, e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/get-list")
    @ApiOperation(value = "Lấy ra danh sách Đăng ký lệnh QĐ theo mã vụ án", response = List.class)
    public ResponseEntity<?> getListRegisterDecision(@RequestBody RegisterDecisionCaseRequest request) {
        try {
            return new ResponseEntity<>(new ResponseBody(Response.SUCCESS, Response.SUCCESS.getResponseMessage(), registerDecisionService.findAllByCaseCodeAndSppId(request)), HttpStatus.OK);
        } catch (CommonException e) {
            return new ResponseEntity<>(new ResponseBody(e.getResponse().getResponseCode(), e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Exception when /api/v1/register-decision-case/get-list ", e);
            return new ResponseEntity<>(new ResponseBody(Response.SYSTEM_ERROR, e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/check-setnum")
    @ApiOperation(value = "Kiểm tra số QĐ", response = Boolean.class)
    public ResponseEntity<?> requestCheckSetNum(@RequestBody RegisterDecisionCaseRequest request) {
        try {
            return new ResponseEntity<>(new ResponseBody(Response.SUCCESS, Response.SUCCESS.getResponseMessage(), registerDecisionCaseService.isRegisterDecisionByDeciIdAndDateExists(request)), HttpStatus.OK);
        } catch (CommonException e) {
            return new ResponseEntity<>(new ResponseBody(e.getResponse().getResponseCode(), e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Exception when /api/v1/register-decision-case/check-setnum ", e);
            return new ResponseEntity<>(new ResponseBody(Response.SYSTEM_ERROR, e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/check-setnum-reality")
    @ApiOperation(value = "Kiểm tra số QĐ thực tế", response = Boolean.class)
    public ResponseEntity<?> requestCheckSetNumReality(@RequestBody RegisterDecisionCaseRequest request) {
        try {
            return new ResponseEntity<>(new ResponseBody(Response.SUCCESS, Response.SUCCESS.getResponseMessage(), registerDecisionCaseService.existsBySetNumAndSppIdAndCaseCodeAndInDate(request)), HttpStatus.OK);
        } catch (CommonException e) {
            return new ResponseEntity<>(new ResponseBody(e.getResponse().getResponseCode(), e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Exception when /api/v1/register-decision-case/check-setnum ", e);
            return new ResponseEntity<>(new ResponseBody(Response.SYSTEM_ERROR, e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/get-setnum")
    @ApiOperation(value = "Lấy ra số QĐ mới nhất", response = Integer.class)
    public ResponseEntity<?> getSetNum(@RequestBody RegisterDecisionCaseSeqRequest request) {
        try {
            return new ResponseEntity<>(new ResponseBody(Response.SUCCESS, Response.SUCCESS.getResponseMessage(), registerDecisionCaseService.getSequenceNumber(request)), HttpStatus.OK);
        } catch (CommonException e) {
            return new ResponseEntity<>(new ResponseBody(e.getResponse().getResponseCode(), e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Exception when /api/v1/register-decision-case/get-setnum ", e);
            return new ResponseEntity<>(new ResponseBody(Response.SYSTEM_ERROR, e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/get-spp")
    @ApiOperation(value = "Lấy ra mã đơn vị Quản lý từ người dùng đăng nhập", response = String.class)
    public ResponseEntity<?> findSppByUserLogin(@RequestBody SppRequest request) {
        try {
            return new ResponseEntity<>(new ResponseBody(Response.SUCCESS, Response.SUCCESS.getResponseMessage(), registerDecisionCaseService.getLstSpp(request)), HttpStatus.OK);
        } catch (CommonException e) {
            return new ResponseEntity<>(new ResponseBody(e.getResponse().getResponseCode(), e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Exception when /api/v1/register-decision-case/get-spp ", e);
            return new ResponseEntity<>(new ResponseBody(Response.SYSTEM_ERROR, e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/check-status-register")
    @ApiOperation(value = "Kiểm tra trạng thái thụ lý vụ án", response = Boolean.class)
    public ResponseEntity<?> checkStatusRegister(@RequestBody RegisterDecisionCaseRequest request) {
        try {
            return new ResponseEntity<>(new ResponseBody(Response.SUCCESS, Response.SUCCESS.getResponseMessage(), registerDecisionCaseService.checkStatusRegister(request)), HttpStatus.OK);
        } catch (CommonException e) {
            return new ResponseEntity<>(new ResponseBody(e.getResponse().getResponseCode(), e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Exception when /api/v1/register-decision-case/checkStatusRegister ", e);
            return new ResponseEntity<>(new ResponseBody(Response.SYSTEM_ERROR, e.getMessage()), HttpStatus.OK);
        }
    }

}
