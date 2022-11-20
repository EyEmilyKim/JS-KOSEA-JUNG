package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Book;
import model.Writer;

public class DBExpert {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private String id = "hr";
	private String pw = "hr";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//도서정보 등록
	public boolean insertBook(Book bk) {
		String insertAll = "insert all "
				+ "into books_tbl values ( ?, ?, ?, ?, to_date(?, 'yyyy/mm/dd') ) "
				+ "into bw_tbl values ( ?, ? ) "
				+ "select * from dual";
		boolean flag = false;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);
			pstmt = conn.prepareStatement(insertAll);
			pstmt.setString(1, bk.getId());
			pstmt.setString(2, bk.getName());
			pstmt.setString(3, bk.getPublisher());
			pstmt.setInt(4, bk.getPrice());
			pstmt.setString(5, bk.getP_date());
			pstmt.setString(6, bk.getId());
			pstmt.setNString(7, bk.getWriter());
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
	
	//전체 저자이름 검색
	public ArrayList<Writer> getWriters(){
		String select = "select no, name from writers_tbl";
		ArrayList<Writer> list = new ArrayList<Writer>();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Writer wr = new Writer();
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
		return list;
	} 
	
	//전체 도서정보 검색
	public ArrayList<Book> listBooks(){
		String select = "select b.id, b.name, w.name, publisher, price, "
				+ "to_char(p_date, 'yyyy/mm/dd') p_date "
				+ "from books_tbl b, writers_tbl w, bw_tbl bw "
				+ "where b.id = bw.b_id "
				+ "and w.no = bw.w_no ";
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Book bk = new Book();
				bk.setId(rs.getString(1));
				bk.setName(rs.getString(2));
				bk.setWriter(rs.getString(3));
				bk.setP_date(rs.getString(4));
				bk.setPrice(rs.getInt(5));
				bk.setPublisher(rs.getString(6));
				list.add(bk);
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
