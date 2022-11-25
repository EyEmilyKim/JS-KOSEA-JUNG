package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Goods;
import model.Order;

public class DBExpert {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private String uid = "hr";
	private String upw = "hr";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//상품 정보 삽입
	public boolean insertGoods(Goods gds) {
		System.out.println("insertGoods() called");
		String sql = "insert into goods_info values ( ?,?,?,? )";
		boolean flag = false;
		try {
			System.out.println("insertGoods() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gds.getId());
			pstmt.setString(2, gds.getName());
			pstmt.setInt(3, gds.getPrice());
			pstmt.setString(4, gds.getMade());
			pstmt.executeUpdate();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); conn.close();}
			catch(Exception e) {}
		}
		System.out.println("insertGoods() end");
		return flag;
	}
	
	//전체 상품 id, name 검색 (for 상품등록 중복검사)
	public ArrayList<Goods> getGoods(){
		System.out.println("getGoods() called");
		String sql = "select id, name from goods_info ";
		ArrayList<Goods> list = new ArrayList<Goods>();
		try {
			System.out.println("getGoods() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("getGoods() true");
				Goods gds = new Goods();
				gds.setId(rs.getString(1));
				gds.setName(rs.getString(2));
				list.add(gds);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close();}
			catch(Exception e) {}
		}
		System.out.println("getGoods() end");
		return list;
	}
	
	//상품 목록 조회
	public ArrayList<Goods> listGoods(){
		System.out.println("listGoods() called");
		String sql = "select id, name, price, made from goods_info ";
		ArrayList<Goods> list = new ArrayList<Goods>();
		try {
			System.out.println("listGoods() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("listGoods() true");
				Goods gds = new Goods();
				gds.setId(rs.getString(1));
				gds.setName(rs.getString(2));
				gds.setPrice(rs.getInt(3));
				gds.setMade(rs.getString(4));
				list.add(gds);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close();}
			catch(Exception e) {}
		}
		System.out.println("listGoods() end");
		return list;
	} 
	
	//주문개요정보 삽입
	public boolean insertOrder(Order odr) {
		System.out.println("insertOrder() called");
		String sql = "insert into goods_guests values ( ?,?,? )";
		boolean flag = false;
		try {
			System.out.println("insertOrder() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, odr.getId());
			pstmt.setInt(2, odr.getG_no());
			pstmt.setString(3, odr.getO_date());
			pstmt.executeUpdate();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); conn.close();}
			catch(Exception e) {}
		}
		System.out.println("insertOrder() end");
		return flag;
	}
		
	//주문상세정보 목록 검색
	public ArrayList<Order> listOrders(){
		System.out.println("listOrders() called");
		String sql = "select g.id, g.name, c.name, g.price, c.address, "
				+ "c.phone, o.o_date, c.no "
				+ "from goods_guests o, goods_info g, guests_info c "
				+ "where o.id = g.id "
				+ "and o.no = c.no ";
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
