package com.barrettotte.ibmiapi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeAll;
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
public class Test_AS400_Members{

    @Autowired
	private AppConfig appConfig;
	private final static HashMap<String, String> schemaMap = new HashMap<>();

	@BeforeAll
	public static void setUp() throws Exception {
		schemaMap.put("QTEMP.BOTMPRPGLE", "BOLIB.QRPGLESRC(FIZZBUZZ)");
		schemaMap.put("QTEMP.BOTMPCL",    "BOLIB.QCLLESRC(FIRSTCL)");
		schemaMap.put("QTEMP.BOTMPRPG",   "BOLIB.QRPGSRC(HELLORPG)");
		schemaMap.put("QTEMP.BOTMPDDS",   "BOLIB.QDDSSRC(HXCVTDSP)");
	}

	private void resultSetAsString(final ResultSet rs) throws SQLException {
		if(rs.next()){
			final ResultSetMetaData meta = rs.getMetaData();
			final int colCount = meta.getColumnCount();
			String outStr = "\n--------------------------------\n";
			for(int i = 1; i <= colCount; i++){
				outStr += meta.getColumnName(i);
				outStr += (i < colCount) ? " : " : " ";
			}
			outStr += "\n";
			while(rs.next()) {
				for(int i = 1; i <= colCount; i++){
					outStr += rs.getObject(i);
					outStr += (i < colCount) ? " : " : " ";
				}
				outStr += "\n";
			}
			outStr += "--------------------------------\n";
			System.out.println(outStr);
		}
	}

	private void createAlias(final Connection conn, final String alias, final String src) throws SQLException {
		final Statement create = conn.createStatement();
		create.execute("CREATE OR REPLACE ALIAS " + alias + " FOR " + src);
		create.close();
	}

	private ResultSet selectMember(final Connection conn, final String alias) throws SQLException {
		final String sql = "SELECT * FROM " + alias + " WITH UR";
		final PreparedStatement ps = conn.prepareStatement(sql);
		final ResultSet rs = ps.executeQuery();
		return rs;
	}
	
	private void dropAlias(final Connection conn, final String alias) throws SQLException {
		final Statement drop = conn.createStatement();
		drop.execute("DROP ALIAS " + alias);
		drop.close();
	}

    @Test
	public void testMember() {
		final DataSource dataSource = appConfig.dataSource();
		try{
			final Connection conn = dataSource.getConnection();
			for(final Map.Entry<String, String> entry : schemaMap.entrySet()){
				createAlias(conn, entry.getKey(), entry.getValue());
				final ResultSet rs = selectMember(conn, entry.getKey());
				resultSetAsString(rs);
				rs.close();
				dropAlias(conn, entry.getKey());
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}

