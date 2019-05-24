package JDBCUtils_2;

import java.sql.Connection;

import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;

public class Test_JDBCUtils_2 {
	public static void main(String[] args) {
		testAddUser();
	}

	@Test
	public static void testAddUser() {
		Connection con = null;
		PreparedStatement pstmt = null;
		MyDataSource dataSource = new MyDataSource();
		try {
			con = dataSource.getConnection();
			String sql = "insert into product (pname, price, categary_id) values (?, ?, ?)";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1, "TV");
			pstmt.setDouble(2, 3000);
			pstmt.setInt(3, 1);
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("insert successfully!");
			} else {
				System.out.println("insert fail!");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			dataSource.backConnection(con);
		}
	}
}
