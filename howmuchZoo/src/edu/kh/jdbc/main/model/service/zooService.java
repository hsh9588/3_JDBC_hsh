package edu.kh.jdbc.main.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.jdbc.main.model.dao.zooDAO;

public class zooService {
	
	private zooDAO dao = new zooDAO();

	/** 소지금 반환 서비스
	 * @return
	 */
	public int moneyInHand() throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.meneyInHand(conn);
		
		close(conn);
		
		return result;
	}

}
