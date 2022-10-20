package image;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ImageBbs;
import utility.ImageBbsDAO;

/**
 * Servlet implementation class DeleteImageServlet
 */
@WebServlet("/deleteImage.do")
public class DeleteImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteImageServlet() {
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
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		ImageBbsDAO dao = new ImageBbsDAO();
		ImageBbs bbs = dao.getImageDetail(Integer.parseInt(id));
		String url = "template.jsp?BODY=imageDeleteResult.jsp";
		if(bbs.getPassword().equals(pwd)) { //암호가 일치하는 경우
			dao.deleteImage(Integer.parseInt(id));
			//이미지가 삭제되는 경우 업로드 파일도 삭제한다. 시작
			String file = "/upload/"+bbs.getImage_name();
			ServletContext ctx = this.getServletContext();
			String realPath = ctx.getRealPath(file);
			File imageFile = new File(realPath);
			if(imageFile.exists()) { //파일이 존재하는 경우
				imageFile.delete(); //파일 삭제
			}
			//이미지가 삭제되는 경우 업로드 파일도 삭제한다. 끝
		}else { //암호가 일치하지 않는 경우
			url = url + "?id="+id;
		}
		response.sendRedirect(url);
	}

}
