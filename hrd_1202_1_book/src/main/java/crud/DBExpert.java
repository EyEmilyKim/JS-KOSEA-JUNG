package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Book;
import model.Reservation;

public class DBExpert {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private String uid = "hr"; //시험:"system"
	private String upw = "hr"; //시험:"1234"
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//전체 도서별 대출상태 검색
	public ArrayList<Book> listBookStat(){
		System.out.println("listBookStat() called");
		String sql = "select t1.bookno, t1.last, r.status, b.bookname  \r\n"
				+ "from (\r\n"
				+ "select bookno, max(lentno) last \r\n"
				+ "from reservation_tbl  \r\n"
				+ "group by bookno \r\n"
				+ "order by bookno\r\n"
				+ ") t1, reservation_tbl r, bookinfo_tbl b \r\n"
				+ "where t1.bookno = r.bookno \r\n"
				+ "and t1.last = r.lentno  \r\n"
				+ "and t1.bookno = b.bookno \r\n"
				+ "order by t1.bookno ";
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			System.out.println("listBookStat() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("listBookStat() true");
				Book bk = new Book();
				bk.setBookno(rs.getInt(1));
				bk.setBookname(rs.getString(4));
				bk.setStatus(rs.getString(3));
				list.add(bk);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("listBookStat() end");
		return list;
	}
	
	
	//도서대출내역 삽입
	public boolean insertReserv(Reservation rsv) {
		System.out.println("insertReserv() called");
		String sql = "insert into reservation_tbl values("
				+ " ?, ?, ?, to_date(?, 'yyyy-mm-dd'), null, '1' )";
		boolean flag = false;
		try {
			System.out.println("insertReserv() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rsv.getLentno_str());
			System.out.println("1 : "+rsv.getLentno_str()+" / "+rsv.getLentno_str().getClass());
			pstmt.setString(2, rsv.getCustname());
			System.out.println("2 : "+rsv.getCustname()+" / "+rsv.getCustname().getClass());
			pstmt.setString(3, rsv.getBookno());
			System.out.println("3 : "+rsv.getBookno()+" / "+rsv.getBookno().getClass());
			pstmt.setString(4, rsv.getOutdate());
			System.out.println("4 : "+rsv.getOutdate()+" / "+rsv.getOutdate().getClass());
			pstmt.executeQuery();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("insertReserv() end");
		return flag;
	}
	
	//마지막 대출번호 검색 (for 도서대출내역 입력)
	public Integer getLastLentno() {
		System.out.println("getLastLentNo() called");
		String sql = "select max(lentno) "
				+ "from reservation_tbl ";
		Integer last = 0;
		try {
			System.out.println("getLastLentNo() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("getLastLentNo() true");
				last = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("getLastLentNo() end");
		return last;
	}
	
	//전체 도서정보 검색 (for 도서대출내역 입력)
	public ArrayList<Book> listBook(){
		System.out.println("listBook() called");
		String sql = "select bookno, bookname "
				+ "from bookinfo_tbl "
				+ "order by bookno ";
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			System.out.println("listBook() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("listBook() true");
				Book bk = new Book();
				bk.setBookno(rs.getInt(1));
				bk.setBookname(rs.getString(2));
				list.add(bk);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("listBook() end");
		return list;
	}
	
	//전체 도서대출정보 검색
	public ArrayList<Reservation> listReserv(){
		System.out.println("listReserv() called");
		String sql = "select to_number(r.lentno), r.custname, b.bookname, \r\n"
				+ "to_char(r.outdate,'yyyy-mm-dd'), to_char(r.indate, 'yyyy-mm-dd')  \r\n"
				+ "from reservation_tbl r, bookinfo_tbl b \r\n"
				+ "where r.bookno = b.bookno \r\n"
				+ "order by lentno ";
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		try {
			System.out.println("listReserv() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("listReserv() true");
				Reservation rsv = new Reservation();
				rsv.setLentno(rs.getInt(1));
				rsv.setCustname(rs.getString(2));
				rsv.setBookname(rs.getString(3));
				rsv.setOutdate(rs.getString(4));
				rsv.setIndate(rs.getString(5));
				list.add(rsv);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("listReserv() end");
		return list;
	}
}
