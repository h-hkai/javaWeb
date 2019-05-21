package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.Product;
import utils.C3P0Utils;

public class AdminProductDao {
	public List<Product> findAllProduct() throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from products";
		List<Product> productList = runner.query(sql, new BeanListHandler<Product>(Product.class));
		
		return productList;
	}
}
