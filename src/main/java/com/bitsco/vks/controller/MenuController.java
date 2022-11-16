package com.bitsco.vks.controller;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.AdmFunctionsRequestDTO;
import com.bitsco.vks.dto.MenuDTO;
import com.bitsco.vks.exception.CommonException;
import com.bitsco.vks.response.Response;
import com.bitsco.vks.response.ResponseBody;
import com.bitsco.vks.service.MenuService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/dm/AdmGrant")
public class MenuController {
    private static final Logger LOGGER = LogManager.getLogger("DB");
    @Autowired
    private MenuService menuService;

    @GetMapping("/getFnTreeForGroup")
    @ApiOperation(value = "get lst adm groups", response = List.class)
    private ResponseEntity<?> getLst(@RequestParam @Valid String groupid, @RequestParam String module) {
        return new ResponseEntity<>(menuService.getFunctionsTreeForGroup(module, groupid), HttpStatus.OK);
    }

    @PostMapping("/saveGrantFnsToGroup")
    @ApiOperation(value = "handle inser or update adm group", response = String.class)
    private ResponseEntity<?> save(@RequestBody AdmFunctionsRequestDTO req, HttpServletRequest http) {
        return new ResponseEntity<>(menuService.grantFunctionsToGroup(req, http.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @GetMapping("/getFnTreeForUser")
    @ApiOperation(value = "get lst adm user", response = List.class)
    private ResponseEntity<?> getLstUser(@RequestParam @Valid String userid, @RequestParam String module) {
        return new ResponseEntity<>(menuService.getFunctionsTreeForUser(userid, module), HttpStatus.OK);
    }

    @PostMapping("/saveGrantFnsToUser")
    @ApiOperation(value = "handle inser or update adm user", response = String.class)
    private ResponseEntity<?> saveUser(@RequestBody AdmFunctionsRequestDTO req, HttpServletRequest http) {
        return new ResponseEntity<>(menuService.grantFunctionsToUser(req, http.getHeader(Constant.KEY.USERNAME)), HttpStatus.OK);
    }

    @GetMapping("/getLstGroupOfSpp")
    @ApiOperation(value = "get lst groups of spp", response = List.class)
    private ResponseEntity<?> getLstGroupsOfSpp(@RequestParam String csppid, @RequestParam String sppid) {
        return new ResponseEntity<>(menuService.getLstGroupSpp(csppid, sppid), HttpStatus.OK);
    }

    @GetMapping("/getLstGroupUser")
    @ApiOperation(value = "get lst groups of user", response = List.class)
    private ResponseEntity<?> getLstGroupToUser(@RequestParam String userid, @RequestParam String sppid) {
        return new ResponseEntity<>(menuService.getGroups(userid, sppid), HttpStatus.OK);
    }

    @PostMapping("/saveGrantGroupsToUser")
    @ApiOperation(value = "handle inser or update adm groups user", response = String.class)
    private ResponseEntity<?> saveGroupsUser(@RequestBody AdmFunctionsRequestDTO req, HttpServletRequest http) {
        try {
            return new ResponseEntity<>(new ResponseBody(Response.SUCCESS, Response.SUCCESS.getResponseMessage(),
                    menuService.grantGroupsToUser(req.getUserid(), req.getLstGroups(), http.getHeader(Constant.KEY.USERNAME))), HttpStatus.OK);
        } catch (CommonException e) {
            return new ResponseEntity<>(new ResponseBody(e.getResponse().getResponseCode(), e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseBody(Response.SYSTEM_ERROR, e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/getMenuByModule")
    @ApiOperation(value = "get lst menu by module and username", response = List.class)
    private ResponseEntity<?> getMenu(@RequestBody MenuDTO req) {
        try {
            return new ResponseEntity<>(menuService.getMenuByModule(req.getModule(), req.getUsername()), HttpStatus.OK);
        } catch (CommonException e) {
            return new ResponseEntity<>(new ResponseBody(e.getResponse().getResponseCode(), e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseBody(Response.SYSTEM_ERROR, e.getMessage()), HttpStatus.OK);
        }
    }
}

