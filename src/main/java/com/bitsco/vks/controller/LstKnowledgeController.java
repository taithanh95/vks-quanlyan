package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstKnowledgeSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstKnowledgeRequest;
import com.bitsco.vks.service.LstKnowledgeService;
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
@RequestMapping(value = "/dm/LstKnowledge")
public class LstKnowledgeController {
    @Autowired
    private LstKnowledgeService lstKnowledgeService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstKnowledgeRequest lstKnowledgeRequest) throws ApplicationException {
        List<LstKnowledgeSearchDTO> page = lstKnowledgeService.search(lstKnowledgeRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getRowcount(),pageable.getPageNumber(),pageable.getPageSize(),page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstKnowledgeRequest, pageable, "/dm/LstKnowledge/getList", page.get(0).getRowcount());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstKnowledgeRequest, pageable, "/dm/LstKnowledge/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }


    @PostMapping("/save")
    @ApiOperation(value="handle insert or update knowledge", response = String.class)
    public ResponseEntity<?> save(@RequestBody LstKnowledgeRequest req, HttpServletRequest http) {
        return new ResponseEntity<>(lstKnowledgeService.save(req, http.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value="handle delete transfer by levelid", response = String.class)
    public ResponseEntity<?> delete(@RequestParam String levelid) {
        return new ResponseEntity<>(lstKnowledgeService.delete(levelid), HttpStatus.OK);
    }
}
