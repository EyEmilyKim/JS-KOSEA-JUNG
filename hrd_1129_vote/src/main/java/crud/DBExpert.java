package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Member;
import model.Vote;

public class DBExpert {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private String uid = "hr"; //시험:"system"
	private String upw = "hr"; //시험:"1234"
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//현재 연도 검색 (for 투표검수 생년월일 가공)
	public String getCurrentYear(){
		System.out.println("getCurrentYear() called");
		String sql = "select substr( to_char(sysdate, 'yyyy') ,3,2 ) "
				+ "from dual ";
		String curYear = "";
		try {
			System.out.println("getCurrentYear() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				curYear = rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("getCurrentYear() end");
		return curYear;
	}
	
	//전체 투표검수정보 검색
	public ArrayList<Vote> listVotes(){
		System.out.println("listVotes() called");
		String sql = "select "
				+ "v_name, yy,mm,dd, "
				+ "round(months_between(v_birth, sysdate)/12) age , "
				+ "gen_num , m_no , v_time_str, v_confirm , v_area "
				+ "from ( "
				+ "select v_name, "
				+ "substr(v_jumin,1,2) yy , substr(v_jumin,3,2) mm , substr(v_jumin,5,2) dd , "
				+ "to_date(substr(v_jumin, 1, 6), 'yymmdd') v_birth , sysdate , "
				+ "substr(v_jumin,7,1) gen_num , m_no , "
				+ "substr(v_time, 1, 2) || ':' || substr(v_time, 3, 2) v_time_str , v_confirm , v_area "
				+ "from tbl_vote_202005 , dual "
				+ "where v_area = '제1투표장' "
				+ ") "
				+ "order by v_confirm, v_time_str , v_name ";
		ArrayList<Vote> list = new ArrayList<Vote>();
		try {
			System.out.println("listVotes() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("listVotes() true");
				Vote vt = new Vote();
				vt.setV_name(rs.getString(1));
				vt.setYy(rs.getString(2));
				vt.setMm(rs.getString(3));
				vt.setDd(rs.getString(4));
				vt.setV_age(rs.getInt(5));
				vt.setV_gender(rs.getString(6));
				vt.setM_no(rs.getString(7));
				vt.setV_time_str(rs.getString(8));
				vt.setV_confirm(rs.getString(9));
				list.add(vt);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("listVotes() end");
		return list;
	}
	
	//투표 정보 삽입
	public boolean insertVote(Vote vt){
		System.out.println("insertVote() called");
		String sql = "insert into tbl_vote_202005 values("
				+ " ?,?,?,?,?,? )";
		boolean flag = false;
		try {
			System.out.println("insertVote() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vt.getV_jumin_11());
			pstmt.setString(2, vt.getV_name());
			pstmt.setString(3, vt.getM_no());
			pstmt.setString(4, vt.getV_time());
			pstmt.setString(5, vt.getV_area());
			pstmt.setString(6, vt.getV_confirm());
			pstmt.executeQuery();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("insertVote() end");
		return flag;
	}
	
	//전체 후보자 번호, 이름 검색
	public ArrayList<Member> getMembers(){
		System.out.println("getMembers() called");
		String sql = "select m_no, m_name "
				+ "from tbl_member_202005 ";
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			System.out.println("getMembers() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("getMembers() true");
				Member mem = new Member();
				mem.setM_no(rs.getString(1));
				mem.setM_name(rs.getString(2));
				list.add(mem);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("getMembers() end");
		return list;
	}
	
	//전체 후보자 검색 
	public ArrayList<Member> listMembers(){
		System.out.println("listMembers() called");
		String sql = "select m_no, m_name, p.p_name, p_school, "
				+ "substr(m_jumin, 1, 6) m_jumin_1, substr(m_jumin, 7,13) m_jumin2, "
				+ "m_city, p_tel1, p_tel2, p_tel3 "
				+ "from tbl_member_202005 m, tbl_party_202005 p "
				+ "where m.p_code = p.p_code ";
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			System.out.println("listMembers() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("listMembers() true");
				Member mem = new Member();
				mem.setM_no(rs.getString(1));
				mem.setM_name(rs.getString(2));
				mem.setP_name(rs.getString(3));
				mem.setP_school_num(rs.getString(4));
				///////////switch 가 안먹어서 if 로 짬;;
				String school_num = rs.getString(4).trim();
				if(school_num.equals("1")) {
//					System.out.println("school_num:"+school_num);
					mem.setP_school_str("고졸");
//					System.out.println("mem.getP_school_str():"+mem.getP_school_str());
				}
				if(school_num.equals("2")) {
//					System.out.println("school_num:"+school_num);
					mem.setP_school_str("학사");
//					System.out.println("mem.getP_school_str():"+mem.getP_school_str());
				}
				if(school_num.equals("3")) {
//					System.out.println("school_num:"+school_num);
					mem.setP_school_str("석사");
//					System.out.println("mem.getP_school_str():"+mem.getP_school_str());
				}
				if(school_num.equals("4")) {
//					System.out.println("school_num:"+school_num);
					mem.setP_school_str("박사");
//					System.out.println("mem.getP_school_str():"+mem.getP_school_str());
				}
				///////////
				mem.setM_jumin_first(rs.getString(5));
				mem.setM_jumin_last(rs.getString(6));
				mem.setM_jumin_full(rs.getString(5)+"-"+rs.getString(6));
				mem.setM_city(rs.getString(7));
				mem.setP_tel1(rs.getString(8).trim());
				mem.setP_tel2(rs.getString(9));
				mem.setP_tel3(rs.getString(10));
				mem.setP_tel_full(rs.getString(8).trim()+"-"+rs.getString(9)+"-"+rs.getString(10));
				list.add(mem);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("listMembers() end");
		return list;
	}
}
