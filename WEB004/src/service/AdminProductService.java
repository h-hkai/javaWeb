package service;

import java.sql.SQLException;
import java.util.List;

import dao.AdminProductDao;
import domain.Category;
import domain.Product;

public class AdminProductService {

	public static List<Product> findAllProduct() throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		
		return dao.findAllProduct();
	}

	public List<Category> findAllCategory() throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		return dao.findAllCategory();
	}

	public void addProduct(Product product) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		dao.addProduct(product);
	}

	public void delProduct(String pid) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		dao.delProduct(pid);
	}

	public Product findProductByPid(String pid) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		return dao.findProductByPid(pid);
	}

	public void updateProduct(Product product) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		dao.updateProduct(product);
	}

}
