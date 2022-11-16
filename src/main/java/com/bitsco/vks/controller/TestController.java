package com.bitsco.vks.controller;

import com.bitsco.vks.entity.AdmUsers;
import com.bitsco.vks.models.SppCaseInsertRequest;
import com.bitsco.vks.models.UpdateInfoRequest;
import com.bitsco.vks.service.SppCaseService;
import com.bitsco.vks.service.SppService;
import com.bitsco.vks.service.UserService;
import com.bitsco.vks.utils.Md5;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping(value="/test")
public class TestController {
    @Autowired
    private UserService userService;
    @Autowired
    private SppCaseService sppCaseService;
    @Autowired
    private SppService sppService;

    public  TestController(){}

//    @GetMapping
//    @CrossOrigin(origins = "*")
//    @ApiOperation(value = "Get list test", response = List.class)
//    public ResponseEntity<?> getList() {
//        List<String> menuResponses = new ArrayList<>();
//        menuResponses.add("test");
//        menuResponses.add(jwtTokenUtil.getUsername());
//        Claims cls = jwtTokenUtil.getClaims();
//        for (Object obj : cls.values()
//             ) {
//            menuResponses.add(obj.toString());
//        }
//        return new ResponseEntity(menuResponses, HttpStatus.OK);
//
//    }

    @GetMapping("/spps/{id}")
    @ApiOperation(value = "Get list children SPP", response = List.class)
    public ResponseEntity<?> getChildSPPs(@PathVariable String id) {
        return new ResponseEntity(sppService.getChildSPPs(id), HttpStatus.OK);

    }

    @GetMapping("/getUserLogin")
    @CrossOrigin(origins = "*")
    @ApiOperation(value = "Get user login", response = List.class)
    public ResponseEntity<?> getUserLogin(@RequestParam String userId, @RequestParam String password) {
        return new ResponseEntity(userService.getUserLogin(userId, Md5.encode(password)), HttpStatus.OK);
    }

    @PostMapping("/getListUpdateInfo")
    @ApiOperation(value = "Get list UpdateInfo", response = List.class)
    public ResponseEntity<?> getListUpdateInfo(@Valid @RequestBody UpdateInfoRequest request, BindingResult result) {
        return new ResponseEntity(sppCaseService.doSearch(request), HttpStatus.OK);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "Get list UpdateInfo", response = String.class)
    public ResponseEntity<?> insert(@Valid @RequestBody SppCaseInsertRequest request, BindingResult result) {
        return new ResponseEntity(sppCaseService.insert(request), HttpStatus.OK);
    }
}
