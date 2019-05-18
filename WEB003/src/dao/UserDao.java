package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.User;
import utils.C3P0Utils;

public class UserDao {
	public List<User> findAllUsers() throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from users";
		List<User> userList = runner.query(sql, new BeanListHandler<User>(User.class));

		return userList;
	}
}
