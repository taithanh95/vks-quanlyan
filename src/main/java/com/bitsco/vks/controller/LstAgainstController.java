package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstAgainstSearchDTO;
import com.bitsco.vks.dto.PageDTO;
import com.bitsco.vks.exception.ApplicationException;
import com.bitsco.vks.models.LstAgainstRequest;
import com.bitsco.vks.service.LstAgainstService;
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
@RequestMapping(value="/dm/LstAgainst")

public class LstAgainstController {
    @Autowired
    private LstAgainstService lstAgainstService;

    @GetMapping("/getList")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> getList(@PageableDefault(size = 20) Pageable pageable,
                                     LstAgainstRequest lstAgainstRequest) throws ApplicationException {
        List<LstAgainstSearchDTO> page = lstAgainstService.search(lstAgainstRequest, pageable);
        if (page.size() > 0) {
            PageDTO pageDTO = new PageDTO(page.get(0).getRowcount(),pageable.getPageNumber(),pageable.getPageSize(),page);
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstAgainstRequest, pageable, "/dm/LstAgainst/getList", page.get(0).getRowcount());
            return new ResponseEntity<>(pageDTO, headers, HttpStatus.OK);
        } else {
            HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(lstAgainstRequest, pageable, "/dm/LstAgainst/getList", Long.valueOf(0));
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/save")
    @ApiOperation(value="handle insert or update against", response = String.class)
    public ResponseEntity<?> save (@RequestBody LstAgainstRequest req, HttpServletRequest htpp) {
        return new ResponseEntity<>(lstAgainstService.save(req,htpp.getHeader(Constant.KEY.USERNAME)),HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value="handle delete by against", response = String.class)
    public ResponseEntity<?> delete (@RequestParam String againstid) {
        return new ResponseEntity<>(lstAgainstService.delete(againstid),HttpStatus.OK);
    }

}

