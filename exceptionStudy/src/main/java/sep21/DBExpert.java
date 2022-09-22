package sep21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBExpert { //삽입, 삭제, 변경, 조회 메서드
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	
	public boolean entryBBS(BBS bbs) {
		String insert = "insert into test_tbl values(?,?,?,sysdate,?)";
		boolean flag = false; //작업 성공여부를 위한 변수
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "hr", "hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, bbs.getSeqno()); //글번호(정수) 설정
			pstmt.setString(2, bbs.getId()); //작성자(문자열) 설정
			pstmt.setString(3, bbs.getTitle()); //제목(문자열) 설정
			pstmt.setString(4, bbs.getContent()); //글내용(문자열) 설정
			pstmt.executeUpdate();//insert 쿼리 실행
			con.commit();
			flag = true; //삽입 성공을 의미
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{ 
				pstmt.close();
				con.close();
			}catch(Exception e) {}
		}
		return flag;
	}//게시글 삽입 메서드
	
	public boolean deleteBBS(int no) {
		String delete="delete from test_tbl where seqno=?";
		boolean flag = false; //작업 성공여부를 위한 변수
		Connection con = null; PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, no); //1번째 물음표에 no 값 설정
			pstmt.executeUpdate(); //delete 실행
			con.commit(); //commit
			flag = true; //작업 성공을 의미
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
			}catch(Exception e) {}
		}
		return flag;
	}//게시글 삭제 메서드
	
	public boolean updateBBS(BBS bbs) {
		String update = "update test_tbl set title=?, "
				+"content=? where seqno=?";
		boolean flag = false; //작업 성공여부를 위한 변수
		Connection con = null; PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, bbs.getTitle());
			pstmt.setString(2, bbs.getContent());
			pstmt.setInt(3, bbs.getSeqno());
			pstmt.executeUpdate(); //update 실행
			con.commit();
			flag = true; //작업 성공을 의미
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
			}catch(Exception e) {}
		}
		return flag;
	}//게시글 변경 메서드
}
