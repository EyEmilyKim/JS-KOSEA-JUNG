package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Member;

public class DBExpert {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private String id = "hr";
	private String pw = "hr";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//회원 삽입
	public boolean putMember(Member mem) {
		String insert = "insert into member_tbl_02 values( "
				+ "?,?,?,?,to_date(?, 'yyyy-mm-dd'),?,?)";
		boolean result = false;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, mem.getId());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getTel());
			pstmt.setString(4, mem.getAddr());
			pstmt.setString(5, mem.getDate());
			pstmt.setString(6, mem.getGrade());
			pstmt.setString(7, mem.getCity());
			pstmt.executeUpdate(); //삽입
			conn.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{ pstmt.close(); conn.close();}
			catch(Exception e) {}
		}
		return result;
	}
	
	//가장 큰 회원번호 검색
	public Integer getMaxId() {
		String select = "select max(custno) from member_tbl_02";
		Integer maxId = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery(); //조회 실행
			if(rs.next()) maxId = rs.getInt(1);
			else maxId = 0;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{ rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		return maxId;
	}
}
