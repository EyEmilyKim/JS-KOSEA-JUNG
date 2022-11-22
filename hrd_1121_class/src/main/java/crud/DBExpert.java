package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Course;
import model.Lecturer;

public class DBExpert {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private String uid = "hr";
	private String upw = "hr";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	//교과목 id 로 교과목 정보 삭제
	public boolean deleteCourse(String id) {
		System.out.println("deleteCourse() called");
		String sql = "delete from course_tbl where id = ?";
		boolean flag = false;
		try {
			System.out.println("deleteCourse() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			conn.commit();
			System.out.println("delete true");
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("deleteCourse() end");
		return flag;
	}
	
	//교과목 id 로 교과목 정보 수정
	public boolean updateCourse(Course crs) {
		System.out.println("updateCourse() called");
		String sql = "update course_tbl set "
				+ "name=?, credit=?, lecturer=?, "
				+ "week=?, start_hour=?, end_hour=? "
				+ "where id=? ";
		boolean flag = false;
		try {
			System.out.println("updateCourse() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(7, crs.getId());
			pstmt.setString(1, crs.getName());
			pstmt.setInt(2, crs.getCredit());
			pstmt.setString(3, crs.getLecturer_idx());
//			System.out.println("crs.getLecturer_idx() : "+crs.getLecturer_idx());
			pstmt.setInt(4, crs.getWeek_n());
			pstmt.setInt(5, Integer.parseInt(crs.getStart_hour()));
			pstmt.setInt(6, Integer.parseInt(crs.getEnd_hour()));
			pstmt.executeUpdate();
			conn.commit();
			System.out.println("update true");
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("updateCourse() end");
		return flag;
	}
	
	//교과목 id 로 교과목 정보 검색
	public Course getCourse(String id) {
		String sql = "select id, c.name, credit, l.idx, week, "
				+ "to_char(start_hour, '0999') start_hour, "
				+ "to_char(end_hour, '0999') end_hour "
				+ "from course_tbl c, lecturer_tbl l "
				+ "where c.lecturer = l.idx "
				+ "and id = ?";
		Course crs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				crs = new Course();
				crs.setId(rs.getString(1));
				crs.setName(rs.getString(2));
				crs.setCredit(rs.getInt(3));
				crs.setLecturer_idx(rs.getString(4));
				crs.setWeek_n(rs.getInt(5));
				crs.setStart_hour(rs.getString(6));
				crs.setEnd_hour(rs.getString(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		return crs;
	}
	
	//교과목 등록
	public boolean insertCourse(Course crs) {
		System.out.println("insertCourse() called");
		String sql = "insert into course_tbl values ( ?,?,?,?,?,?,? )";
		boolean flag = false;
		try {
			System.out.println("insertCourse() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, crs.getId());
			pstmt.setString(2, crs.getName());
			pstmt.setInt(3, crs.getCredit());
			pstmt.setString(4, crs.getLecturer_idx());
//			System.out.println("crs.getLecturer_idx() : "+crs.getLecturer_idx());
			pstmt.setInt(5, crs.getWeek_n());
			pstmt.setString(6, crs.getStart_hour());
			pstmt.setString(7, crs.getEnd_hour());
			pstmt.executeUpdate();
			conn.commit();
			System.out.println("insert true");
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("insertCourse() end");
		return flag;
	}
	
	//전체 강사 이름 검색
	public ArrayList<Lecturer> listLecturers(){
		String sql = "select idx, name from lecturer_tbl ";
		ArrayList<Lecturer> list = new ArrayList<Lecturer>();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Lecturer tr = new Lecturer();
				tr.setIdx(rs.getInt(1)); 
				tr.setName(rs.getString(2));
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
				+ "where c.lecturer = to_char(l.idx) "
				+ "order by id";
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
				crs.setLecturer_name(rs.getString(4));
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
