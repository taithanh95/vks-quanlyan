package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.entity.LstInspector;
import com.bitsco.vks.models.LstInspectorInsertRequest;
import com.bitsco.vks.models.LstInspectorSearchRequest;
import com.bitsco.vks.service.LstInspectorService;
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
@RequestMapping(value = "/dm/LstInspector")
public class LstInspectorController {
    @Autowired
    private LstInspectorService lstInspectorService;

    @GetMapping("/loadInsList/{sppId}/{position}/{query}")
    @ApiOperation(value = "Get list objects by query", response = List.class)
    public ResponseEntity<?> loadInsList(@PathVariable String sppId, @PathVariable String position, @PathVariable String query) {
        return new ResponseEntity(lstInspectorService.loadInsList(query, sppId, position), HttpStatus.OK);
    }

    @GetMapping("/loadInsList_npc")
    @ApiOperation(value = "Get list objects by query", response = List.class)
    public ResponseEntity<?> loadInsList_npc(@RequestParam String sppId, @RequestParam(value = "") String query) {
        return new ResponseEntity(lstInspectorService.loadInsList_npc(query, sppId), HttpStatus.OK);
    }
    @GetMapping("/getListLstInspectorBySppId")
    @ApiOperation(value = "Get list LstInspector By SppId", response = List.class)
    public ResponseEntity<?> getListLstInspectorBySppId(@RequestParam String sppId) {
        return new ResponseEntity(lstInspectorService.getListLstInspectorBySppId(sppId), HttpStatus.OK);
    }
    @GetMapping("/getListLstInspectorBySppIdAndPosition")
    @ApiOperation(value = "Get list LstInspector By SppId and Position", response = List.class)
    public ResponseEntity<?> getListLstInspectorBySppIdAndPosition(@RequestParam String sppId, @RequestParam String position) {
        return new ResponseEntity(lstInspectorService.getListLstInspectorBySppIdAndPosition(sppId, position), HttpStatus.OK);
    }
    @GetMapping("/getListInspectorByPositionSearchKey")
    @ApiOperation(value = "Get list LstInspector By SppId, Position and search fullname, inspCode", response = List.class)
    public ResponseEntity<?> getListInspectorByPositionSearchKey(@RequestParam String sppId,
                                                                      @RequestParam String position,
                                                                      @RequestParam String key) {
        return new ResponseEntity(lstInspectorService.getListInspectorByPositionSearchKey(sppId, position, key), HttpStatus.OK);
    }
    @GetMapping("/getByInspcode/{inspcode}")
    @ApiOperation(value = "Get inpector by inspcode", response = LstInspector.class)
    public ResponseEntity<?> getInpectorByInspCode(@PathVariable String inspcode) {
        return new ResponseEntity(lstInspectorService.getByInspcode(inspcode), HttpStatus.OK);
    }

    @PostMapping("/search1")
    @ApiOperation(value = "Get list", response = List.class)
    public ResponseEntity<?> search1(@RequestBody LstInspectorSearchRequest request) {
        return new ResponseEntity(lstInspectorService.search1(request), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "delete", response = List.class)
    public ResponseEntity<?> delete(@Valid @RequestBody LstInspectorSearchRequest request) {
        return new ResponseEntity(lstInspectorService.delete(request), HttpStatus.OK);
    }

    @PostMapping("/insertOrUpdate")
    @ApiOperation(value = "Insert Or Update", response = String.class)
    public ResponseEntity<?> insert(@Valid @RequestBody LstInspectorInsertRequest req, HttpServletRequest httpRequest) {
        return new ResponseEntity(lstInspectorService.insertUpdate(req, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @GetMapping("/getListSpp")
    @ApiOperation(value = "Get List Spp", response = List.class)
    public ResponseEntity<?> getSpp(@RequestParam String sppid) {
        return new ResponseEntity(lstInspectorService.getSpp(sppid), HttpStatus.OK);
    }

    @GetMapping("/getListSppIsDepart")
    @ApiOperation(value = "Get List Spp IsDepart", response = List.class)
    public ResponseEntity<?> getListSppIsDepart(@RequestParam String sppid) {
        return new ResponseEntity(lstInspectorService.getListSppIsDepart(sppid), HttpStatus.OK);
    }

    @PostMapping("/changeInspector")
    @ApiOperation(value = "Change Inspector", response = String.class)
    public ResponseEntity<?> changeInspector(@Valid @RequestBody LstInspector req, HttpServletRequest httpRequest) {
        return new ResponseEntity(lstInspectorService.changeInspector(req, httpRequest.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @GetMapping("/getInspList/{sppId}/{underlevel}/{query}")
    @ApiOperation(value = "Get list Inspector by query", response = List.class)
    public ResponseEntity<?> getInspList(@PathVariable String sppId, @PathVariable String underlevel, @PathVariable String query) {
        return new ResponseEntity(lstInspectorService.getInspList(query, sppId, underlevel), HttpStatus.OK);
    }
}
