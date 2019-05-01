package com.barrettotte.ibmiapi.information;


import java.sql.SQLException;

import com.barrettotte.ibmiapi.core.AS400DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationService{

    @Autowired
    private AS400DAO as400DAO;

    public String hello(){
        try{
            final String resp = as400DAO.hello();
            return "Hello World" + "<br>" + resp;
        } catch(SQLException e){
            return "ERROR";
        }
    }

}