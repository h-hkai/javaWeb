package service;

import java.sql.SQLException;
import java.util.List;

import dao.UserDao;
import domain.User;

public class UserService {

	public List<User> findAllUsers() throws SQLException {
		UserDao dao = new UserDao();
		
		return dao.findAllUsers();
	}

}
