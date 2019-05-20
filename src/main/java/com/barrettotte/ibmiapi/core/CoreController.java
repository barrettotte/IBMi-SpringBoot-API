package com.barrettotte.ibmiapi.core;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value="Core", description="IBMi basic information")
public class CoreController{

    @GetMapping(value="/")
    @ApiOperation(value="Base core API endpoint")
    public String index(){
        return "IBMi Core API<br>This API has nothing right now";
    }

}