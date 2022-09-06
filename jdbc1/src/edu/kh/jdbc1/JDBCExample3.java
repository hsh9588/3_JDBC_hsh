package edu.kh.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String type = "jdbc:oracle:thin:@";
			String ip = "localhost";
			String port = ":1521";
			String sid = ":XE";
			String user = "kh_hsh";
			String pw = "kh1234";
			
			conn = DriverManager.getConnection(type + ip + port + sid, user, pw);
			
			System.out.println("<직원 중 선택 성별만 조회>");
			System.out.print("1 또는 2 입력 : ");
			
			int input = sc.nextInt();
			
			String sql = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE SUBSTR(EMP_NO, 8, 1) = " + input;
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				
				System.out.printf("사번 : %s / 이름 : %s\n", empId, empName);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				
				if (rs != null) rs.close();
				if (stmt != null) rs.close();
				if (conn != null) rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
