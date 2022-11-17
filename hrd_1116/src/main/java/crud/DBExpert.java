package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Member;

public class DBExpert {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private String id = "hr";
	private String pw = "hr";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//회원번호로 회원정보 수정
	public Boolean updateMember(Member mem) {
		String update = "update member_tbl_02 set custname=?, phone=?, address=?, "
				+ "joindate = to_date(?, 'yyyy/mm/dd'), grade=?, city=? "
				+ "where custno = ? ";
		Boolean flag = false;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,this.id,pw);
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1,mem.getName());
			pstmt.setString(2,mem.getTel());
			pstmt.setString(3,mem.getAddr());
			pstmt.setString(4,mem.getDate());
			pstmt.setString(5,mem.getGrade());
			pstmt.setString(6,mem.getCity());
			pstmt.setInt(7,mem.getId());
			pstmt.executeUpdate();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		return flag;
	}
	
	//회원번호로 회원정보 검색
	public Member getMember(Integer id) {
		String select = "select custno, custname, phone, address, "
				+ "to_char(joindate, 'yyyy/mm/dd'), grade, city "
				+ "from member_tbl_02 "
				+ "where custno = ? ";
		Member mem = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,this.id,pw);
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mem = new Member();
				mem.setId(rs.getInt(1));
				mem.setName(rs.getString(2));
				mem.setTel(rs.getString(3));
				mem.setAddr(rs.getString(4));
				mem.setDate(rs.getString(5));
				mem.setGrade(rs.getString(6));
//				String grade = rs.getString(6);
//				switch(grade) {
//				case "A" : mem.setGrade("VIP"); break; 
//				case "B" : mem.setGrade("일반"); break; 
//				case "C" : mem.setGrade("직원"); break; 
//				}
				mem.setCity(rs.getString(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		return mem;
	}
	
	//전체 회원 검색
	public ArrayList<Member> getMembers() {
		String select = "select custno, custname, phone, address, "
				+ "to_char(joindate, 'yyyy/mm/dd'), grade, city "
				+ "from member_tbl_02";
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member mem = new Member();
				mem.setId(rs.getInt(1));
				mem.setName(rs.getString(2));
				mem.setTel(rs.getString(3));
				mem.setAddr(rs.getString(4));
				mem.setDate(rs.getString(5));
				String grade = rs.getString(6);
				switch(grade) {
				case "A" : mem.setGrade("VIP"); break; 
				case "B" : mem.setGrade("일반"); break; 
				case "C" : mem.setGrade("직원"); break; 
				}
				mem.setCity(rs.getString(7));
				list.add(mem);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		return list;
		
	}
	
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
