package service;

import java.sql.SQLException;
import java.util.List;

import dao.ProductDao;

public class ProductService {

	public List<Object> searchProductByWord(String word) throws SQLException {
		ProductDao dao = new ProductDao();
		return dao.searchProductByWord(word);
	}

}
