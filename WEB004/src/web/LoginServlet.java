package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserService service = new UserService();
		
		User user = null;
		
		try {
			user = service.login(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (user != null) {
			String autoLogin = request.getParameter("autoLogin");
			if (autoLogin != null) {
				Cookie cookie_username = new Cookie("cookie_username", user.getUname());
				Cookie cookie_password = new Cookie("cookie_password", user.getPassword());
				cookie_username.setMaxAge(60 * 60);
				cookie_password.setMaxAge(60 * 60);
				cookie_username.setPath(request.getContextPath());
				cookie_password.setPath(request.getContextPath());
				
				response.addCookie(cookie_username);
				response.addCookie(cookie_password);
			}
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("loginInfo", "Login failed!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
