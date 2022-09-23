package sep22;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sep21.BBS;

/**
 * Servlet implementation class GetBbsServlet
 */
@WebServlet("/getBBS.do")
public class GetBbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBbsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String title = request.getParameter("TITLE");
		String writer = request.getParameter("WRITER");
		String date = request.getParameter("DATE");
//		System.out.println("--검색 test--");
//		System.out.println(id);
//		System.out.println(title);
//		System.out.println(writer);
//		System.out.println(date);

		String select = "select seqno, id, title, to_char(reg_date,'YYYY-MM-DD'), content from test_tbl where 1=1 ";
		//날짜 데이터를 문자열 처리(to_char)해서 가져오기 위해 * 대신 컬럼명 나열로 쿼리 작성.(문자열: 변수에 넣기 위해)
		if(! id.equals(""))
			select = select + "and seqno="+id+" ";
		if(! title.equals(""))
			select = select + "and title='"+title+"' ";
		if(! writer.equals(""))
			select = select + "and id='"+writer+"' ";
		if(! date.equals(""))
			select = select + "and reg_date= to_date('"+date+"', 'YYYY-MM-DD') ";
//		System.out.println(select);
		
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null; //조회결과를 받아주는 객체
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery(); //select 실행(select는 executeUpdate()아님!)
			//조회결과로 이동(next())시킨다 -> 만약 rs 검색 결과가 3건이면 3번 이동해서 가져오도록..
			//각각의 결과 = 1:글번호(숫자)/2:작성자(문자열)/3:제목(문자열)/4:작성일(날짜)/5:내용(문자열)
			BBS[] bbsArr = new BBS[3]; //예를 들어 3건 -> 3칸짜리 배열
			int idx = 0;
			while(rs.next()) { //이동 성공(true), 실패(false)
				int seqno = rs.getInt(1);
				String w = rs.getString(2);
				String t = rs.getString(3);
				String d = rs.getString(4);
				String c = rs.getString(5);
				BBS bbs = new BBS(); //DTO 생성
				bbs.setSeqno(rs.getInt(1));
				bbs.setId(rs.getString(2));
				bbs.setTitle(rs.getString(3));
				bbs.setContent(rs.getString(5));
				bbsArr[idx++] = bbs;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
	}
	

}
