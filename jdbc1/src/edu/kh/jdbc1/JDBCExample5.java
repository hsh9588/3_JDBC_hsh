package edu.kh.jdbc1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc1.model.vo.Employee;

public class JDBCExample5 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 직급명, 급여를 입력 받아
		// 해당 직급에서 입력 받은 급여보다 많이 받는 사원의 
		// 이름, 직급명, 급여, 연봉을 조회하여 출력
		
		// 단, 조회 결과가 없으면 "조회 결과 없음" 출력
		// 조회 결과가 있으면
		// 선동일 / 대표 / 8000000 / 96000000
		// 송중기 / 부장 / 6000000 / 72000000
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			System.out.print("직급명 입력 : ");
			String jobInput = sc.nextLine();
			
			System.out.print("급여 입력 : ");
			int salaryInput = sc.nextInt();
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String type = "jdbc:oracle:thin:@";
			String ip = "localhost";
			String port = ":1521";
			String sid = ":XE";
			// String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "kh_hsh";
			String pw = "kh1234";
			
			conn = DriverManager.getConnection(type + ip + port + sid, user, pw);
//			conn = DriverManager.getConnection(url, user, pw);
			
			String sql = "SELECT EMP_NAME, JOB_NAME, SALARY, SALARY * 12 AS ANNUALINCOME"
					+ " FROM EMPLOYEE E"
					+ " JOIN JOB USING (JOB_CODE)"
					+ " WHERE JOB_NAME = '" + jobInput + "'"
					+ " AND SALARY > " + salaryInput
					+ " ORDER BY 3";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			List<Employee> List = new ArrayList<>();
			
			while (rs.next()) {
				
				String empName = rs.getString("EMP_NAME");
				String jobName = rs.getString("JOB_NAME");
				int salary = rs.getInt("SALARY");
				int annualIncome = rs.getInt("ANNUALINCOME");
				
				Employee emp = new Employee(empName, jobName, salary, annualIncome);
				
				List.add(emp);
			}
			
			if (List.isEmpty()) {
				System.out.println("찾는 정보가 없습니다.");
			} else {
				
				for (Employee e : List) {
					System.out.println(e.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
