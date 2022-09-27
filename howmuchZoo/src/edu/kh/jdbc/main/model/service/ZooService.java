package edu.kh.jdbc.main.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.buy.vo.Animal;
import edu.kh.jdbc.main.model.dao.ZooDAO;

public class ZooService {
	
	private ZooDAO dao = new ZooDAO();

	/** 소지금 반환 서비스
	 * @return
	 */
	public int moneyInHand() throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.meneyInHand(conn);
		
		close(conn);
		
		return result;
	}

	/** 동물 기록 서비스
	 * @param choiceANM
	 * @param raisePoint
	 * @throws Exception
	 */
	public void SaveAnimal(int choiceANM, int raisePoint) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.SaveAnimal(conn, choiceANM, raisePoint);
		
		if (result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
	}
	
	/** 동물 판매 ( 소지금 추가 동물선택과 점수 초기화 ) 서비스
	 * @param choiceANM
	 * @param raisePoint
	 * @throws Exception
	 */
	public void SellAnimal(int choiceANM, int raisePoint) throws Exception {
		
//		System.out.println(choiceANM +" 와 "+ raisePoint);
		
		Connection conn = getConnection();
		
		int result = dao.SellAnimal(conn, choiceANM, raisePoint);
		
		if (result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
	}

	/** 기록 확인(총합 기록 포함) 서비스
	 * @param animalType 
	 * @return animalList
	 * @throws Exception
	 */
	public List<Animal> CheckRecord(int animalType) throws Exception {
		
		Connection conn = getConnection();
		
		List<Animal> animalList = dao.CheckRecord(conn, animalType);
		
		close(conn);
		
		return animalList;
		
	}


}
