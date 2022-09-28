package sep21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBExpert { //삽입, 삭제, 변경, 조회 메서드
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	
	//무조건 검색 메서드
	public ArrayList<BBS> getAllBBS(){
		String select = "select seqno, id, title, to_char(reg_date,'YYYY-MM-DD') from test_tbl";
		ArrayList<BBS> list = new ArrayList<BBS>();
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BBS bbs = new BBS();
				bbs.setSeqno(rs.getInt(1));
				bbs.setId(rs.getString(2));
				bbs.setTitle(rs.getString(3));
				bbs.setReg_date(rs.getString(4));
				list.add(bbs);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				rs.close(); pstmt.close(); con.close();	
			}catch(Exception e) {}
		}
		return list;
	}
	
	//글번호로 게시글을 검색하는 메서드(리턴)
	public BBS getBBSDetail(int seqno) {
		String select = "select seqno, id, title, "
				+ "to_char(reg_date, 'YYYY-MM-DD'), content "
				+ "from test_tbl where seqno=?";
		BBS bbs = null; //조회결과를 저장할 DTO 선언.(추후 조회결과가 있을 때 생성할 것임)
		Connection con = null; //DB 접속할 객체 con
		PreparedStatement pstmt = null; //쿼리 실행할 객체 pstmt
		ResultSet rs = null; //select 결과 받아줄 객체 rs
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, seqno);
			rs = pstmt.executeQuery(); //select 실행하여 결과를 rs에 담음.
			//select 결과가 1건이므로 한번만 이동.(만약 결과가 여러건이면 while문 필요.)
			if(rs.next()) {//true => select 결과가 있음
				bbs = new BBS(); //DTO 생성
				bbs.setSeqno(rs.getInt(1));
				bbs.setId(rs.getString(2));
				bbs.setTitle(rs.getString(3));
				bbs.setReg_date(rs.getString(4));
				bbs.setContent(rs.getString(5));
			}//검색 결과로 이동
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return bbs; //조회결과 없으면 null 반환, 있으면 bbs 반환.
	}
	
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
		String update = "update test_tbl set title=?, id=?, "
				+"content=? where seqno=?";
		boolean flag = false; //작업 성공여부를 위한 변수
		Connection con = null; PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, bbs.getTitle());
			pstmt.setString(2, bbs.getId());
			pstmt.setString(3, bbs.getContent());
			pstmt.setInt(4, bbs.getSeqno());
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
