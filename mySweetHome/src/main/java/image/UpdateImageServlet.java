package image;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import utility.ImageBbsDAO;

/**
 * Servlet implementation class UpdateImageServlet
 */
@WebServlet("/UpdateImageServlet")
public class UpdateImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateImageServlet() {
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
		String savePath = "upload/"; //업로드 파일 저장 폴더
		int maxLimit = 5 * 1024 * 1024; //최대 업로드 크기
		String encType = "UTF-8"; //언어 코드
		String fileName = ""; //업로드 성공 시 파일이름이 저장될 변수
		ServletContext ctx = this.getServletContext();
		String realPath = ctx.getRealPath(savePath); //절대경로
		String url = ""; //전환될 URL
		ImageBbsDAO dao = new ImageBbsDAO();
		try {
			MultipartRequest multipart = new MultipartRequest(request, realPath, maxLimit, encType, new DefaultFileRenamePolicy()); //업로드 객체 생성
			String title = multipart.getParameter("title");
			String pwd = multipart.getParameter("pwd");
			String content = multipart.getParameter("content");
			String id = multipart.getParameter("id");
		}catch(Exception e) {
			
		}
		response.sendRedirect(url); //화면 전환
	}

}
