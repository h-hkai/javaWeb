package context;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletContext3")
public class ServletContext3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String attribute = (String)this.getServletContext().getAttribute("name");
		System.out.println(attribute);
		
		Integer count = (Integer) this.getServletContext().getAttribute("count");
		count += 1;
		System.out.println(count);
		this.getServletContext().setAttribute("count", count);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
