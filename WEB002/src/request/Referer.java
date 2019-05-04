package request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class referer
 */
@WebServlet("/Referer")
public class Referer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Referer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		System.out.println("method: " + method);
		
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("uri: " + requestURI);
		System.out.println("url: " + requestURL);
		
		String contextPath = request.getContextPath();
		System.out.println("contextPath: " + contextPath);
		
		String queryString = request.getQueryString();
		System.out.println(queryString);
		
		String remoteAddr = request.getRemoteAddr();
		System.out.println(remoteAddr);
		
		String header = response.getHeader("referer");
		if (header != null && header.startsWith("http://localhost")) {
//			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("test news!");
		} else {
			response.getWriter().write("You are a thief.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
