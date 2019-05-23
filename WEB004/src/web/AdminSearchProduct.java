package web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.Category;
import domain.Product;
import service.AdminProductService;
import vo.Condition;

public class AdminSearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminSearchProduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String[]> properties = request.getParameterMap();
		Condition condition = new Condition();

		try {
			BeanUtils.populate(condition, properties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		AdminProductService service = new AdminProductService();
		List<Product> productList = null;
		
		try {
			productList = service.searchProduct(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("condition", condition);
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
