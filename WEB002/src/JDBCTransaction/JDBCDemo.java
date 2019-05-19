package JDBCTransaction;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class JDBCDemo {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = (Connection) DriverManager.getConnection("jdbc:mysql:///web002", "root", "028110");
			
			conn.setAutoCommit(false);
			
			Statement stmt = (Statement) conn.createStatement();
//			stmt.executeUpdate("insert into users values (null, 'Lucy', '123456')");
			stmt.executeUpdate("update users set password='258369' where uname='Luucy'");
			
			conn.commit();
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
}
