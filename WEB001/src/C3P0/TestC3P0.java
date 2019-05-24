package C3P0;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import org.junit.Test;

public class TestC3P0 {
	public static void main(String[] args) {
		testC3P0();
	}
	
	@Test
	public static void testC3P0() {
		Connection con = null;
		PreparedStatement pstmt = null;
//		ComboPooledDataSource ds = new ComboPooledDataSource();
		
		try {
			con = C3P0Utils.getConnection();
			String sql = "insert into product (pname, price, categary_id) values (?, ?, ?)";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1, "T-shirt");
			pstmt.setDouble(2, 300);
			pstmt.setInt(3, 2);
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("insert successfully!");
			} else {
				System.out.println("insert fail!");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
