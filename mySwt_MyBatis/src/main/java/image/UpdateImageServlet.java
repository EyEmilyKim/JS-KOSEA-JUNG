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

import model.ImageBBS;
import utility.ImageDAO;

/**
 * Servlet implementation class UpdateImageServlet
 */
@WebServlet("/updateImage.do")
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
		request.setCharacterEncoding("euc-kr");
		String savePath="/upload";//업로드 파일 저장 폴더
		int maxLimit= 5 * 1024 * 1024;//최대 업로드 크기
		String encType="euc-kr";//언어 코드
		String fileName="";//업로드 성공시 파일이름이 저장될 변수
		ServletContext ctx = this.getServletContext();
		String realPath=ctx.getRealPath(savePath);//절대경로
		String url="";//전환될 URL
		ImageDAO dao = new ImageDAO();
		try {
			MultipartRequest multipart = new MultipartRequest(
				request, realPath, maxLimit, encType,
				new DefaultFileRenamePolicy());//업로드객체생성
			String title=multipart.getParameter("title");
			String pwd=multipart.getParameter("pwd");
			String content=multipart.getParameter("content");
			String id=multipart.getParameter("id");
			ImageBBS bbs=dao.getImageDetail(
					Integer.parseInt(id));//글번호로 검색
			if(bbs.getPassword().equals(pwd)) {//암호가 일치
				bbs.setTitle(title);//제목을 설정
				bbs.setContent(content);//글내용을 설정
				fileName=multipart.getFilesystemName(
						"image_name");//업로드를 실행한다.
				if(fileName !=null || ! fileName.equals("")) {//이미지변경
					bbs.setImage_name(fileName);//이미지이름변경
				}
				//DB에서 update를 실행한다.
				dao.updateImage(bbs);
				url="template.jsp?BODY=imageUpdateResult.jsp";
				url=url+"?seqno="+id;
			}else {//암호가 불일치
				url="template.jsp?BODY=imageUpdateResult.jsp";
				url=url+"?id="+id;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(url);//화면 전환
	}

}








