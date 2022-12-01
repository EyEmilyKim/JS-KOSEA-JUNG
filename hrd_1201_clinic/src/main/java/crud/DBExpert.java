package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
