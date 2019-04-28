package JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class test {
	
	public static void main(String[] args) {
//		testFindUserById();
//		testAdd();
//		testDeleteId();
		testUpdateById();
	}
	
	public static void testUpdateById() {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtils_v3.getConnection();
			String sql = "update product set price = ? where pid = ?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, 135);
			pstmt.setInt(2, 3);
			int row = pstmt.executeUpdate();
			if (row > 0) {
				System.out.println("update successfully!");
			} else {
				System.out.println("update fail");
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally {
			JDBCUtils_v3.release(con, pstmt, null);
		}
	}
	
	public static void testDeleteId() {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtils_v3.getConnection();
			String sql = "delete from product where pid = ?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, 1);
			int row = pstmt.executeUpdate();
			if (row > 0) {
				System.out.println("delete successfully!");
			} else {
				System.out.println("delete fail");
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally {
			JDBCUtils_v3.release(con, pstmt, null);
		}
	}
	
	public static void testAdd() {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtils_v2.getConnection();
			String sql = "insert into product (pname, price, categary_id) values (?, ?, ?)";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1, "sweater");
			pstmt.setDouble(2, 200);
			pstmt.setInt(3, 3);
			int row = pstmt.executeUpdate();
			if (row > 0) {
				System.out.println("insert successfully!");
			} else {
				System.out.println("insert fail");
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally {
			JDBCUtils_v2.release(con, pstmt, null);
		}
	}
	
	public static void testFindUserById() {
		
		Connection con = JDBCUtils_v1.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from categary where cid = ?";
		try {
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, 2);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils_v1.release(con, pstmt, rs);
		}
	}
}
