package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.RequestSaveListSplitDTO;
import com.bitsco.vks.dto.RequestSearchSplitDTO;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.service.SppSppSplitService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/SppSplit")
public class SppSppSplitController {

    @Autowired
    private SppSppSplitService sppSppSplitService;


    @PostMapping(value="/searchListSppSplit")
    @ApiOperation(value="Search list spp split",response = List.class)
    public ResponseEntity<?> getList(@Valid @RequestBody RequestSearchSplitDTO req) throws ApplicationException {
        return new ResponseEntity<>(sppSppSplitService.search(req), HttpStatus.OK);
    }

    @PostMapping(value="/saveSppSplit")
    @ApiOperation(value="Insert or update list spp split", response = String.class)
    public ResponseEntity<?> save(@Valid @RequestBody RequestSaveListSplitDTO req, HttpServletRequest htppRequest) {
        return new ResponseEntity<>(sppSppSplitService.insertOrUpdate(req,htppRequest.getHeader(Constant.KEY.USERNAME)),HttpStatus.OK);
    }

    @PostMapping(value="/deleteSppSplit")
    @ApiOperation(value="Delete list spp split", response = String.class)
    public ResponseEntity<?> delete(@Valid @RequestBody RequestSaveListSplitDTO req) {
        return new ResponseEntity<>(sppSppSplitService.delete(req,req.getChoiceType()),HttpStatus.OK);
    }

}
