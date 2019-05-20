package com.barrettotte.ibmiapi.qsys;

import java.sql.ResultSet;

import com.barrettotte.ibmiapi.core.AS400DAO;
import com.barrettotte.ibmiapi.util.AS400Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QsysService {

    @Autowired
    private AS400DAO as400DAO;

    public String getCatalogs(){
        try {
            final ResultSet resp = as400DAO.getCatalogs();
            return AS400Utils.convertResultSetToJSON(resp).toString(2);
        } catch(final Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String getCatalog(final String cat){
        try{
            //final ResultSet resp = as400DAO.getCatalog(cat);
            return "TODO<br>" + cat;
            //return AS400Utils.convertResultSetToJSON(resp).toString(2);
        } catch(final Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String getSchemas(final String cat){
        try{
            final ResultSet resp = as400DAO.getSchemas(cat);
            return AS400Utils.convertResultSetToJSON(resp).toString(2);
        } catch(final Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String getSchema(final String cat, final String schema){
        try{
            //final ResultSet resp = as400DAO.getSchema(cat, schema);
            return "TODO<br>" + cat + "/" + schema;
            //return AS400Utils.convertResultSetToJSON(resp).toString(2);
        } catch(final Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String getTables(final String cat, final String schema){
        try{
            final ResultSet resp = as400DAO.getTables(cat, schema);
            return AS400Utils.convertResultSetToJSON(resp).toString(2);
        } catch(final Exception e){
            return e.getMessage();
        }
    }

    public String getTable(final String cat, final String schema, final String table){
        try{
            //final ResultSet resp = as400DAO.getTable(cat, schema, table);
            return "TODO<br>" + cat + "/" + schema + "/" + table;
            //return AS400Utils.convertResultSetToJSON(resp).toString(2);
        } catch(final Exception e){
            return e.getMessage();
        }
    }

    public String getPartitions(final String cat, final String schema, final String table){
        try{
            final ResultSet resp = as400DAO.getPartitions(cat, schema, table);
            return AS400Utils.convertResultSetToJSON(resp).toString(2);
        } catch(final Exception e){
            return e.getMessage();
        }
    }

    public String getPartition(final String cat, final String schema, 
      final String table, final String partition){
        try{
            final ResultSet resp = as400DAO.getPartition(cat, schema, table, partition);
            return AS400Utils.convertResultSetToJSON(resp).toString(2);
        } catch(final Exception e){
            return e.getMessage();
        }
    }
}