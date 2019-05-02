package Utils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	
	static {
        try {
			ds.setDriverClass("com.mysql.jdbc.Driver");
			ds.setJdbcUrl("jdbc:mysql://localhost:3306/web002");
	        ds.setUser("root");
	        ds.setPassword("028110");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource() {
		return ds;
	}
	
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
