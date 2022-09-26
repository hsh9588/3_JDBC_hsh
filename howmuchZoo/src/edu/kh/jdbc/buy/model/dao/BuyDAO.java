package edu.kh.jdbc.buy.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.jdbc.main.view.ZooView;

import static edu.kh.jdbc.common.JDBCTemplate.*;

public class BuyDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	
	public BuyDAO() {
		
		try {
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream("howmuchZoo_query.xml"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	/** 구매 후 소지금 차감 키우기 화면 전환 DAO
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int buy(Connection conn) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("buyUpdateMoney");
			
			pstmt = conn.prepareStatement(sql);
			
			if (ZooView.ChoiceANM == 1) {
				pstmt.setInt(1, 10000);
			} else if (ZooView.ChoiceANM == 2) {
				pstmt.setInt(1, 6000);
			} else if (ZooView.ChoiceANM == 3 || ZooView.ChoiceANM == 4) {
				pstmt.setInt(1, 3000);
			} else {
				System.out.println("조건문 오류");
			}
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
			
		}
		
		return result;
	}

}
