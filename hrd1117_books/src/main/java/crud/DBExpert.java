package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	//도서ID로 도서정보 변경
	public boolean updateBook(Book bk) {
		System.out.println("updateBook() called");
		String update1 = "update books_tbl set "
				+ "name=?, publisher=?, price=?, p_date=to_date(?, 'yyyy/mm/dd') "
				+ "where id=?";
		String update2 = "update bw_tbl set "
				+ "w_no=? where b_id=?";
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag = false;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);
			conn.setAutoCommit(false);
			System.out.println("autoCommit? : "+conn.getAutoCommit());
			pstmt = conn.prepareStatement(update1);
			pstmt.setString(5, bk.getId());
			pstmt.setString(1, bk.getName());
			pstmt.setString(2, bk.getPublisher());
			pstmt.setInt(3, bk.getPrice());
			pstmt.setString(4, bk.getP_date());
			pstmt.executeUpdate();
			flag1 = true;
			System.out.println("flag1 : "+flag1);
			pstmt = conn.prepareStatement(update2);
			pstmt.setString(1, bk.getWriter());
			pstmt.setString(2, bk.getId());
			pstmt.executeUpdate();
			flag2 = true;
			System.out.println("flag2 : "+flag2);
			if(flag1 == true && flag2 == true) {
				conn.commit();
				System.out.println("commited");
				flag = true;
				System.out.println("flag : "+flag);
			}else {
				conn.rollback();
				System.out.println("try rollbacked");
			}
		}catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
				System.out.println("catch rollbacked");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try { pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("updateBook() end");
		return flag;
	}
	
	//도서ID로 도서정보 검색
	public Book getBook(Integer bid) {
		String select = "select id, tb.name, w.no, publisher, price, p_date "
				+ "from writers_tbl w, bw_tbl bw,  "
				+ "( select id, name, publisher, price, to_char(p_date, 'yyyy/mm/dd') p_date "
				+ "from books_tbl where id = ? ) tb "
				+ "where tb.id = bw.b_id "
				+ "and w.no = bw.w_no ";
		Book bk = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bk = new Book();
				bk.setId(rs.getString(1));
				bk.setName(rs.getString(2));
				bk.setWriter(rs.getString(3));
				bk.setPublisher(rs.getString(4));
				bk.setPrice(rs.getInt(5));
				bk.setP_date(rs.getString(6));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		return bk;
	}
	
	//도서정보 삭제
	public boolean deleteBook(Integer bid) {
		String delete = "delete books_tbl where id = ?";
		boolean flag = false;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, bid);
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
			conn.setAutoCommit(false);
			System.out.println("autoCommit? : "+conn.getAutoCommit());
			pstmt = conn.prepareStatement(insertAll);
			pstmt.setString(1, bk.getId());
			pstmt.setString(2, bk.getName());
			pstmt.setString(3, bk.getPublisher());
			pstmt.setInt(4, bk.getPrice());
			pstmt.setString(5, bk.getP_date());
			pstmt.setString(6, bk.getId());
			pstmt.setString(7, bk.getWriter());
			pstmt.executeUpdate();
//			conn.rollback();
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
				+ "and w.no = bw.w_no "
				+ "order by id ";
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
				bk.setPublisher(rs.getString(4));
				bk.setPrice(rs.getInt(5));
				bk.setP_date(rs.getString(6));
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
