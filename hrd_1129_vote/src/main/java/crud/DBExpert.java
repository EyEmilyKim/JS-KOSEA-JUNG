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
	private String uid = "hr"; //시험:"system"
	private String upw = "hr"; //시험:"1234"
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
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
					System.out.println("school_num:"+school_num);
					mem.setP_school_str("고졸");
					System.out.println("mem.getP_school_str():"+mem.getP_school_str());
				}
				if(school_num.equals("2")) {
					System.out.println("school_num:"+school_num);
					mem.setP_school_str("학사");
					System.out.println("mem.getP_school_str():"+mem.getP_school_str());
				}
				if(school_num.equals("3")) {
					System.out.println("school_num:"+school_num);
					mem.setP_school_str("석사");
					System.out.println("mem.getP_school_str():"+mem.getP_school_str());
				}
				if(school_num.equals("4")) {
					System.out.println("school_num:"+school_num);
					mem.setP_school_str("박사");
					System.out.println("mem.getP_school_str():"+mem.getP_school_str());
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
			try { }
			catch(Exception e) {}
		}
		System.out.println("listMembers() end");
		return list;
	}
}
