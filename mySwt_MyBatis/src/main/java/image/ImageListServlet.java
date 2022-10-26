package image;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ImageBBS;
import utility.ImageDAO;

/**
 * Servlet implementation class ImageListServlet
 */
@WebServlet("/imageList.do")
public class ImageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ImageDAO dao = new ImageDAO();
		String page = request.getParameter("PAGE");
		String seqno = request.getParameter("seqno");//�۹�ȣ
		int totalCount = dao.getImageCount();//��ü ���� ����
		int pageNum = 1;
		if(page != null) pageNum = Integer.parseInt(page);
		//seqno�� �ִ� �۹�ȣ�� ��������ȣ�� ã�´�. ����
		if(seqno != null) {
			int rownum = dao.getRownumBySeqno(
					Integer.parseInt(seqno));
			int p = rownum / 5;
			if(rownum % 5 > 0) p++;
			pageNum = p;
		}
		//seqno�� �ִ� �۹�ȣ�� ��������ȣ�� ã�´�. ��
		int pageCount = 0;
		int startRow = 0;	int endRow = 0;
		if(totalCount > 0) {//�̹��� �Խñ��� �����ϴ� ���
			pageCount = totalCount / 5;
			if(totalCount % 5 > 0) pageCount++;//������ ����
			startRow = (pageNum - 1) * 5 + 1;
			endRow = pageNum * 5;
			if(endRow > totalCount) endRow = totalCount;
		}
		ArrayList<ImageBBS> list = 
				dao.getAllImages(startRow, endRow);
		request.setAttribute("currentPage", pageNum);
		request.setAttribute("IMGLIST", list);
		request.setAttribute("TOTAL", totalCount);
		request.setAttribute("START", startRow);
		request.setAttribute("END", endRow);
		request.setAttribute("PAGES", pageCount);
		RequestDispatcher rd = 
			request.getRequestDispatcher(
				"template.jsp?BODY=imageList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
