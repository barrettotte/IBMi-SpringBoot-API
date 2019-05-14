package com.barrettotte.ibmiapi.core;

import com.barrettotte.ibmiapi.core.AS400DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoreService{

    @Autowired
    private AS400DAO as400DAO;

    //Meh, I don't really know what I should put in here
}