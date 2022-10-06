package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Bbs;
import model.Notice;

public class DAO {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//가장 큰 공지글 번호 검색하는 메서드
	public Integer getMaxNotice() {
		String select = "select max(seqno) from mysweet_notice";
		Integer max = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) max = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return max;
	}
	
	//공지사항 삽입 메서드
	public boolean putNotice(Notice n) {
		String insert = "insert into mysweet_notice values(?, ?, ?, to_date(sysdate, 'YYYY-MM-DD', ?)";
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, n.getSeqno());
			pstmt.setString(2, n.getTitle());
			pstmt.setString(3, n.getWriter());
			pstmt.setString(5, n.getContent());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return result;
	}
	
	//글번호로 게시글을 조회하는 메서드
	public Bbs getBbsDetail(int seqno) {
		String select = "select seqno, title, writer, "
				+ "to_char(reg_date, 'YYYY-MM-DD HH24:MI:SS'), content "
				+ "from mysweet_bbs where seqno = ?";
		Bbs bbs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, seqno);
			rs = pstmt.executeQuery();
			if(rs.next()) { //조회결과가 존재하는 경우
				bbs = new Bbs();
				bbs.setSeqno(rs.getInt(1));
				bbs.setTitle(rs.getString(2));
				bbs.setWriter(rs.getString(3));
				bbs.setReg_date(rs.getString(4));
				bbs.setContent(rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return bbs;
	}
	
	//전체 게시글의 갯수 찾는 메서드
	public Integer getTotalCount() {
		String select = "select count(*) from mysweet_bbs";
		Integer totalCount = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) { //조회결과가 존재하는 경우
				totalCount = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return totalCount;
	}
	
	//게시글 조회 메서드(페이지 당 5개의 글만 검색)
	public ArrayList<Bbs> getPageBbs(int start, int end){
		String select = "select seqno, title, writer, r_date "
				+ "from ( select rownum rn, seqno, title, writer, r_date from "
				+ "(select seqno, title, writer, to_char(reg_date, 'YYYY-MM-DD HH24:MI:SS') r_date "
				+ "from mysweet_bbs order by seqno desc ) ) "
				+ "where rn > ? and rn < ? ";
		ArrayList<Bbs> list = new ArrayList<Bbs>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setSeqno(rs.getInt(1)); //글번호
				bbs.setTitle(rs.getString(2)); //제목
				bbs.setWriter(rs.getString(3)); //작성자
				bbs.setReg_date(rs.getString(4)); //작성일
				list.add(bbs);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return list;
	}
	
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
