package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstBorderGuardsSearchDTO;
import com.bitsco.vks.dto.LstRuleSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstBorderGuardsRequest;
import com.bitsco.vks.models.LstResolveRequest;
import com.bitsco.vks.models.LstRuleRequest;
import com.bitsco.vks.service.LstRuleService;
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
@RequestMapping(value="/dm/LstRule")
public class LstRuleController {

    static LstRuleService lstRuleService;

    @Autowired
    void constructor(LstRuleService lstRuleServiceImpl) {
        lstRuleService =  lstRuleServiceImpl;
    }

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     LstRuleRequest lstRuleRequest) throws ApplicationException {
        List<LstRuleSearchDTO> page = lstRuleService.search(lstRuleRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getRowcount(),pageable.getPageNumber(),pageable.getPageSize(),page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstRuleRequest, pageable, "/dm/LstRule/getList", page.get(0).getRowcount());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstRuleRequest, pageable, "/dm/LstRule/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/save")
    @ApiOperation(value="/handle insert or update rule", response = String.class)
    public ResponseEntity<?> save(@RequestBody LstRuleRequest req, HttpServletRequest http) {
        return new ResponseEntity<>(lstRuleService.save(req, http.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value="/handle delete resolve by caseType and userFor", response = String.class)
    public ResponseEntity<?> delete(@RequestParam String caseType, @RequestParam String userFor) {
        return new ResponseEntity<>(lstRuleService.delete(caseType,userFor), HttpStatus.OK);
    }

}
