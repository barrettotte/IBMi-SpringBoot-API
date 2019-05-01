package com.barrettotte.ibmiapi;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.barrettotte.ibmiapi.config.AppConfig;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@JdbcTest
@SpringBootTest(classes={AppConfig.class})
public class AS400_Connection{

    @Autowired
    private AppConfig appConfig;

    @Test
    public void testDataSource(){
        final DataSource dataSource = appConfig.dataSource();
        try{
            Connection conn = dataSource.getConnection();
            assertNotNull(conn);
        } catch(final Exception e){
            e.printStackTrace();
        }
    }
}