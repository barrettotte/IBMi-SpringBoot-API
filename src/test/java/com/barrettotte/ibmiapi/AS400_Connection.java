package com.barrettotte.ibmiapi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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
public class AS400_Connection{

    @Autowired
    private AppConfig appConfig;

    final static String SQL_SELECT = "SELECT * FROM BOLIB.BOSRCTMP";

	private void printResultSet(final ResultSet rs) throws SQLException {
		final ResultSetMetaData meta = rs.getMetaData();
        System.out.println("-----------------------------\n");
        System.out.println(meta.getColumnName(1) + " : " + meta.getColumnName(2) + " : " + meta.getColumnName(3));
		while (rs.next()) {
			System.out.println(rs.getObject(1) + " : " + rs.getObject(2) + " : " + rs.getObject(3));
		}
		System.out.println("-----------------------------");
	}

    @Test
	public void testDataSource() {
		final DataSource dataSource = appConfig.dataSource();
		try{ 
            Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_SELECT);
			ResultSet rs = ps.executeQuery();
			printResultSet(rs);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}