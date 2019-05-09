package com.barrettotte.ibmiapi.qsys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/QSYS")
public class QsysController{

    @Autowired
    private QsysService qsysService;

    
    @GetMapping(value={"", "/"})
    public String index(){
        return "IBMi QSYS Endpoint";
    }

    //TEST
    @GetMapping(value={"/BOLIB", "/BOLIB/"})
    public String catalog(){
        return qsysService.getCatalog("BOLIB");
    }
}