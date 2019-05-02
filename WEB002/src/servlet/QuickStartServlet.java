package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class QuickStartServlet implements Servlet{

	@Override
	public void destroy() {
		
	}

	@Override
	public ServletConfig getServletConfig() {
		
		return null;
	}

	@Override
	public String getServletInfo() {
		
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		String servletName = config.getServletName();
		System.out.println(servletName);
		
		String initParameter = config.getInitParameter("url");
		System.out.println(initParameter);
		
		ServletContext servletConfig = config.getServletContext();
		System.out.println(servletConfig);
		
		System.out.println("init running!");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("QuickStartServlet running!");
		
	}

}
