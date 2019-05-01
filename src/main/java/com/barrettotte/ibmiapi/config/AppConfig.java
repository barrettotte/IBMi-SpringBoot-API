package com.barrettotte.ibmiapi.config;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.barrettotte.ibmiapi.core.AS400DAO;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class AppConfig{

    @Bean
    @Primary
    @ConfigurationProperties("db.datasource.as400")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource dataSource(){
        return dataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @Primary
    public JdbcTemplate JdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    @Primary
    public Connection connection() throws SQLException{
        return dataSource().getConnection();
    }

    public AS400DAO as400DAO(final JdbcTemplate jdbcTemplate){
        return new AS400DAO(jdbcTemplate);
    }

}