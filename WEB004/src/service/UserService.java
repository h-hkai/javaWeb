package service;

import java.sql.SQLException;

import dao.UserDao;
import domain.User;

public class UserService {

	public boolean checkUser(String username) throws SQLException {
		UserDao dao = new UserDao();
		long count = dao.checkUser(username);
		return count > 0 ? true : false;
	}

	public User login(String username, String password) throws SQLException {
		UserDao dao = new UserDao();
		
		return dao.login(username, password);
	}

}
