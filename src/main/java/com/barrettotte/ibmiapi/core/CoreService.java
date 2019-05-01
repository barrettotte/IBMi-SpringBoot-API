package com.barrettotte.ibmiapi.core;

import com.barrettotte.ibmiapi.core.AS400DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoreService{

    @Autowired
    private AS400DAO as400DAO;

    public String Hello(){
        return "Hello World";
    }

}