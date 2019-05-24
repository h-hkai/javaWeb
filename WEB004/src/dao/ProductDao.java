package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import utils.C3P0Utils;

public class ProductDao {

	public List<Object> searchProductByWord(String word) throws SQLException {
		if (word.trim() == null || word.trim().length() == 0)
			return null;
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from products where pname like ? limit 0,5";
		
		List<Object> productList = runner.query(sql, new ColumnListHandler("pname"), "%" + word + "%");
		
		return productList;
	}

}
