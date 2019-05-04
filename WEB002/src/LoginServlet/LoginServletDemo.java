package LoginServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;


import Utils.C3P0Utils;
import domain.User;

public class LoginServletDemo extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		int count = 0;
		this.getServletContext().setAttribute("count", count);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String sql = "select * from users where uname=? and password=?";
		User user = null;
		
		int count = (int) this.getServletContext().getAttribute("count");
		
		
		try {
			QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
			user = runner.query(sql, new BeanHandler<User>(User.class), username, password);
			if (user != null) response.getWriter().write(user.toString() + count);
			else response.getWriter().write("login fail");
			this.getServletContext().setAttribute("count", count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
