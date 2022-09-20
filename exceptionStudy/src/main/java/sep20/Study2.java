package sep20;

import java.sql.Connection;
import java.sql.DriverManager;

public class Study2 {

	public static void main(String[] args) {
		//접속 테스트 (본인의 DB와 연동)
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//OracleDriver 라는 이름의 클래스를 찾는 프로그램
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "hr", "hr");
			//접속할 DB(ip와 DB명 확인), 계정, 암호
			System.out.println("DB접속 성공");
		} catch(Exception e) {
			System.out.println("DB접속 실패");
		} finally {
			try{ con.close(); } catch(Exception e){}
			//반드시 접속 해제를 해줘야 웹서버의 메모리가 반납된다.
		}

	}

}
