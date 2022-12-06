package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Score;
import model.Student;
import model.Subject;

public class DBExpert {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private String uid = "hr";
	private String upw = "hr";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//교과목 검색 (for 성적 검색)
	public ArrayList<Subject> listSubject(){
		System.out.println("listSubject() called");
		String sql = "select subcode, subname \r\n"
				+ "from tbl_subject_202210 ";
		ArrayList<Subject> list = new ArrayList<Subject>();
		try {
			System.out.println("listSubject() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("listSubject() true");
				Subject sbj = new Subject();
				sbj.setSubcode(rs.getString(1));
				sbj.setSubname(rs.getString(2));
				list.add(sbj);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("listSubject() end");
		return list;
	}
	
	//교과목 subcode로 전체 성적 검색
	public ArrayList<Score> listScoreSub(String subcode){
		System.out.println("listScoreSub() called");
		String sql = "select sc.stuid, st.sname, sb.subname, sc.subcode, sb.proname, \r\n"
				+ "midscore, finalscore, attend, report, etc, \r\n"
				+ "( midscore + finalscore + attend + report + etc )/5 avg , \r\n"
				+ "( midscore + finalscore + attend + report + etc ) total \r\n"
				+ "from tbl_score_202210 sc, tbl_subject_202210 sb, tbl_student_202210 st \r\n"
				+ "where 1=1 \r\n"
				+ "and sc.stuid = st.sid \r\n"
				+ "and sc.subcode = sb.subcode \r\n"
				+ "and sc.subcode = ? ";
		ArrayList<Score> list = new ArrayList<Score>();
		try {
			System.out.println("listScoreSub() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subcode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("listScoreSub() true");
				Score scr = new Score();
				scr.setStuid(rs.getString(1));
				scr.setStuname(rs.getString(2));
				scr.setSubname(rs.getString(3));
				scr.setSubcode(rs.getString(4));
				scr.setProname(rs.getString(5));
				scr.setMidscore(rs.getInt(6));
				scr.setFinalscore(rs.getInt(7));
				scr.setReport(rs.getInt(8));
				scr.setAttend(rs.getInt(9));
				scr.setEtc(rs.getInt(10));
				scr.setAvg(rs.getFloat(11));
				scr.setTotal(rs.getInt(12));
				list.add(scr);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("listScoreSub() end");
		return list;
	}
	
	//전체 성적 검색
	public ArrayList<Score> listScore(){
		System.out.println("listScore() called");
		String sql = "select sc.stuid, st.sname, sb.subname, sc.subcode, sb.proname, \r\n"
				+ "midscore, finalscore, attend, report, etc, \r\n"
				+ "( midscore + finalscore + attend + report + etc )/5 avg , \r\n"
				+ "( midscore + finalscore + attend + report + etc ) total \r\n"
				+ "from tbl_score_202210 sc, tbl_subject_202210 sb, tbl_student_202210 st \r\n"
				+ "where 1=1 \r\n"
				+ "and sc.stuid = st.sid \r\n"
				+ "and sc.subcode = sb.subcode \r\n";
		ArrayList<Score> list = new ArrayList<Score>();
		try {
			System.out.println("listScore() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("listScore() true");
				Score scr = new Score();
				scr.setStuid(rs.getString(1));
				scr.setStuname(rs.getString(2));
				scr.setSubname(rs.getString(3));
				scr.setSubcode(rs.getString(4));
				scr.setProname(rs.getString(5));
				scr.setMidscore(rs.getInt(6));
				scr.setFinalscore(rs.getInt(7));
				scr.setReport(rs.getInt(8));
				scr.setAttend(rs.getInt(9));
				scr.setEtc(rs.getInt(10));
				scr.setAvg(rs.getFloat(11));
				scr.setTotal(rs.getInt(12));
				list.add(scr);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("listScore() end");
		return list;
	}
	
	//전체 학생 검색
	public ArrayList<Student> listStudent(){
		System.out.println("listStudent() called");
		String sql = "select sid, sname, substr(jumin, 1,6), substr(jumin, 7,7), "
				+ "dept_name, substr(jumin, 7,1), phone, email \r\n"
				+ "from tbl_student_202210 ";
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			System.out.println("listStudent() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("listStudent() true");
				Student std = new Student();
				std.setSid(rs.getString(1));
				std.setSname(rs.getString(2));
				std.setJumin_first(rs.getString(3));
				std.setJumin_last(rs.getString(4));
				std.setDept_name(rs.getString(5));
				std.setGender_code(rs.getString(6));
				std.setPhone(rs.getString(7));
				std.setEmail(rs.getString(8));
				list.add(std);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("listStudent() end");
		return list;
	}
}
