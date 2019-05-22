package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Category;
import domain.Product;
import service.AdminProductService;

public class AdminUpdateProductUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminUpdateProductUI() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		
		AdminProductService service = new AdminProductService();
		Product product = null;
		try {
			product = service.findProductByPid(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<Category> categoryList = null;
		try {
			categoryList = service.findAllCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("product", product);
		
		request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
