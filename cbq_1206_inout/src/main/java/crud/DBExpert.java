package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Company;
import model.Inout;
import model.Product;
import model.Profit;

public class DBExpert {
	private String driver = "oracle.jdbc.OracleDriver"; 
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe"; 
	private String uid = "system"; 
	private String upw = "1234"; 
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//전체 출고매출이익 통계 조회
	public ArrayList<Profit> listProfit(){
//		System.out.println("listProfit() called");
		String sql = "select t4.p_code, p.p_name, t4.totalcnt, to_char(t4.totalprofit , '999,999,999,999') totalprofit \r\n"
				+ "from (\r\n"
				+ "select t3.p_code, sum(t3.cnt) totalcnt, sum(t3.profit) totalprofit \r\n"
				+ "from (\r\n"
				+ "select i.p_code, i.t_cnt cnt, (i.t_cnt*(p.p_outcost - p.p_incost)) profit \r\n"
				+ "from tbl_inout_202002 i , tbl_product_202002 p \r\n"
				+ "where i.p_code = p.p_code \r\n"
				+ "order by i.p_code \r\n"
				+ ") t3\r\n"
				+ "group by t3.p_code \r\n"
				+ "order by t3.p_code \r\n"
				+ ") t4, tbl_product_202002 p \r\n"
				+ "where t4.p_code = p.p_code \r\n"
				+ "order by t4.p_code ";
		ArrayList<Profit> list = new ArrayList<Profit>();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
//				System.out.println("listProfit() true");
				Profit prf = new Profit();
				prf.setP_code(rs.getString(1));
				prf.setP_name(rs.getString(2));
				prf.setTotalCnt(rs.getInt(3));
				prf.setTotalProfit_str(rs.getString(4));
				list.add(prf);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
//		System.out.println("listProfit() end");
		return list;
	}
	
	//전체 입출고정보 조회
	public ArrayList<Inout> listInout(){
//		System.out.println("listInout() called");
		String sql = "select "
				+ "i.t_no, i.p_code, p.p_name, i.t_type, "
				+ "i.t_cnt, c.c_name, to_char(i.t_date, 'yyyy-mm-dd') \r\n"
				+ "from tbl_inout_202002 i , tbl_product_202002 p , tbl_company_202002 c \r\n"
				+ "where 1=1 \r\n"
				+ "and i.p_code = p.p_code \r\n"
				+ "and i.c_code = c.c_code \r\n"
				+ "order by i.t_no ";
		ArrayList<Inout> list = new ArrayList<Inout>();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
//				System.out.println("listInout() true");
				Inout io = new Inout();
				io.setT_no(rs.getString(1));
				io.setP_code(rs.getString(2));;
				io.setP_name(rs.getString(3));
				io.setT_type(rs.getString(4));
				io.setT_cnt(rs.getInt(5));
				io.setC_name(rs.getString(6));
				io.setT_date_fmt(rs.getString(7));
				list.add(io);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
//		System.out.println("listInout() end");
		return list;
	}
	
	//입출고정보 삽입
	public boolean insertInout(Inout io) {
//		System.out.println("insertInout() called");
		String sql = "insert into "
				+ "tbl_inout_202002 values( \r\n"
				+ " ?,?,?,?,to_date(?, 'yyyymmdd'),? ) ";
		boolean flag = false;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, io.getT_no());
			pstmt.setString(2, io.getP_code());
			pstmt.setString(3, io.getT_type());
			pstmt.setInt(4, io.getT_cnt());
			pstmt.setString(5, io.getT_date());
			pstmt.setString(6, io.getC_code());
			pstmt.executeUpdate();
			conn.commit();
			flag = true;
//			System.out.println("insertInout() true. commit done.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
//		System.out.println("insertInout() end");
		return flag;
	}
	
	//마지막 입출고번호 조회 (for 입출고등록)
	public String getLastTno() {
//		System.out.println("getLastTno() called");
		String sql = "select t_no from tbl_inout_202002 ";
		String last = "20220000"; //입출고 내역 1개도 없을때 초기값
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
//				System.out.println("getLastTno() true");
				last = rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
//		System.out.println("getLastTno() end");
		return last;
	}
	
	//전체 거래처코드, 거래처명 조회 (for 입출고등록)
	public ArrayList<Company> listCompany(){
//		System.out.println("listCompany() called");
		String sql = "select c_code, c_name \r\n"
				+ "from tbl_company_202002 ";
		ArrayList<Company> list = new ArrayList<Company>();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
//				System.out.println("listCompany() true");
				Company cmp = new Company();
				cmp.setC_code(rs.getString(1));
				cmp.setC_name(rs.getString(2));;
				list.add(cmp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
//		System.out.println("listCompany() end");
		return list;
	}	
	
	//전체 제품정보 조회
	public ArrayList<Product> listProduct(){
//		System.out.println("listProduct() called");
		String sql = "select "
				+ "p_code, p_name, p_size, "
				+ "to_char(p_incost, '9,999'), to_char(p_outcost, '9,999') \r\n"
				+ "from tbl_product_202002 "
				+ "order by p_code ";
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
//				System.out.println("listProduct() true");
				Product prd = new Product();
				prd.setP_code(rs.getString(1));
				prd.setP_name(rs.getString(2));;
				prd.setP_size(rs.getInt(3));
				prd.setP_incost_str(rs.getString(4));
				prd.setP_outcost_str(rs.getString(5));
				list.add(prd);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close(); }
			catch(Exception e) {}
		}
//		System.out.println("listProduct() end");
		return list;
	}
}
