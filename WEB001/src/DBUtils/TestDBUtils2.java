package DBUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import C3P0.C3P0Utils;

public class TestDBUtils2 {
	public static void main(String[] args) {
//		queryAll2();
		queryAll3();
//		queryById();
//		countNum();
	}

	public static void queryAll() {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product";
		try {
			List<User> users = qr.query(sql, new BeanListHandler<User>(User.class));
			for (User user : users)
				System.out.println(user.getPname() + " " + user.getPrice());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void queryAll2() {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product";
		try {
			List<Map<String, Object>> users = qr.query(sql, new MapListHandler());
			for (Map<String, Object> user : users)
				System.out.println(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void queryAll3() {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product";
		try {
			List<Object> users = (List<Object>) qr.query(sql, new ColumnListHandler("pname"));
			for (Object user : users)
				System.out.println(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void queryById() {
		try {
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			String sql = "select * from product where pid = ?";
			Object[] param = {3};
			User user = qr.query(sql, new BeanHandler<User>(User.class), param);
			System.out.println(user.getPname() + " " + user.getPrice());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void countNum() {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select count(*) from product";
		try {
			long num = (long)qr.query(sql, new ScalarHandler());
			System.out.println(num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
