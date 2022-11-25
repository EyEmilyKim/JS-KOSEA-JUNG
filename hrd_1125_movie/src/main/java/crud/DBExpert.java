package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Booking;
import model.Course;

public class DBExpert {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private String uid = "hr";
	private String upw = "hr";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//전체 예매 정보 검색
	public ArrayList<Booking> listBookings(){
		System.out.println("listBookings() called");
		String sql = "select w.name, w.phone, m.title, "
				+ "to_char(m.start_hour, '0999'), to_char(m.end_hour, '0999'), "
				+ "b.tickets, to_char( b.r_date, 'yyyymmdd') "
				+ "from booking_info b, movies_info m, watcher_info w "
				+ "where b.id = m.id "
				+ "and b.no = w.no ";
		ArrayList<Booking> list = new ArrayList<Booking>();
		try {
			System.out.println("listBookings() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("listBookings() true");
				Booking bk = new Booking();
				bk.setW_name(rs.getString(1));
				bk.setW_phone(rs.getString(2));
				bk.setM_title(rs.getString(3));
				bk.setStartHr(rs.getString(4));
				bk.setEndHr(rs.getString(5));
				bk.setTickets(rs.getInt(6));
				bk.setR_date(rs.getString(7));
				list.add(bk);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("listBookings() end");
		return list;
	}
}
