package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Order;

public class DBExpert {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private String uid = "hr";
	private String upw = "hr";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//주문상세정보 목록 검색
	public ArrayList<Order> listOrders(){
		System.out.println("listOrders() called");
		String sql = "select g.id, g.name, c.name, g.price, c.address, "
				+ "c.phone, o.o_date, c.no "
				+ "from goods_info g, guests_info c, goods_guests o "
				+ "where g.id = o.id "
				+ "and o.no = c.no  ";
		ArrayList<Order> list = new ArrayList<Order>();
		try {
			System.out.println("listOrders() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("listOrders() true");
				Order odr = new Order();
				odr.setId(rs.getString(1));
				odr.setName(rs.getString(2));
				odr.setG_name(rs.getString(3));
				odr.setPrice(rs.getInt(4));
				odr.setAddr(rs.getString(5));
				odr.setPhone(rs.getString(6));
				odr.setO_date(rs.getString(7));
				odr.setG_no(rs.getInt(8));
				list.add(odr);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close();}
			catch(Exception e) {}
		}
		System.out.println("listOrders() end");
		return list;
	} 
}
