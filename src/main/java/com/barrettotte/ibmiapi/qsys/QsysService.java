package com.barrettotte.ibmiapi.qsys;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.barrettotte.ibmiapi.core.AS400DAO;
import com.barrettotte.ibmiapi.util.AS400Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QsysService {

    @Autowired
    private AS400DAO as400DAO;

    public String getCatalog(final String cat) {
        try {
            final List<String> cols = new ArrayList<>(Arrays.asList(
                "SYSTEM_TABLE_SCHEMA", 
                "SYSTEM_TABLE_NAME", 
                "SYSTEM_TABLE_MEMBER"
            )); //TODO: Does this belong at this level????
            final ResultSet resp = as400DAO.getCatalog(cat, cols);
            return AS400Utils.convertResultSetToJSON(resp).toString(2);
            //Closing ResultSet or PreparedStatement???
        } catch(SQLException e){
            return "Error occurred executing SQL query.";
        } catch(Exception e){
            return "Error occurred parsing JSON result set.";
        }
    }

}