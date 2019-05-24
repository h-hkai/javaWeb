package DBUtils;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import C3P0.C3P0Utils;

public class TestDBUtils {
	public static void main(String[] args) {
//		testAddUser();
//		testUpdateUserById();
		testDeleteUserById();
	}
	
	@Test
	public static void testDeleteUserById() {
		try {
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			String sql = "delete from product where pid = ?";
			Object[] params = {4};
			int rows = qr.update(sql, params);
			
			if (rows > 0) System.out.println("delete successfully!");
			else System.out.println("delete fail!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public static void testUpdateUserById() {
		try {
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			String sql = "update product set price = ? where pid = ?";
			Object[] params = {8000, 9};
			int rows = qr.update(sql, params);
			
			if (rows > 0) System.out.println("update successfully!");
			else System.out.println("update fail!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public static void testAddUser() {
		try {
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			String sql = "insert into product values (null, ?, ?, ?)";
			Object[] params = {"JEEP", 200, 2};
			int rows = qr.update(sql, params);
			
			if (rows > 0) System.out.println("insert successfully!");
			else System.out.println("insert fail!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
