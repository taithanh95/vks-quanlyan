package com.bitsco.vks.controller;

import com.bitsco.vks.service.LstSignerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/dm/LstSigner")
public class LstSignerController {
    @Autowired
    private LstSignerService lstSignerService;

    @GetMapping("/autocomplete")
    @ApiOperation(value = "Get list objects by query", response = List.class)
    public ResponseEntity<?> autocomplete(@Valid @RequestParam String query,@Valid @RequestParam String polid,@Valid @RequestParam String officeid
            ,@Valid @RequestParam String sppid,@Valid @RequestParam int limit) {
        return new ResponseEntity(lstSignerService.autocomplete(query, polid, officeid, sppid, limit), HttpStatus.OK);

    }
}
