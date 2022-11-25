package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Booking;
import model.Movie;
import model.Watcher;

public class DBExpert {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private String uid = "hr";
	private String upw = "hr";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//예매 정보 삽입
	public boolean insertBooking(Booking bk) {
		System.out.println("insertBooking() called");
		String sql = "insert into booking_info values( "
				+ "?, ?, ?, to_date(?,'yyyymmdd') ) ";
		boolean flag = false;
		try {
			System.out.println("insertBooking() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bk.getM_id());
			pstmt.setString(2, bk.getW_no());
			pstmt.setInt(3, bk.getTickets());
			pstmt.setString(4, bk.getR_date());
			pstmt.executeQuery();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("insertBooking() end");
		return flag;
	}
	
	//전체 예매 정보의 고객no, 영화id 검색
	public ArrayList<Booking> getBookings(){
		System.out.println("getBookings() called");
		String sql = "select id, no from booking_info ";
		ArrayList<Booking> list = new ArrayList<Booking>();
		try {
			System.out.println("getBookings() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("getBookings() true");
				Booking bk = new Booking();
				bk.setW_name(rs.getString(1));
				bk.setM_title(rs.getString(2));
				list.add(bk);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("getBookings() end");
		return list;
	}
	
	//전체 고객 no,name 검색
	public ArrayList<Watcher> getWatchers(){
		System.out.println("getWatchers() called");
		String sql = "select no, name from watcher_info ";
		ArrayList<Watcher> list = new ArrayList<Watcher>();
		try {
			System.out.println("getWatchers() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("getWatchers() true");
				Watcher wr = new Watcher();
				wr.setNo(rs.getString(1));
				wr.setName(rs.getString(2));
				list.add(wr);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("getWatchers() end");
		return list;
	}
	
	//전체 영화 id,title 검색
	public ArrayList<Movie> getMovies(){
		System.out.println("getMovies() called");
		String sql = "select id, title from movies_info ";
		ArrayList<Movie> list = new ArrayList<Movie>();
		try {
			System.out.println("getMovies() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("getMovies() true");
				Movie mv = new Movie();
				mv.setId(rs.getString(1));
				mv.setTitle(rs.getString(2));
				list.add(mv);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("getMovies() end");
		return list;
	}
	
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
