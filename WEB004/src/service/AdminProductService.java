package service;

import java.sql.SQLException;
import java.util.List;

import dao.AdminProductDao;
import domain.Category;
import domain.Product;
import vo.Condition;
import vo.PageBean;

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

	public List<Product> searchProduct(Condition condition) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		return dao.searchProduct(condition);
	}

	public PageBean getPageBean(int currentPage, int currentCount) throws SQLException {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		pageBean.setCurrentCount(currentCount);
		
		AdminProductDao dao = new AdminProductDao();
		int totalCount = dao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		
		int totalPage = (int) Math.ceil(1.0 * totalCount / currentCount);
		pageBean.setTotalPage(totalPage);
//		System.out.println(totalPage);
		
		int index = (currentPage - 1) * currentCount;
		List<Product> productList = dao.findAllProductForPageBean(index, currentCount);
		pageBean.setProductList(productList);
//		System.out.println(index + " " + currentCount);
		return pageBean;
	}
	
}
