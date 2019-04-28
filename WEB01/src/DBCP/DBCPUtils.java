package DBCP;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtils {
	private static DataSource dataSource;
	static {
		try {
			InputStream in = DBCPUtils.class.getClassLoader().getResourceAsStream("db.properties");
			Properties props = new Properties();
			props.load(in);
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getDateSource() {
		return dataSource;
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
