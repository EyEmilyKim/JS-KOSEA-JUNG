package image;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ImageBbs;
import utility.ImageBbsDAO;

/**
 * Servlet implementation class ImageReplyServlet
 */
@WebServlet("/imageReply.do")
public class ImageReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageReplyServlet() {
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
		String parentId = request.getParameter("parentid");
		String groupId = request.getParameter("groupid");
		System.out.println(parentId);
		//답글 여부를 판단한다.
		if(parentId != null) { //부모글 번호가 있으므로 답글
			String title = "";
			ImageBbsDAO dao = new ImageBbsDAO();
			ImageBbs bbs = dao.getImageDetail(Integer.parseInt(parentId)); //원글 검색
			bbs.setParent_id(Integer.parseInt(parentId));
			if(bbs != null) title = "Re]"+bbs.getTitle();
			request.setAttribute("title", title);
			request.setAttribute("IMG", bbs);
		}
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=imageForm.jsp");
		rd.forward(request, response);
		
	}

}
