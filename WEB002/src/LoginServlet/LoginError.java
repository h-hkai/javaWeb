package LoginServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import Utils.C3P0Utils;
import register.User;

/**
 * Servlet implementation class LoginError
 */
@WebServlet("/LoginError")
public class LoginError extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginError() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = null;
		try {
			user = login(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (user != null) {
			response.sendRedirect("https://www.baidu.com");
		} else {
//			response.getWriter().write("Login Error");
//			response.sendRedirect(request.getContextPath()+"/register.html");
			
			request.setAttribute("loginInfo", "Login Error");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}
	
	public User login(String username, String password) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from users where uname = ? and password = ?";
		User user = runner.query(sql, new BeanHandler<User>(User.class), username, password);
		return user;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
