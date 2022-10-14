package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Bbs;
import model.Item;
import model.Member;
import model.Notice;

public class DAO {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//로그인 계정으로 장바구니 테이블 검색 메서드
	public ArrayList<Item> getCartById(String id){
		String select = "select code, num from mysweet_cart where id=?";
		ArrayList<Item> itemList = new ArrayList<Item>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, id); 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Item item = new Item();
				item.setCode(rs.getString(1));
				item.setNum(rs.getInt(2));
				itemList.add(item);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return itemList;
	}
	
	//장바구니 테이블에서 상품 삭제 메서드
	public boolean deleteCart(String code, String id) {
		String delete = "delete from mysweet_cart where code=? and id=?";
		boolean result = false;
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(delete);
			pstmt.setString(1, code);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); con.close(); }
			catch(Exception e){}
		}
		return result;
	}
	
	//장바구니 테이블에 수량 변경 메서드
	public boolean updateCart(Item i) {
		String update = "update mysweet_cart set num=? where id=? and code=?";
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(update);
			pstmt.setInt(1, i.getNum());
			pstmt.setString(2, i.getId());
			pstmt.setString(3, i.getCode());
			System.out.println("--장바구니의 상품 수량 수정--");
			System.out.println("num: "+i.getNum());
			System.out.println("id: "+i.getId());
			System.out.println("code: "+i.getCode());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return result;
	}
	
	//장바구니 테이블에 삽입하는 메서드
	public boolean putCart(Item i) {
		String input = "insert into mysweet_cart values(?,?,?,?)";
		boolean result = false; //삽입결과를 위한 변수 선언
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(input);
			pstmt.setInt(1, i.getSeqno());
			pstmt.setString(2, i.getId());
			pstmt.setString(3, i.getCode());
			pstmt.setInt(4, i.getNum());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return result;
	}
	
	//장바구니 테이블에서 가장 큰 일련번호 검색 메서드
	public Integer getMaxCartSeqno() {
		String select = "select max(seqno) from mysweet_cart";
		Integer max = 0; 
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) max = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {rs.close(); pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return max;
	}
	
	//상품번호로 상품정보를 수정하는 메서드
	public boolean updateItem(Item i) {
		String update = "update mysweet_items set name=?, price=?, info=? "
				+ "where code=?";
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, i.getName());
			pstmt.setInt(2, i.getPrice());
			pstmt.setString(3, i.getInfo());
			pstmt.setString(4, i.getCode());
			System.out.println("--상품 수정--");
			System.out.println("name: "+i.getName());
			System.out.println("price: "+i.getPrice());
			System.out.println("info: "+i.getInfo());
			System.out.println("code: "+i.getCode());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return result;
	}
	
	//상품번호로 상품정보를 삭제하는 메서드
	public boolean deleteItem(String code) {
		String delete = "delete from mysweet_items where code = ?";
		boolean result = false;
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(delete);
			pstmt.setString(1, code);
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); con.close(); }
			catch(Exception e){}
		}
		return result;
	}

	
	//상품번호로 상품정보를 검색하는 메서드
	public Item getItemDetail(String code) {
		String select = "select code, name, price, info, "
				+ "to_char(reg_date, 'YYYY-MM-DD HH24:MI:SS' ) "
				+ "from mysweet_items where code = ?";
		Item item = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			if(rs.next()){
				item = new Item();
				item.setCode(rs.getString(1));
				item.setName(rs.getString(2));
				item.setPrice(rs.getInt(3));
				item.setInfo(rs.getString(4));
				item.setReg_date(rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return item;
	}
	
	//전체 상품의 갯수를 검색하는 메서드
	public Integer getTotalItemCount() {
		String select = "select count(*) from mysweet_items";
		Integer total = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) total = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); con.close(); }
			catch(Exception e){}
		}
		return total;
	}
	
	//페이지에 해당하는 상품정보 조회 메서드
	public ArrayList<Item> getAllItems(int start, int end){
		String select = "select code, name, price, r_date "
				+ "from (select rownum rn, code, name, price, r_date "
				+ "from (select code, name, price, to_char(reg_date, 'YYYY/MM/DD') r_date "
				+ "from mysweet_items) ) "
				+ "where rn > ? and rn < ? ";
		ArrayList<Item> list = new ArrayList<Item>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, start); 
			pstmt.setInt(2, end); 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Item item = new Item();
				item.setCode(rs.getString(1));
				item.setName(rs.getString(2));
				item.setPrice(rs.getInt(3));
				item.setReg_date(rs.getString(4));
				list.add(item);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return list;
	}
	
	//상품정보 삽입 메서드
	public boolean putItem(Item i) {
		String input = "insert into mysweet_items values(?, ?, ?, ?, sysdate)";
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(input);
			pstmt.setString(1, i.getCode());
			pstmt.setString(2, i.getName());
			pstmt.setInt(3, i.getPrice());
			pstmt.setString(4, i.getInfo());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return result;
	}
	
	//입력된 상품번호으로 상품번호 검색 메서드(상품번호 중복검사용)
	public String getCode(String code) {
		String select = "select code from mysweet_items where code = ?";
		String selectedCode = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			if(rs.next()) selectedCode = rs.getString(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); con.close(); }
			catch(Exception e){}
		}
		return selectedCode;
	}
		
	//회원정보 삽입 메서드
	public boolean putMember(Member mem) {
		String insert = "insert into mysweet_users values(?,?,?,?,?,?,?,?)";
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPwd());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getAddr());
			pstmt.setString(5, mem.getTel());
			pstmt.setString(6, mem.getGender());
			pstmt.setString(7, mem.getEmail());
			pstmt.setString(8, mem.getJob());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return result;
	}
	
	//입력된 계정으로 계정 검색 메서드(계정 중복검사용)
	public String getId(String id) {
		String select = "select id from mysweet_users where id = ?";
		String selectedId = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) selectedId = rs.getString(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); con.close(); }
			catch(Exception e){}
		}
		return selectedId;
	}
	
	//공지글 번호로 공지사항 수정 메서드
	public boolean modifyNotice(Notice n) {
		String update = "update mysweet_notice set title=?, content=? where seqno = ?";
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, n.getTitle());
			pstmt.setString(2, n.getContent());
			pstmt.setInt(3, n.getSeqno());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return result;
	}
	
	//공지글 번호로 공지사항 삭제 메서드
	public boolean deleteNotice(int seqno) {
		String delete = "delete from mysweet_notice where seqno = ?";
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, seqno);
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return result;
	}
	
	//공지글 번호로 공지사항 검색 메서드
	public Notice getNoticeDetail(int seqno) {
		String select = "select seqno, title, writer, to_char(reg_date, 'YYYY-MM-DD HH24:MI;SS'), content "
				+ "from mysweet_notice where seqno = ?";
		Notice notice = null;
		try {
//			System.out.println(seqno);
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, seqno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				notice = new Notice();
				notice.setSeqno(rs.getInt(1));
				notice.setTitle(rs.getString(2));
				notice.setWriter(rs.getString(3));
				notice.setReg_date(rs.getString(4));
				notice.setContent(rs.getString(5));
//				System.out.println(rs.getString(2));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); con.close(); }
			catch(Exception e){}
		}
		return notice;
	}
	
	//전체 공지사항 건수 검색 메서드
	public Integer getNoticeCount() {
		String select = "select count(*) from mysweet_notice";
		Integer count = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return count;
	}
	
	//해당 페이지에 출력될 공지사항 검색 메서드
	public ArrayList<Notice> getAllNotice(int start, int end){
		String select = "select seqno, title, writer, r_date "
				+ "from ( select rownum rn, seqno, title, writer, r_date from "
				+ "(select seqno, title, writer, to_char(reg_date, 'YYYY-MM-DD HH24:MI:SS') r_date "
				+ "from mysweet_notice order by seqno desc ) ) "
				+ "where rn > ? and rn < ? ";
		ArrayList<Notice> list = new ArrayList<Notice>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, start); 
			pstmt.setInt(2, end); 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Notice notice = new Notice();
				notice.setSeqno(rs.getInt(1));
				notice.setTitle(rs.getString(2));
				notice.setWriter(rs.getString(3));
				notice.setReg_date(rs.getString(4));
				list.add(notice);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return list;
	}
	
	//가장 큰 공지사항 번호 검색하는 메서드
	public Integer getMaxNotice() {
		String select = "select max(seqno) from mysweet_notice";
		Integer max = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) max = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return max;
	}
	
	//공지사항 삽입 메서드
	public boolean putNotice(Notice n) {
		String insert = "insert into mysweet_notice values(?, ?, ?, sysdate, ?)";
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, n.getSeqno());
			pstmt.setString(2, n.getTitle());
			pstmt.setString(3, n.getWriter());
			pstmt.setString(4, n.getContent());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return result;
	}
	
	//글번호로 게시글을 조회하는 메서드
	public Bbs getBbsDetail(int seqno) {
		String select = "select seqno, title, writer, "
				+ "to_char(reg_date, 'YYYY-MM-DD HH24:MI:SS'), content "
				+ "from mysweet_bbs where seqno = ?";
		Bbs bbs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, seqno);
			rs = pstmt.executeQuery();
			if(rs.next()) { //조회결과가 존재하는 경우
				bbs = new Bbs();
				bbs.setSeqno(rs.getInt(1));
				bbs.setTitle(rs.getString(2));
				bbs.setWriter(rs.getString(3));
				bbs.setReg_date(rs.getString(4));
				bbs.setContent(rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return bbs;
	}
	
	//전체 게시글의 갯수 찾는 메서드
	public Integer getTotalCount() {
		String select = "select count(*) from mysweet_bbs";
		Integer totalCount = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) { //조회결과가 존재하는 경우
				totalCount = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return totalCount;
	}
	
	//게시글 조회 메서드(페이지 당 5개의 글만 검색)
	public ArrayList<Bbs> getPageBbs(int start, int end){
		String select = "select seqno, title, writer, r_date "
				+ "from ( select rownum rn, seqno, title, writer, r_date from "
				+ "(select seqno, title, writer, to_char(reg_date, 'YYYY-MM-DD HH24:MI:SS') r_date "
				+ "from mysweet_bbs order by seqno desc ) ) "
				+ "where rn > ? and rn < ? ";
		ArrayList<Bbs> list = new ArrayList<Bbs>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setSeqno(rs.getInt(1)); //글번호
				bbs.setTitle(rs.getString(2)); //제목
				bbs.setWriter(rs.getString(3)); //작성자
				bbs.setReg_date(rs.getString(4)); //작성일
				list.add(bbs);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return list;
	}
	
	//게시글 삽입 메서드
	public boolean putBbs(Bbs bbs) {
		String insert = "insert into mysweet_bbs values(?,?,?,sysdate,?)";
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, bbs.getSeqno()); //글번호
			pstmt.setString(2, bbs.getTitle()); //글제목
			pstmt.setString(3, bbs.getWriter()); //작성자
			pstmt.setString(4, bbs.getContent()); //글내용
			pstmt.executeUpdate(); //insert 실행
			con.commit(); //commit
			result = true; //삽입 성공을 의미
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return result;
	}
	
	//게시글 테이블에서 가장 큰 글번호를 찾는 메서드
	public Integer getMaxSeqno() {
		String select = "select max(seqno) from mysweet_bbs";
		Integer max = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) {//조회결과가 존재하는 경우
				max = rs.getInt(1);
			}else {//조회결과가 존재하지 않는 경우
				max = 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {rs.close(); pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return max;
	}
	
	//계정으로 암호 검색
	public String getPwd(String id) {
		String select = "select pwd from mysweet_users where id = ?";
		String pwd = null; //검색된 암호 저장할 변수 선언
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pwd = rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return pwd;
	}
}
