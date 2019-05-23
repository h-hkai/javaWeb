package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import service.AdminProductService;
import vo.PageBean;

public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminProductService service = new AdminProductService();
		PageBean<Product> pageBean = null;
		String getCurrentPage = request.getParameter("currentPage");
		
		int currentPage = 1;
		if (getCurrentPage != null)
			currentPage = Integer.parseInt(getCurrentPage);
		int currentCount = 2;
		
		try {
			pageBean = service.getPageBean(currentPage, currentCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
