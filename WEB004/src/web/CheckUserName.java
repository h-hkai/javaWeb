package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

public class CheckUserName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckUserName() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		boolean isExist = false;
		
		UserService service = new UserService();
		try {
			isExist = service.checkUser(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.getWriter().write("{\"isExist\":"+ isExist +"}");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
