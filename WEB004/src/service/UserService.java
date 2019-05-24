package service;

import java.sql.SQLException;

import dao.UserDao;

public class UserService {

	public boolean checkUser(String username) throws SQLException {
		UserDao dao = new UserDao();
		long count = dao.checkUser(username);
		return count > 0 ? true : false;
	}

}
