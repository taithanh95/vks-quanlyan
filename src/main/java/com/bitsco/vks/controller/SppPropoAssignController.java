package com.bitsco.vks.controller;

import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstInspectorSearchRequest;
import com.bitsco.vks.models.SaveSppRegisterRequest;
import com.bitsco.vks.models.SppPropoAssignSaveRequest;
import com.bitsco.vks.service.LstInspectorService;
import com.bitsco.vks.service.SppPropoAssignService;
import com.bitsco.vks.utils.PaginationUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/SppPropoAssign")
public class SppPropoAssignController {
    @Autowired
    private LstInspectorService lstInspectorService;
    @Autowired
    private SppPropoAssignService sppPropoAssignService;

    @PostMapping("/insert")
    @ApiOperation(value = "insert sppPropoAssign", response = String.class)
    public ResponseEntity<?> insert(@Valid @RequestBody SppPropoAssignSaveRequest request, BindingResult result) {
        return new ResponseEntity<>(sppPropoAssignService.insertUpdate("I", request), HttpStatus.OK);
    }

    @PostMapping("/update")
    @ApiOperation(value = "update sppPropoAssign", response = String.class)
    public ResponseEntity<?> update(@Valid @RequestBody SppPropoAssignSaveRequest request, BindingResult result) {
        return new ResponseEntity<>(sppPropoAssignService.insertUpdate("U", request), HttpStatus.OK);
    }

    @GetMapping("/loadInspModel")
    @ApiOperation(value = "Get list inspector", response = List.class)
    public ResponseEntity<?> loadInspModel(@PageableDefault(size = 10) Pageable pageable,
                                     LstInspectorSearchRequest sppRegisterSearchRequest) throws ApplicationException {
        List<LinkedCaseInsensitiveMap> page = lstInspectorService.search(sppRegisterSearchRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(((Number) page.get(0).get("ROWCOUNT")).longValue(),pageable.getPageNumber(),pageable.getPageSize(),page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(sppRegisterSearchRequest, pageable, "/SppPropoAssign/loadInspModel", ((Number) page.get(0).get("ROWCOUNT")).longValue()); //page.get(0).ROWCOUNT
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(sppRegisterSearchRequest, pageable, "/SppPropoAssign/loadInspModel", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/delete")
    @ApiOperation(value = "Delete inspector", response = String.class)
    public ResponseEntity<?> delete(@Valid @RequestParam String inspcode, @Valid @RequestParam String regicode, @Valid @RequestParam String casecode){
        return new ResponseEntity<>(sppPropoAssignService.delete(inspcode, regicode, casecode), HttpStatus.OK);
    }
}
