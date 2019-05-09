package com.barrettotte.ibmiapi.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.barrettotte.ibmiapi.util.AS400Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AS400DAO {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public AS400DAO(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ResultSet getCatalog(final String cat, final List<String> cols) throws SQLException {
        return getCatalog(cat, AS400Utils.columnListString(cols));
    }
    public ResultSet getCatalog(final String cat, final String cols) throws SQLException {
        final Connection conn = jdbcTemplate.getDataSource().getConnection();
        final String sql = "SELECT " + cols + " FROM QSYS2.SYSPARTITIONSTAT WHERE TABLE_SCHEMA = '" + cat + "'";
        final PreparedStatement ps = conn.prepareStatement(sql);
        final ResultSet rs = ps.executeQuery();
        return rs;
    }

}