package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Book;
import model.Customer;

public class DBExpert {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private String uid = "hr"; //시험:"system"
	private String upw = "hr"; //시험:"1234"
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//전체 회원정보 검색
	public ArrayList<Customer> listCustomer(){
		System.out.println("listCustomer() called");
		String sql = "select p_id, c_name, c_email, c_tel \r\n"
				+ "from custom_01 ";
		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			System.out.println("listCustomer() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("listCustomer() true");
				Customer cst = new Customer();
				cst.setP_id(rs.getString(1));
				cst.setC_name(rs.getString(2));
				cst.setC_email(rs.getString(3));
				cst.setC_tel(rs.getString(4));
				list.add(cst);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
		System.out.println("listCustomer() end");
		return list;
	}
}
