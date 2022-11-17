package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Book;

public class DBExpert {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private String id = "hr";
	private String pw = "hr";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//전체 도서정보 검색
	public ArrayList<Book> listBooks(){
		String select = "select b.id, b.name, w.name, publisher, price, "
				+ "to_char(p_date, 'yyyy/mm/dd') "
				+ "from books_tbl b, writers_tbl w, bw_tbl bw"
				+ "where b.id = bw.b_id "
				+ "and w.no = bw.w_no";
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
				bk.setP_date(rs.getString(3));
				bk.setPrice(rs.getInt(4));
				bk.setPublisher(rs.getString(5));
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
