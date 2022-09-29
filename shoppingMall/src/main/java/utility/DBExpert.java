package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Member;

public class DBExpert {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	
	//모든 고객정보 검색 메서드(리턴)
	public ArrayList<Member> getAllMembers(){
		String select = "select custno, custname, phone, address, "
				+ "to_char(joindate, 'YYYY-MM-DD'), grade, city "
				+ "from member_tbl_02";
		ArrayList<Member> list = new ArrayList<Member>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "hr", "hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member mem = new Member();
				mem.setCustno(rs.getInt(1));
//				System.out.println(rs.getInt(1));
				mem.setCustname(rs.getString(2));
				mem.setPhone(rs.getString(3));
				mem.setAddress(rs.getString(4));
				mem.setJoindate(rs.getString(5));
				switch(rs.getString(6)) {
				case "A": mem.setGrade("VIP"); break;
				case "B": mem.setGrade("일반"); break;
				case "C": mem.setGrade("직원"); break;
				}
				mem.setCity(rs.getString(7));
				list.add(mem);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			}catch(Exception e) {}
		}
		
		return list;
	}
	
	//고객정보 삽입 메서드(리턴)
	public boolean putMember(Member m) {
		String insert = "insert into member_tbl_02 values(?,?,?,?,to_date(?,'YYYY-MM-DD'),?,?)";
		boolean result = false;
		Connection con = null; PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "hr", "hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, m.getCustno());
//			System.out.println(m.getCustno());
			pstmt.setString(2, m.getCustname());
//			System.out.println(m.getCustname());
			pstmt.setString(3, m.getPhone());
//			System.out.println(m.getPhone());
			pstmt.setString(4, m.getAddress());
//			System.out.println(m.getAddress());
			pstmt.setString(5, m.getJoindate());
//			System.out.println(m.getJoindate());
			pstmt.setString(6, m.getGrade());
//			System.out.println(m.getGrade());
			pstmt.setString(7, m.getCity());
//			System.out.println(m.getCity());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	//최대 고객번호를 찾는 메서드(리턴)
	public Integer getMaxCustno() {
		String select = "select max(custno) from member_tbl_02";
		Integer max = -1;
		Connection con = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "hr", "hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			//쿼리의 실행결과는 1건 -> 조회결과로 1번만 이동
			//만약 N건이면 while문으로 처리 필요.
			rs.next();
			max = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			}catch(Exception e) {}
		}
		return max;
	}
	
}
