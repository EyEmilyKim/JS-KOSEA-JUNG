package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Course;

public class DBExpert {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private String uid = "hr";
	private String upw = "hr";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//교과목 등록
	public boolean insertCourse(Course crs) {
		String sql = "insert into course_tbl values ( ?,?,?,?,?,?,? )";
		boolean flag = false;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, crs.getId());
			pstmt.setString(2, crs.getName());
			pstmt.setInt(3, crs.getCredit());
			pstmt.setString(4, crs.getLecturer());
			pstmt.setInt(5, crs.getWeek_n());
			pstmt.setString(6, crs.getStart_hour());
			pstmt.setString(7, crs.getEnd_hour());
			pstmt.executeUpdate();
			conn.commit();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		return flag;
	}
	
	//전체 강사 이름 검색
	public ArrayList<String> listLecturers(){
		String sql = "select name from lecturer_tbl ";
		ArrayList<String> list = new ArrayList<String>();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String tr = rs.getString(1); 
				list.add(tr);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		return list;
	}
	
	//전체 교과목 검색
	public ArrayList<Course> listCourses(){
		String sql = "select id, c.name, credit, l.name, week, "
				+ "to_char(start_hour, '0999') start_hour, "
				+ "to_char(end_hour, '0999') end_hour "
				+ "from course_tbl c, lecturer_tbl l "
				+ "where c.lecturer = l.idx ";
		ArrayList<Course> list = new ArrayList<Course>();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Course crs = new Course();
				crs.setId(rs.getString(1));
				crs.setName(rs.getString(2));
				crs.setCredit(rs.getInt(3));
				crs.setLecturer(rs.getString(4));
				crs.setWeek_n(rs.getInt(5));
				switch(rs.getInt(5)) {
				case 1: crs.setWeek("월"); break; 
				case 2: crs.setWeek("화"); break; 
				case 3: crs.setWeek("수"); break; 
				case 4: crs.setWeek("목"); break; 
				case 5: crs.setWeek("금"); break; 
				case 6: crs.setWeek("토"); break; 
				}
				crs.setStart_hour(rs.getString(6));
				crs.setEnd_hour(rs.getString(7));
				list.add(crs);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		return list;
	}
}
