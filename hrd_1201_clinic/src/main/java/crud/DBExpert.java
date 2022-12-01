package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Course;
import model.Doctor;
import model.Patient;

public class DBExpert {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private String uid = "hr"; //시험:"system"
	private String upw = "hr"; //시험:"1234"
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//기존 환자 진료정보 삽입
		public boolean insertRecord(Patient pt) {
			System.out.println("insertRecord() called");
			String sql2 = "insert into patient_course_info values(?, ?, ?, to_date(?,'yyyy-mm-dd'))";
			String sql3 = "insert into patient_doctor_info values(?, ?, to_date(?,'yyyy-mm-dd'))";
			Integer flag2 = -1;
			Integer flag3 = -1;
			boolean flag = false;
			try {
				System.out.println("insertRecord() tried");
				Class.forName(driver);
				conn = DriverManager.getConnection(url,uid,upw);
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, pt.getP_code());
				pstmt.setString(2, pt.getM_code());
				pstmt.setString(3, pt.getRoom());
				pstmt.setString(4, pt.getReg_date());
				flag2 = pstmt.executeUpdate();
				System.out.println("flag2 : "+flag2);
				pstmt = conn.prepareStatement(sql3);
				pstmt.setString(1, pt.getP_code());
				pstmt.setString(2, pt.getD_code());
				pstmt.setString(3, pt.getReg_date());
				flag3 = pstmt.executeUpdate();
				System.out.println("flag3 : "+flag3);
				if(flag2 > 0 && flag3 > 0) {
					conn.commit();
					flag = true;
					System.out.println("commit done. flag : "+flag);
				}else {
					conn.rollback();
					System.out.println("rollback done. flag : "+flag);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try { pstmt.close(); conn.close(); }
				catch(Exception e) {}
			}
			System.out.println("insertRecord() end");
			return flag;
		}
	
	//신규 환자 진료정보 삽입
	public boolean insertRecordNew(Patient pt) {
		System.out.println("insertRecordNew() called");
		String sql1 = "insert into patient_info values(?, ?, ?, ?)";
		String sql2 = "insert into patient_course_info values(?, ?, ?, to_date(?,'yyyy-mm-dd'))";
		String sql3 = "insert into patient_doctor_info values(?, ?, to_date(?,'yyyy-mm-dd'))";
		Integer flag1 = -1;
		Integer flag2 = -1;
		Integer flag3 = -1;
		boolean flag = false;
		try {
			System.out.println("insertRecordNew() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, pt.getP_code());
			pstmt.setString(2, pt.getP_name());
			pstmt.setString(3, pt.getAddr());
			pstmt.setString(4, pt.getTel());
			flag1 = pstmt.executeUpdate();
			System.out.println("flag1 : "+flag1);
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, pt.getP_code());
			pstmt.setString(2, pt.getM_code());
			pstmt.setString(3, pt.getRoom());
			pstmt.setString(4, pt.getReg_date());
			flag2 = pstmt.executeUpdate();
			System.out.println("flag2 : "+flag2);
			pstmt = conn.prepareStatement(sql3);
			pstmt.setString(1, pt.getP_code());
			pstmt.setString(2, pt.getD_code());
			pstmt.setString(3, pt.getReg_date());
			flag3 = pstmt.executeUpdate();
			System.out.println("flag3 : "+flag3);
			if(flag1 > 0 && flag2 > 0 && flag3 > 0) {
				conn.commit();
				flag = true;
				System.out.println("commit done. flag : "+flag);
			}else {
				conn.rollback();
				System.out.println("rollback done. flag : "+flag);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("insertRecordNew() end");
		return flag;
	}
	
	//전체 환자 p_code 검색 (for 기존/신규 환자 구분)
	public ArrayList<String> getPcodes(){
		System.out.println("getPcodes() called");
		String sql = "select p_code from patient_info "
				+ "order by p_code ";
		ArrayList<String> list = new ArrayList<String>();
		try {
			System.out.println("getPcodes() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println("getPcodes() true");
				String p_code = rs.getString(1);
				list.add(p_code);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("getPcodes() end");
		return list;
	}
	
	//진료과목 코드,이름 & 의사정보 코드,이름 검색 (for 환자 등록)
	public ArrayList<Course> listCourses(){
		System.out.println("listCourses() called");
		String sql = "select c.m_code, c.title, d.d_code, d.name \r\n"
				+ "from  course_info c , doctor_info d \r\n"
				+ "where c.m_code = d.m_code ";
		ArrayList<Course> list = new ArrayList<Course>();
		try {
			System.out.println("listCourses() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println("listCourses() true");
				Course cour = new Course();
				cour.setM_code(rs.getString(1));
				cour.setM_title(rs.getString(2));
				cour.setD_code(rs.getString(3));
				cour.setD_name(rs.getString(4));
				list.add(cour);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("listCourses() end");
		return list;
	}
	
	//전체 환자 정보 검색
	public ArrayList<Patient> listPatients(){
		System.out.println("listPatients() called");
		String sql = "select p_code, name, addr, tel \r\n"
				+ "from patient_info \r\n"
				+ "order by  p_code ";
		ArrayList<Patient> list = new ArrayList<Patient>();
		try {
			System.out.println("listPatients() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println("listPatients() true");
				Patient pt = new Patient();
				pt.setP_code(rs.getString(1));
				pt.setP_name(rs.getString(2));
				pt.setAddr(rs.getString(3));
				pt.setTel(rs.getString(4));
				list.add(pt);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("listPatients() end");
		return list;
	}
	
	//전체 의사 정보 검색
	public ArrayList<Doctor> listDoctors(){
		System.out.println("listDoctors() called");
		String sql = "select d.d_code, d.name, c.title, d.addr, d.tel \r\n"
				+ "from doctor_info d, course_info c \r\n"
				+ "where d.m_code = c.m_code \r\n";
		ArrayList<Doctor> list = new ArrayList<Doctor>();
		try {
			System.out.println("listDoctors() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println("listDoctors() true");
				Doctor dr = new Doctor();
				dr.setD_code(rs.getString(1));
				dr.setD_name(rs.getString(2));
				dr.setM_title(rs.getString(3));
				dr.setAddr(rs.getString(4));
				dr.setTel(rs.getString(5));
				list.add(dr);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("listDoctors() end");
		return list;
	}
	
	//전체 환자진료 정보 검색
	public ArrayList<Patient> listPatiCourses(){
		System.out.println("listPatiCourses() called");
		String sql = "select pc.p_code, p.name, p.addr, c.title, d.name, pc.room, to_char(pc.reg_date, 'yyyy-mm-dd')  \r\n"
				+ "from patient_course_info pc , \r\n"
				+ "patient_info p , course_info c , \r\n"
				+ "patient_doctor_info pd , doctor_info d \r\n"
				+ "where pc.p_code = p.p_code \r\n"
				+ "and pc.m_code = c.m_code \r\n"
				+ "and pc.p_code = pd.p_code and pc.reg_date = pd.reg_date and pd.d_code = d.d_code \r\n"
				+ "order by pc.p_code , pc.reg_date ";
		ArrayList<Patient> list = new ArrayList<Patient>();
		try {
			System.out.println("listPatiCourses() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println("listPatiCourses() true");
				Patient pt = new Patient();
				pt.setP_code(rs.getString(1));
				pt.setP_name(rs.getString(2));
				pt.setAddr(rs.getString(3));
				pt.setM_title(rs.getString(4));
				pt.setD_name(rs.getString(5));
				pt.setRoom(rs.getString(6));
				pt.setReg_date(rs.getString(7));
				list.add(pt);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("listPatiCourses() end");
		return list;
	}
}
