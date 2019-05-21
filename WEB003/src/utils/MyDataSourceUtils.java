package utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MyDataSourceUtils {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	public static void startTransaction() throws SQLException {
		Connection conn = getCurConnection();
		conn.setAutoCommit(false);
	}
	
	public static Connection getCurConnection() throws SQLException {
		Connection conn = tl.get();
		if (conn == null) {
			conn = getConnection();
			tl.set(conn);
		}
		return conn;
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	public static void rollback() throws SQLException {
		getCurConnection().rollback();
	}

	public static void commit() throws SQLException {
		Connection conn = getCurConnection();
		conn.commit();
		
		tl.remove();
		conn.close();
	}
}
