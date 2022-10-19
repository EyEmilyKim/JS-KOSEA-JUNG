package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.ImageBbs;

public class ImageBbsDAO {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//전체 이미지게시글의 건수 검색 메서드
	public Integer getImageCount() {
		String select = "select count(*) from mysweet_imagebbs";
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
	
	//이미지게시글 목록 검색 메서드
	public ArrayList<ImageBbs> getAllImages(int start, int end){
		String select = "select seqno, group_id, parent_id, order_no, title, id, "
				+ "to_char(reg_date, 'YYYY-MM-DD HH24:MI:SS'), image_name, content, password "
				+ "from "
				+ "( "
				+ "select img.* , rownum rn "
				+ "from "
				+ "( select * from mysweet_imagebbs order by seqno desc ) img "
				+ ") "
				+ "where rn between ? and ? ";
		ArrayList<ImageBbs> list = new ArrayList<ImageBbs>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ImageBbs bbs = new ImageBbs();
				bbs.setSeqno(rs.getInt(1)); //글번호 설정
				bbs.setGroup_id(rs.getInt(2)); //그룹번호 설정
				bbs.setParent_id(rs.getInt(3)); //부모글번호 설정
				bbs.setOrder_no(rs.getInt(4)); //답글번호 설정
				bbs.setTitle(rs.getString(5)); //제목 설정
				bbs.setId(rs.getString(6)); //작성자(계정) 설정
				bbs.setReg_date(rs.getString(7)); //작성일 설정
				bbs.setImage_name(rs.getString(8)); //이미지명 설정
				bbs.setContent(rs.getString(9)); //글내용 설정
				bbs.setPassword(rs.getString(10)); //암호 설정
				list.add(bbs); //ArrayList에 DTO 저장
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); con.close(); }
			catch(Exception e) {}
		}
		return list;
	}
	
	//이미지게시글 삽입 메서드
	public boolean putImageBBS(ImageBbs bbs) {
		String insert = "insert into mysweet_imagebbs values(?,?,?,?,?,?,"
				+ "sysdate,?,?,?)";
		boolean result = false; //삽입의 결과를 위한 변수
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, bbs.getSeqno());
			pstmt.setInt(2, bbs.getGroup_id());
			pstmt.setInt(3, bbs.getParent_id());
			pstmt.setInt(4, bbs.getOrder_no());
			pstmt.setString(5, bbs.getTitle());
			pstmt.setString(6, bbs.getId());
			pstmt.setString(7, bbs.getImage_name());
			pstmt.setString(8, bbs.getContent());
			pstmt.setString(9, bbs.getPassword());
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
	
	//최대 글번호 검색 메서드
	public Integer getMaxSeqno() {
		String select = "select max(seqno) from mysweet_imagebbs";
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
}
