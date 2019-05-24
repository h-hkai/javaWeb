package DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

public class TestDBCP {
	public static void main(String[] args) {
		testUpdateById();
	}
	
	@Test
	public static void testUpdateById() {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBCPUtils.getConnection();
			String sql = "update product set price = ? where pid = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, 4000);
			pstmt.setInt(2, 8);
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("update successfully!");
			} else {
				System.out.println("update fail!");
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
