package JDBCUtils_2;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class MyDataSource implements DataSource{
	private static LinkedList<Connection> pool = new LinkedList<Connection>();
	
	static {
		for (int i = 0; i < 5; ++i) {
			Connection con = JDBCUtils_v1.getConnection();
			pool.add(con);
		}
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		Connection con = null;
		if (pool.size() == 0) {
			for (int i = 0; i < 5; ++i) {
				con = JDBCUtils_v1.getConnection();
				pool.add(con);
			}
		}
		con = pool.remove(0);
		return con;
	}
	
	public void backConnection(Connection con) {
		pool.add(con);
	}
	
	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Connection getConnection(String arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
