package register;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import Utils.C3P0Utils2;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
//		String password = request.getParameter("password");
		
		username = new String(username.getBytes("iso8859-1"), "UTF-8");
//		
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword(password);
		
//		request.setCharacterEncoding("UTF-8");
		
		User user = new User();
		Map<String, String[]> properties = request.getParameterMap();
		
		try {
			BeanUtils.populate(user, properties);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
//		user.setUid(null);
		
		regist(user);
		
		response.sendRedirect(request.getContextPath() + "/login.jsp");
		
	}

	public void regist(User user) {
		QueryRunner runner = new QueryRunner(C3P0Utils2.getDataSource());
		String sql = "insert into users (uname, password) values (?, ?)";
		try {
			runner.update(sql, user.getUsername(), user.getPassword());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
