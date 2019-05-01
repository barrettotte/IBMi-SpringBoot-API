package com.barrettotte.ibmiapi.information;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/info")
public class InformationController{

    @Autowired
    private InformationService infoService;


    @GetMapping(value={"", "/"})
    public String index(){
        return "IBMi Information Endpoint";
    }

    @GetMapping("/hello")
    public String hello(){
        return infoService.hello();
    }
}