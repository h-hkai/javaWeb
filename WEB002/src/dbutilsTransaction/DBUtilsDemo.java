package dbutilsTransaction;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;

import Utils.C3P0Utils;

public class DBUtilsDemo {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			QueryRunner runner = new QueryRunner();
			conn = (Connection) C3P0Utils.getConnection();
			
			conn.setAutoCommit(false);
			
			runner.update(conn, "update users set uname='kali2' where uid=14");
		
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
