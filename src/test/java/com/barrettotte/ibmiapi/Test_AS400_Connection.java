package com.barrettotte.ibmiapi;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.barrettotte.ibmiapi.config.AppConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AppConfig.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class Test_AS400_Connection{

    @Autowired
    private AppConfig appConfig;

    @Test
	public void testDataSource() {
		final DataSource dataSource = appConfig.dataSource();
		try{ 
			Connection conn = dataSource.getConnection();
			assertNotNull(conn);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}