package com.bitsco.vks.controller;

import com.bitsco.vks.models.LookupRequest;
import com.bitsco.vks.service.LookupService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/lookup/Lookup")
public class LookupController {
    @Autowired
    private LookupService lookupService;

    @PostMapping("/register")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> searchRegister(@RequestBody LookupRequest request) {
        return new ResponseEntity(lookupService.searchRegister(request), HttpStatus.OK);
    }

    @PostMapping("/lookupregister")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> lookupRegister(@RequestBody String casecode) {
        return new ResponseEntity(lookupService.lookupRegister(casecode), HttpStatus.OK);
    }

    @PostMapping("/decision")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> searchDecision(@RequestBody LookupRequest request) {
        return new ResponseEntity(lookupService.searchDecision(request), HttpStatus.OK);
    }

    @PostMapping("/decision-detail")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> lookupDecision(@RequestBody LookupRequest request) {
        return new ResponseEntity(lookupService.lookupDecision(request), HttpStatus.OK);
    }

    @PostMapping("/against")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> searchAgianst(@RequestBody LookupRequest request) {
        return new ResponseEntity(lookupService.searchAgainst(request), HttpStatus.OK);
    }

    @PostMapping("/against-detail")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> lookupAgainst(@RequestBody LookupRequest request) {
        return new ResponseEntity(lookupService.lookupAgainst(request), HttpStatus.OK);
    }

    @PostMapping("/appeal")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> searchAppeal(@RequestBody LookupRequest request) {
        return new ResponseEntity(lookupService.searchAppeal(request), HttpStatus.OK);
    }

    @PostMapping("/appeal-detail")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> lookupAppeal(@RequestBody LookupRequest request) {
        return new ResponseEntity(lookupService.lookupAppeal(request), HttpStatus.OK);
    }

    @PostMapping("/accused")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> searchAccused(@RequestBody LookupRequest request) {
        return new ResponseEntity(lookupService.searchAccused(request), HttpStatus.OK);
    }

    @PostMapping("/accused-detail")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> lookupAccused(@RequestBody LookupRequest request) {
        return new ResponseEntity(lookupService.lookupAccused(request), HttpStatus.OK);
    }

    @PostMapping("/law")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> searchLaw(@RequestBody LookupRequest request) throws Exception {
        return new ResponseEntity(lookupService.searchLaw(request), HttpStatus.OK);
    }

    @PostMapping("/inspector-detail")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> lookupInspector(@RequestBody LookupRequest request) throws Exception {
        return new ResponseEntity(lookupService.lookupInspector(request), HttpStatus.OK);
    }

    @PostMapping("/penalty")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> searchPenalty(@RequestBody LookupRequest request) {
        return new ResponseEntity(lookupService.searchPenalty(request), HttpStatus.OK);
    }

    @PostMapping("/transfer")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> searchTransfer(@RequestBody LookupRequest request) {
        return new ResponseEntity(lookupService.searchTransfer(request), HttpStatus.OK);
    }

    @PostMapping("/centence-detail")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> lookupCentence(@RequestBody LookupRequest request) throws Exception {
        return new ResponseEntity(lookupService.lookupCentence(request), HttpStatus.OK);
    }

    @PostMapping("/listCentence")
    @ApiOperation(value = "Get list Centence", response = List.class)
    public ResponseEntity<?> listCentence(@RequestBody LookupRequest request) throws Exception {
        return new ResponseEntity(lookupService.listCentence(request), HttpStatus.OK);
    }

    @PostMapping("/transfer-detail")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> lookupTransfer(@RequestBody LookupRequest request) throws Exception {
        return new ResponseEntity(lookupService.lookupTransfer(request), HttpStatus.OK);
    }

    @PostMapping("/listCentLaw")
    @ApiOperation(value = "Get list Centence Law", response = List.class)
    public ResponseEntity<?> listCentLaw(@RequestBody LookupRequest request) throws Exception {
        return new ResponseEntity(lookupService.listCentLaw(request), HttpStatus.OK);
    }

    @PostMapping("/listStatistica")
    @ApiOperation(value = "Get list Statistica", response = List.class)
    public ResponseEntity<?> listStatistica(@RequestBody LookupRequest request) throws Exception {
        return new ResponseEntity(lookupService.listStatistica(request), HttpStatus.OK);
    }

    @PostMapping("/listStatisticc")
    @ApiOperation(value = "Get list Statisticc", response = List.class)
    public ResponseEntity<?> listStatisticc(@RequestBody LookupRequest request) throws Exception {
        return new ResponseEntity(lookupService.listStatisticc(request), HttpStatus.OK);
    }
}
