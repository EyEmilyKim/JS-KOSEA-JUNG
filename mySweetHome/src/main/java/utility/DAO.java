package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Bbs;

public class DAO {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//게시글 삽입 메서드
	public boolean putBbs(Bbs bbs) {
		String insert = "insert into mysweet_bbs values(?,?,?,sysdate,?)";
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, bbs.getSeqno()); //글번호
			pstmt.setString(2, bbs.getTitle()); //글제목
			pstmt.setString(3, bbs.getWriter()); //작성자
			pstmt.setString(4, bbs.getContent()); //글내용
			pstmt.executeUpdate(); //insert 실행
			con.commit(); //commit
			result = true; //삽입 성공을 의미
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return result;
	}
	
	//가장 큰 글번호를 찾는 메서드
	public Integer getMaxSeqno() {
		String select = "select max(seqno) from mysweet_bbs";
		Integer max = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) {//조회결과가 존재하는 경우
				max = rs.getInt(1);
			}else {//조회결과가 존재하지 않는 경우
				max = 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {rs.close(); pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return max;
	}
	
	//계정으로 암호 검색
	public String getPwd(String id) {
		String select = "select pwd from mysweet_users where id = ?";
		String pwd = null; //검색된 암호 저장할 변수 선언
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pwd = rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return pwd;
	}
}
