package com.barrettotte.ibmiapi.core;

import java.sql.SQLException;

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

    public String hello() throws SQLException {
        return jdbcTemplate.getDataSource().getConnection().toString();
    }

}