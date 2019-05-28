package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import domain.User;
import utils.C3P0Utils;

public class UserDao {

	public long checkUser(String username) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select count(*) from users where uname=?";
		long count = (long) runner.query(sql, new ScalarHandler(), username);
		
		return count;
	}

	public User login(String username, String password) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from users where uname=? and password=?";
		return runner.query(sql, new BeanHandler<User>(User.class), username, password);
	}

}
