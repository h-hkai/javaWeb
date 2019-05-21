package service;

import java.sql.SQLException;
import java.util.List;

import dao.AdminProductDao;
import domain.Product;

public class AdminProductService {

	public static List<Product> findAllProduct() throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		
		return dao.findAllProduct();
	}

}
