package com.bitsco.vks.controller;

import com.bitsco.vks.dto.LstBorderGuardsSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.dto.SppRegisterSearchDTO;
import com.bitsco.vks.entity.SppRegister;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.*;
import com.bitsco.vks.service.SppRegisterService;
import com.bitsco.vks.utils.Md5;
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
@RequestMapping(value="/SppRegister")
public class SppRegisterController {
    @Autowired
    private SppRegisterService sppRegisterService;

    @PostMapping("/save")
    @ApiOperation(value = "Get list UpdateInfo", response = String.class)
    public ResponseEntity<?> insert(@Valid @RequestBody SaveSppRegisterRequest request, BindingResult result) {
        //return new ResponseEntity("ABc", HttpStatus.OK);
        return new ResponseEntity<>(sppRegisterService.SaveSppRegister(request), HttpStatus.OK);
    }

//    @GetMapping("/getBySppCase")
//    @ApiOperation(value = "Get by sppCase", response = SppRegister.class)
//    public ResponseEntity<?> getUserLogin(@RequestParam String casecode, @RequestParam String usefor, @RequestParam String sppid) {
//        return new ResponseEntity(sppRegisterService.GetSppRegister(casecode, usefor, sppid), HttpStatus.OK);
//    }
    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 10) Pageable pageable,
                                     SppRegisterSearchRequest sppRegisterSearchRequest) throws ApplicationException {
        List<LinkedCaseInsensitiveMap> page = sppRegisterService.search(sppRegisterSearchRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(((Number) page.get(0).get("ROWCOUNT")).longValue(),pageable.getPageNumber(),pageable.getPageSize(),page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(sppRegisterSearchRequest, pageable, "/SppRegister/getList", ((Number) page.get(0).get("ROWCOUNT")).longValue()); //page.get(0).ROWCOUNT
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(sppRegisterSearchRequest, pageable, "/SppRegister/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }
    @PostMapping("/delete")
    @ApiOperation(value = "Delete register", response = String.class)
    public ResponseEntity<?> delete(@Valid @RequestParam String code){
        return new ResponseEntity<>(sppRegisterService.delete(code), HttpStatus.OK);
    }
    @PostMapping("/registerable")
    @ApiOperation(value = "Delete register", response = String.class)
    public ResponseEntity<?> registerable(@Valid @RequestBody CheckRegisterableRequest request, BindingResult result){
        return new ResponseEntity<>(sppRegisterService.checkRegisterable(request.casecode, request.usefor, request.sppId), HttpStatus.OK);
    }
}
