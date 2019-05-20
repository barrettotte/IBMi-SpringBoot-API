package com.barrettotte.ibmiapi.core;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.barrettotte.ibmiapi.exception.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AS400DAO implements IAS400Statements{

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public AS400DAO(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public ResultSet getCatalogs() throws ServiceException {
        try{
            final Connection conn = jdbcTemplate.getDataSource().getConnection();
            final CallableStatement cs = conn.prepareCall(AS400_GET_CATALOGS);
            cs.setQueryTimeout(DEFAULT_TIMEOUT_SECS);
            return cs.executeQuery();
        } catch(final SQLException e){
            e.printStackTrace();
            throw new ServiceException("SQL error occurred querying catalogs");
        }
    }

    public ResultSet getCatalog(final String cat) throws ServiceException {
        try{
            final Connection conn = jdbcTemplate.getDataSource().getConnection();
            final CallableStatement cs = conn.prepareCall(AS400_GET_CATALOG);
            cs.setQueryTimeout(DEFAULT_TIMEOUT_SECS);
            cs.setString(1, cat.toUpperCase());
            return cs.executeQuery();
        } catch(final SQLException e){
            e.printStackTrace();
            throw new ServiceException("SQL error occurred querying catalog");
        }
    }

    public ResultSet getSchemas(final String cat) throws ServiceException {
        try{
            final Connection conn = jdbcTemplate.getDataSource().getConnection();
            final CallableStatement cs = conn.prepareCall(AS400_GET_SCHEMAS);
            cs.setQueryTimeout(DEFAULT_TIMEOUT_SECS);
            cs.setString(1, cat.toUpperCase());
            return cs.executeQuery();
        } catch(final SQLException e){
            e.printStackTrace();
            throw new ServiceException("SQL error occurred querying libraries");
        }
    }

    public ResultSet getSchema(final String cat, final String schema) throws ServiceException {
        try{
            final Connection conn = jdbcTemplate.getDataSource().getConnection();
            final CallableStatement cs = conn.prepareCall(AS400_GET_SCHEMA);
            cs.setQueryTimeout(DEFAULT_TIMEOUT_SECS);
            cs.setString(1, cat.toUpperCase());
            cs.setString(2, schema.toUpperCase());
            return cs.executeQuery();
        } catch(final SQLException e){
            e.printStackTrace();
            throw new ServiceException("SQL error occurred querying library");
        }
    }

    public ResultSet getTables(final String cat, final String schema) throws ServiceException {
        try{
            final Connection conn = jdbcTemplate.getDataSource().getConnection();
            final CallableStatement cs = conn.prepareCall(AS400_GET_TABLES);
            cs.setQueryTimeout(DEFAULT_TIMEOUT_SECS);
            cs.setString(1, cat.toUpperCase());
            cs.setString(2, schema.toUpperCase());
            return cs.executeQuery();
        } catch(final SQLException e){
            e.printStackTrace();
            throw new ServiceException("SQL error occurred querying files");
        }
    }

    public ResultSet getTable(final String cat, final String schema, 
      final String table) throws ServiceException {
        try{
            final Connection conn = jdbcTemplate.getDataSource().getConnection();
            final CallableStatement cs = conn.prepareCall(AS400_GET_TABLE);
            cs.setQueryTimeout(DEFAULT_TIMEOUT_SECS);
            cs.setString(1, cat.toUpperCase());
            cs.setString(2, schema.toUpperCase());
            cs.setString(3, table.toUpperCase());
            return cs.executeQuery();
        } catch(final SQLException e){
            e.printStackTrace();
            throw new ServiceException("SQL error occurred querying file");
        }
    }

    public ResultSet getPartitions(final String cat, final String schema, 
      final String table) throws ServiceException {
        try{
            final Connection conn = jdbcTemplate.getDataSource().getConnection();
            final CallableStatement cs = conn.prepareCall(AS400_GET_PARTITIONS);
            cs.setQueryTimeout(DEFAULT_TIMEOUT_SECS);
            cs.setString(1, schema.toUpperCase());
            cs.setString(2, table.toUpperCase());
            return cs.executeQuery();
        } catch(final SQLException e){
            e.printStackTrace();
            throw new ServiceException("SQL error occurred querying members");
        }
    }

    public ResultSet getPartition(final String cat, final String schema, final String table, 
      final String partition) throws ServiceException {
        try{
            final String alias = (cat + ".QTEMP.TMP"
              + (table.length() > 6 ? table.substring(0, 5) : table)).toUpperCase();
            final String src = (cat + "." + schema + "." + table + "(" + partition + ")").toUpperCase();
            final Connection conn = jdbcTemplate.getDataSource().getConnection();

            createAlias(conn, alias, src);
            final ResultSet rs = selectMember(conn, alias);
            dropAlias(conn, alias);
            return rs;
        } catch(final SQLException e){
            e.printStackTrace();
            throw new ServiceException("SQL error occurred querying member");
        }
    }

    private void createAlias(final Connection conn, final String alias, final String src) throws SQLException {
        final Statement create = conn.createStatement();
		create.execute("CREATE OR REPLACE ALIAS " + alias + " FOR " + src);
		create.close();
    }

    private void dropAlias(final Connection conn, final String alias) throws SQLException {
		final Statement drop = conn.createStatement();
		drop.execute("DROP ALIAS " + alias);
		drop.close();
    }
    
    private ResultSet selectMember(final Connection conn, final String alias) throws SQLException {
		final String sql = "SELECT * FROM " + alias + " WITH UR";
		final PreparedStatement ps = conn.prepareStatement(sql);
		final ResultSet rs = ps.executeQuery();
		return rs;
	}

}