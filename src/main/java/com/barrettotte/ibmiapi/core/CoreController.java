package com.barrettotte.ibmiapi.core;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CoreController{

    @GetMapping("/")
    public String index(){
        return "IBMi Core API";
    }

}