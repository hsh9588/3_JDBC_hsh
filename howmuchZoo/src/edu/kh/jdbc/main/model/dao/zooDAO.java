package edu.kh.jdbc.main.model.dao;

import static edu.kh.jdbc.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

// DAO : DB 연결용 객체
public class zooDAO {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	
	// 기본 생성자
	public zooDAO() {
		
		try {
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream("howmuchZoo_query.xml"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/** 소지금 반환 DAO
	 * @param conn
	 * @return result
	 */
	public int meneyInHand(Connection conn) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("moneyInHand");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			if(rs.next())
				
				result = rs.getInt(1);
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return result;
	}

}
