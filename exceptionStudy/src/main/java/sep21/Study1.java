package sep21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Study1 {

	public static void main(String[] args) {
		String id = "tiger";
		String title = "오늘은 수요일";
		String cont = "탄산이 땡깁니다.";
		int seqno = 2;
//		String insert = "insert into test_tbl "
//				+ "values (1, 'tiger', '오늘은 수요일', "
//				+ "sysdate, '가방 속 물 쏟음ㅠ')"; 
		String insert = "insert into test_tbl "
				+ "values(?,?,?,sysdate,?)"; 
			//프로그램을 통한 insert 구문은';' 안찍음!
			//쿼리문 space 오류 등의 실수 주의!
		Connection con = null; //DB접속용 객체 선언
		PreparedStatement pstmt = null; //쿼리 처리용 객체 선언
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//OracleDriver 라는 이름의 클래스를 찾는 프로그램
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "hr", "hr");
			//접속할 DB(ip와 DB명 확인), 계정, 암호
			pstmt = con.prepareStatement(insert);
			//변수와 물음표와의 매핑(연결)을 한다.
			pstmt.setInt(1, seqno); //1번째 물음표에 seqno 설정
			pstmt.setString(2, id);
			pstmt.setString(3, title);
			pstmt.setString(4, cont);
		
			pstmt.executeUpdate(); //삽입 쿼리 실행
			con.commit(); //커밋 실행
			System.out.println("삽입 성공");
		}catch(Exception e) {
			System.out.println("DB 접속 오류 혹은 삽입 실패");
		}finally {
			try { 
				pstmt.close(); con.close(); 
				//닫을 때 1.pstmt,2.con 순서 주의.(열 때의 역순)
			} catch (Exception e) {}
		}
		
	}

}
