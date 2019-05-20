package com.barrettotte.ibmiapi.qsys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1/qsys")
@Api(value="QSYS", description="IBMi system information")
public class QsysController{

    @Autowired
    private QsysService qsysService;

    @GetMapping("")
    @ApiOperation(value="Base QSYS endpoint")
    public String index(){
        return "IBMi QSYS Endpoint";
    }
    
    @GetMapping("/catalogs")
    @ApiOperation(value="View available relational databases")
    public String catalogs(){
        return qsysService.getCatalogs();
    }

    @GetMapping("/catalogs/{cat}")
    @ApiOperation(value="View a relational database")
    public String catalog(
      @ApiParam(value = "Name of relational database", required=true) 
      @PathVariable("cat") final String cat
    ){
        return qsysService.getCatalog(cat);
    }

    @GetMapping("/catalogs/{cat}/schemas")
    @ApiOperation(value="View available libraries in relational database")
    public String schemas(
      @ApiParam(value = "Name of relational database", required=true) 
      @PathVariable("cat") final String cat
    ){
        return qsysService.getSchemas(cat);
    }

    @GetMapping("/catalogs/{cat}/schemas/{schema}")
    @ApiOperation(value="View a library")
    public String schema(
      @ApiParam(value = "Name of relational database", required=true) 
      @PathVariable("cat") final String cat, 
      @ApiParam(value = "Name of library", required=true) 
      @PathVariable("schema") final String schema)
    {
        return qsysService.getSchema(cat, schema);
    }
    
    @GetMapping("/catalogs/{cat}/schemas/{schema}/tables")
    @ApiOperation(value="View available files in a library")
    public String tables(
      @ApiParam(value = "Name of relational database", required=true) 
      @PathVariable("cat") final String cat,
      @ApiParam(value = "Name of library", required=true) 
      @PathVariable("schema") final String schema)
    {
        return qsysService.getTables(cat, schema);
    }
    
    @GetMapping("/catalogs/{cat}/schemas/{schema}/tables/{table}")
    @ApiOperation(value="View a file")
    public String table(
      @ApiParam(value = "Name of relational database", required=true) 
      @PathVariable("cat") final String cat,
      @ApiParam(value = "Name of library", required=true) 
      @PathVariable("schema") final String schema,
      @ApiParam(value = "Name of file", required=true) 
      @PathVariable("table") final String table
    ){
        return qsysService.getTable(cat, schema, table);
    }

    @GetMapping("/catalogs/{cat}/schemas/{schema}/tables/{table}/partitions")
    @ApiOperation(value="View available members in a file")
    public String partitions(
      @ApiParam(value = "Name of relational database", required=true) 
      @PathVariable("cat") final String cat,
      @ApiParam(value = "Name of library", required=true) 
      @PathVariable("schema") final String schema,
      @ApiParam(value = "Name of file", required=true) 
      @PathVariable("table") final String table
    ){
        return qsysService.getPartitions(cat, schema, table);
    }

    @GetMapping("/catalogs/{cat}/schemas/{schema}/tables/{table}/partitions/{partition}")
    @ApiOperation(value="View a member")
    public String partition(
      @ApiParam(value = "Name of relational database", required=true) 
      @PathVariable("cat") final String cat,
      @ApiParam(value = "Name of library", required=true) 
      @PathVariable("schema") final String schema,
      @ApiParam(value = "Name of file", required=true) 
      @PathVariable("table") final String table,
      @ApiParam(value = "Name of member", required=true) 
      @PathVariable("partition") final String partition
    ){
        return qsysService.getPartition(cat, schema, table, partition);
    }

}