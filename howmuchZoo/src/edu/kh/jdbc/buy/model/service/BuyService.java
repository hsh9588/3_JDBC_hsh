package edu.kh.jdbc.buy.model.service;

import java.sql.Connection;

import edu.kh.jdbc.buy.model.dao.BuyDAO;

import static edu.kh.jdbc.common.JDBCTemplate.*;

public class BuyService {
	
	private BuyDAO dao = new BuyDAO();

	/** 구매 후 소지금 차감과 키우기 화면 전환 서비스
	 * @throws Exception
	 */
	public void buy() throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.buy(conn);
		
		if (result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
	}

}
