package com.barrettotte.ibmiapi.qsys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/qsys")
public class QsysController{

    @Autowired
    private QsysService qsysService;

    
    @GetMapping("")
    public String index(){
        return "IBMi QSYS Endpoint";
    }

    @GetMapping("/catalogs")
    public String catalogs(){
        return qsysService.getCatalogs();
    }

    @GetMapping("/catalogs/{cat}")
    public String catalog(@PathVariable("cat") final String cat){
        return qsysService.getCatalog(cat);
    }

    @GetMapping("/catalogs/{cat}/schemas")
    public String schemas(@PathVariable("cat") final String cat){
        return qsysService.getSchemas(cat);
    }

    @GetMapping("/catalogs/{cat}/schemas/{schema}")
    public String schema(
      @PathVariable("cat") final String cat, 
      @PathVariable("schema") final String schema)
    {
        return qsysService.getSchema(cat, schema);
    }

    @GetMapping("/catalogs/{cat}/schemas/{schema}/tables")
    public String tables(
      @PathVariable("cat") final String cat,
      @PathVariable("schema") final String schema)
    {
        return qsysService.getTables(cat, schema);
    }
    
    @GetMapping("/catalogs/{cat}/schemas/{schema}/tables/{table}")
    public String table(
      @PathVariable("cat") final String cat,
      @PathVariable("schema") final String schema,
      @PathVariable("table") final String table
    ){
        return qsysService.getTable(cat, schema, table);
    }

    @GetMapping("/catalogs/{cat}/schemas/{schema}/tables/{table}/partitions")
    public String partitions(
        @PathVariable("cat") final String cat,
        @PathVariable("schema") final String schema,
        @PathVariable("table") final String table
    ){
        return qsysService.getPartitions(cat, schema, table);
    }

    @GetMapping("/catalogs/{cat}/schemas/{schema}/tables/{table}/partitions/{partition}")
    public String partition(
        @PathVariable("cat") final String cat,
        @PathVariable("schema") final String schema,
        @PathVariable("table") final String table,
        @PathVariable("partition") final String partition
    ){
        return qsysService.getPartition(cat, schema, table, partition);
    }

}