package notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Notice;
import utility.Crud;

/**
 * Servlet implementation class NoticePostServlet
 */
@WebServlet("/noticePost.do")
public class NoticePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticePostServlet() {
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
		String title=request.getParameter("TITLE");
		String content=request.getParameter("CONTENT");
		HttpSession session = request.getSession();
		//�ۼ���:���ǿ��� MANAGERã�´�.
		String id = (String)session.getAttribute("MANAGER");
		//�۹�ȣ:�ִ� �۹�ȣ + 1
		Crud crud = new Crud();
		int seqno = crud.getMaxNotice() + 1;
		Notice notice = new Notice();
		notice.setSeqno(seqno);//�۹�ȣ ����
		notice.setTitle(title);//������ ����
		notice.setWriter(id);//�ۼ��� ����
		notice.setContent(content);//�۳��� ����
		Integer result = crud.putNotice(notice);//insert����
		String url="template.jsp?BODY=noticeResult.jsp?R=";
		if(result > 0) {//������ ��� ������ ���
			response.sendRedirect(url+"Y");
		}else {//������ ��� ������ ���
			response.sendRedirect(url+"N");
		}
	}

}







