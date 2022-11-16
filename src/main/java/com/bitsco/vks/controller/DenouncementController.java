package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.DenouncementDTO;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.service.DenouncementService;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping(value = "/denouncement")
public class DenouncementController {

    private final DenouncementService denouncementService;

    public DenouncementController(DenouncementService denouncementService) {
        this.denouncementService = denouncementService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get denouncement detail")
    public ResponseEntity<DenouncementDTO> getDenouncementById(@PathVariable("id") Long id,
                                                               @RequestParam("sppId") String sppId, HttpServletRequest httpRequest) {
        return new ResponseEntity<>(this.denouncementService.getDenouncementById(id, sppId, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/updateDenouncement")
    @ApiOperation(value = "Update denouncement")
    public ResponseEntity<Void> updateDenouncement(@Validated @RequestBody DenouncementDTO denouncementDTO,
                                                   @RequestParam("sppId") String sppId, HttpServletRequest httpRequest) {
        this.denouncementService.updateDenouncement(denouncementDTO, sppId, httpRequest.getHeader(Constant.KEY.USERNAME));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<Page<DenouncementDTO>> getList(@PageableDefault(size = 10) Pageable pageable
            , @RequestBody DenouncementDTO denouncementDTO) throws ApplicationException {
        int count = denouncementService.countSetting(denouncementDTO);
        Page<DenouncementDTO> page = new PageImpl<>(this.denouncementService.getLstDenounce(denouncementDTO, pageable), pageable, count);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create denouncement")
    public ResponseEntity<Void> createDenouncement(@RequestBody DenouncementDTO denouncementDTO, HttpServletRequest httpRequest) {
        this.denouncementService.createDenouncement(denouncementDTO, httpRequest.getHeader(Constant.KEY.USERNAME));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/deleteData")
    @ApiOperation(value = "Delete denouncement")
    public ResponseEntity<Void> deleteData(@RequestBody DenouncementDTO denouncementDTO,
                                           @RequestParam("sppId") String sppId, HttpServletRequest httpRequest) {
        this.denouncementService.deleteData(denouncementDTO, sppId, httpRequest.getHeader(Constant.KEY.USERNAME));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/defaultValue")
    @ApiOperation(value = "Get default value of share data info")
    public ResponseEntity<Object> getDefaultLevelShareInfo(@RequestParam("sppId") String sppId) {
        return new ResponseEntity<>(this.denouncementService.getDefaultLevelShareInfoBySppId(sppId), HttpStatus.OK);
    }
}
