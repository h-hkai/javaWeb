package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Category;
import service.AdminProductService;

public class AdminAddProductUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminAddProductUI() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	response.setContentType("text/html; charset=UTF-8");
		AdminProductService service = new AdminProductService();
		
		List<Category> categoryList = null;
		try {
			categoryList = service.findAllCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("categoryList", categoryList);
		
		request.getRequestDispatcher("/admin/product/add.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
