package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import domain.Category;
import domain.Product;
import utils.C3P0Utils;
import vo.Condition;
import vo.PageBean;

public class AdminProductDao {

	public List<Product> findAllProduct() throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from products";
		List<Product> productList = runner.query(sql, new BeanListHandler<Product>(Product.class));
		
		return productList;
	}

	public List<Category> findAllCategory() throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from category";
		List<Category> categoryList = runner.query(sql, new BeanListHandler<Category>(Category.class));
		
		return categoryList;
	}

	public void addProduct(Product product) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into products values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		runner.update(sql, product.getPname(), product.getMarket_price(), 
					  product.getShop_price(), product.getPimage(), product.getPdate(), product.getIs_hot(),
					  product.getPdesc(), product.getPflag(), product.getCid(), product.getPid());

	}

	public void delProduct(String pid) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "delete from products where pid=?";
		runner.update(sql, pid);
	}

	public Product findProductByPid(String pid) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from products where pid=?";
		Product product = runner.query(sql, new BeanHandler<Product>(Product.class), pid);
		return product;
	}

	public void updateProduct(Product product) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "update products set pname=?, market_price=?, shop_price=?, pimage=?, pdate=?,"
				+ "					   is_hot=?, pdesc=?, pflag=?, cid=? where pid=?";
		
		runner.update(sql, product.getPname(), product.getMarket_price(), 
					  product.getShop_price(), product.getPimage(), product.getPdate(), product.getIs_hot(),
					  product.getPdesc(), product.getPflag(), product.getCid(), product.getPid());
	}

	public List<Product> searchProduct(Condition condition) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from products where 1=1";
		List<String> params = new ArrayList<String>();
		if (condition.getPname() != null && condition.getPname().trim().length() != 0) {
			sql += " and pname like ? ";
			params.add("%" + condition.getPname().trim() + "%");
		}
		if (condition.getIs_hot() != null && condition.getIs_hot().trim().length() != 0) {
			sql += " and is_hot=? ";
			params.add(condition.getIs_hot());
		}
		if (condition.getCid() != null && condition.getCid().trim().length() != 0) {
			sql += " and cid=?";
			params.add(condition.getCid());
		}

		List<Product> productList = runner.query(sql, new BeanListHandler<Product>(Product.class), params.toArray());
		
		return productList;
		
	}

	public int getTotalCount() throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select count(*) from products";
		Long totalCount = (Long) runner.query(sql, new ScalarHandler());
		return totalCount.intValue();
	}

	public List<Product> findAllProductForPageBean(int index, int currentCount) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from products limit ?,?";
		return runner.query(sql, new BeanListHandler<Product>(Product.class), index, currentCount);
	}

}
