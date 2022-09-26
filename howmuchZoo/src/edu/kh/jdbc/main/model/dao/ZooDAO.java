package edu.kh.jdbc.main.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

// DAO : DB 연결용 객체
public class ZooDAO {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	
	// 기본 생성자
	public ZooDAO() {
		
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
	
	/** 동물 기록 DAO
	 * @param conn
	 * @param choiceANM
	 * @param raisePoint
	 * @return result
	 * @throws Exception
	 */
	public int SaveAnimal(Connection conn, int choiceANM, int raisePoint) throws Exception {
		
		int result = 0;
		String AnimalType = "";
		int SellPrice = 0;
		
		try {
			
			switch (choiceANM) {
			case 1: AnimalType += "COW";
				if (raisePoint > 100) {
					SellPrice = 20000;
				} else if (raisePoint > 50) {
					SellPrice = 15000;
				} else {
					SellPrice = 11000;
				}
				break;
			case 2: AnimalType += "PIG";
				if (raisePoint > 100) {
					SellPrice = 10000;
				} else if (raisePoint > 50) {
					SellPrice = 8000;
				} else {
					SellPrice = 6000;
				}
				break;
			case 3: AnimalType += "DOG";
				if (raisePoint > 100) {
					SellPrice = 5000;
				} else if (raisePoint > 50) {
					SellPrice = 3500;
				} else {
					SellPrice = 3000;
				}
				break;
			case 4: AnimalType += "CAT";
				if (raisePoint > 100) {
					SellPrice = 5000;
				} else if (raisePoint > 50) {
					SellPrice = 3500;
				} else {
					SellPrice = 3000;
				}
				break;
			default : System.out.println("동물 기록중 오류가 있습니다.");
			}
			
			String sql = "INSERT INTO " + AnimalType 
					+ "	VALUES(DEFAULT, DEFAULT, " + raisePoint + ", " + SellPrice + ")";

			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql); 
			
		} finally {
			close(stmt);
		}
		
		return result;
	}
	
	/** 동물 판매 ( 소지금 추가 동물선택과 점수 초기화 ) DAO
	 * @param conn
	 * @param choiceANM
	 * @param raisePoint
	 * @return result
	 * @throws Exception
	 */
	public int SellAnimal(Connection conn, int choiceANM, int raisePoint) throws Exception {
		
		int result = 0;
		int SellPrice = 0;
		
		try {
			
			switch (choiceANM) {
			case 1:
				if (raisePoint > 100) {
					SellPrice = 20000;
				} else if (raisePoint > 50) {
					SellPrice = 15000;
				} else {
					SellPrice = 11000;
				}
				break;
			case 2:
				if (raisePoint > 100) {
					SellPrice = 10000;
				} else if (raisePoint > 50) {
					SellPrice = 8000;
				} else {
					SellPrice = 6000;
				}
				break;
			case 3:
				if (raisePoint > 100) {
					SellPrice = 5000;
				} else if (raisePoint > 50) {
					SellPrice = 3500;
				} else {
					SellPrice = 3000;
				}
				break;
			case 4:
				if (raisePoint > 100) {
					SellPrice = 5000;
				} else if (raisePoint > 50) {
					SellPrice = 3500;
				} else {
					SellPrice = 3000;
				}
				break;
			default : System.out.println("동물 기록중 오류가 있습니다.");
			}
				
			String sql = prop.getProperty("SellPrice");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, SellPrice);
			
			result = pstmt.executeUpdate();
				
			
		} finally {
			close(stmt);
		}
		
		return result;
	}


}
