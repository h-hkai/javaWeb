package service;

import java.sql.SQLException;

import dao.TransferDao;
import utils.MyDataSourceUtils;

public class TransferService {

	public boolean transfer(String out, String in, double amount) {
		TransferDao dao = new TransferDao();
		
		boolean isTransferSuccess = true;
		
		try {
			MyDataSourceUtils.startTransaction();
			dao.out(out, amount);
//			int x = 1 / 0;
			dao.in(in, amount);
		} catch (SQLException e) {
			isTransferSuccess = false;
			try {
				MyDataSourceUtils.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				MyDataSourceUtils.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return isTransferSuccess;
	}

}
