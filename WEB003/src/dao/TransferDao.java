package dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import utils.C3P0Utils;
import utils.MyDataSourceUtils;


public class TransferDao {

	public void out(String out, double amount) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection conn = MyDataSourceUtils.getConnection();
		
		String sql = "update accounts set money=money-? where name=?";
		
		runner.update(conn, sql, amount, out);

	}

	public void in(String in, double amount) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection conn = MyDataSourceUtils.getConnection();
		
		String sql = "update accounts set money=money+? where name=?";
		
		runner.update(conn, sql, amount, in);
	}
	
}
