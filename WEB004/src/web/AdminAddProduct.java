package web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.Product;
import service.AdminProductService;

public class AdminAddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminAddProduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> properties = request.getParameterMap();
		
		Product product = new Product();
		AdminProductService service = new AdminProductService();

		try {
			BeanUtils.populate(product, properties);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		product.setPid(UUID.randomUUID().toString());
		product.setPimage("test.jpg");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String pdate = format.format(new Date());
		product.setPdate(pdate);
		
//		System.out.println(product.toString());
		
		try {
			service.addProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+"/adminProductListServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
