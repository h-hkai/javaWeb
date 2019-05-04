package context;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/ServletContext2" })
public class ServletContext2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		System.out.println("work in init() ....");
		int count = 0;
		this.getServletContext().setAttribute("count", count);
	}

    public ServletContext2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		javax.servlet.ServletContext context = getServletContext();
		String initParameter = context.getInitParameter("driver");
		System.out.println(initParameter);
		
		String realPath_a = context.getRealPath("/a.txt");
		System.out.println(realPath_a);
		response.getWriter().write(realPath_a);
		
		context.setAttribute("name", "Tom");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
