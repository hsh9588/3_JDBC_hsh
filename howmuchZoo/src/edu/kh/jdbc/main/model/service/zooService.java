package edu.kh.jdbc.main.model.service;

// service 데이터 가공, 트랜잭션 제어 처리
import static edu.kh.jdbc.JDBCTemplate.*;

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
