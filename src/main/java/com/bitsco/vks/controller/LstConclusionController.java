package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstConclusionSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstConclusionRequest;
import com.bitsco.vks.service.LstConclusionService;
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
@RequestMapping(value = "/dm/LstConclusion")
public class LstConclusionController {
    @Autowired
    private LstConclusionService lstConclusionService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstConclusionRequest lstConclusionRequest) throws ApplicationException {
        List<LstConclusionSearchDTO> page = lstConclusionService.search(lstConclusionRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getRowcount(),pageable.getPageNumber(),pageable.getPageSize(),page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstConclusionRequest, pageable, "/dm/LstConclusion/getList", page.get(0).getRowcount());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstConclusionRequest, pageable, "/dm/LstConclusion/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/autocomplete")
    @ApiOperation(value="get autocomplete conclusion", response = List.class)
    public ResponseEntity<?> getAutocomplete(@RequestParam(defaultValue = "") String concid, @RequestParam String userfor) {
        return new ResponseEntity(lstConclusionService.autocomplete(concid,userfor),HttpStatus.OK);
    }

    @GetMapping("/getConclution")
    @ApiOperation(value="get conclution", response = List.class)
    public ResponseEntity<?> getByConcid(@RequestParam(defaultValue = "") String concid) {
        return new ResponseEntity(lstConclusionService.getConclu(concid),HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value="handle insert or update conslusion", response = String.class)
    public ResponseEntity<?> save(@RequestBody LstConclusionRequest req, HttpServletRequest http) {
        return new ResponseEntity<>(lstConclusionService.save(req, http.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value="handle delete conslusion by concid", response = String.class)
    public ResponseEntity<?> save(@RequestParam String concid) {
        return new ResponseEntity<>(lstConclusionService.delete(concid), HttpStatus.OK);
    }

}
