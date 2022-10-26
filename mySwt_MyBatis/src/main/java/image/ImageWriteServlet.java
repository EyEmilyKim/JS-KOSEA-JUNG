package image;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.ImageBBS;
import utility.ImageDAO;

/**
 * Servlet implementation class ImageWriteServlet
 */
@WebServlet("/imageWrite.do")
public class ImageWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageWriteServlet() {
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
		String uploadPath = "/upload";//������ ������ �����̸�
		int maxLimit = 5*1024*1024;//���ε� �ִ� ũ�� ����(5M)
		String encType="euc-kr";//����ڵ�
		String fileName="";//���ε尡 �����ϸ� ���ϸ��� �����Һ���
		//�������� ���ε�� ������ ã�ƾ� �Ѵ�.
		//�̶� �ʿ��� ��ü�� ServletContext
		ServletContext ctx = this.getServletContext();
		String realPath = ctx.getRealPath(uploadPath);
		System.out.println("upload������ ������:"+realPath);
		String result = "";//�Խñ� ��� ���������� ���� ���� ����
		try {
			MultipartRequest multipart = new MultipartRequest(
				request,realPath,maxLimit,encType,
				new DefaultFileRenamePolicy());
			fileName = multipart.getFilesystemName("IMAGENAME");
			System.out.println("���ε�� ���ϸ�:"+fileName);
			if(fileName.equals("")) {//���ε� ����
				result = "N";
			}else {//���ε� ����
				String parentId=multipart.getParameter("parentid");
				String groupId=multipart.getParameter("groupid");
				String orderNo=multipart.getParameter("orderno");
				result = "Y";
				ImageDAO dao = new ImageDAO();
				ImageBBS bbs = new ImageBBS();
				int seqno = dao.getMaxSeqno() + 1;//�۹�ȣ
				bbs.setSeqno(seqno);//�۹�ȣ ����
				HttpSession session = request.getSession();
				String id = 
					(String)session.getAttribute("USERID");
				bbs.setId(id);//�ۼ��� ����
				////////////////��ۿ��θ� �˻�/����///
				if(parentId == null || parentId.equals("")) {//������ ���
					bbs.setGroup_id(seqno);//�׷��ȣ ����
					bbs.setParent_id(0);
					bbs.setOrder_no(0);
				}else {//����� ���
					bbs.setParent_id(Integer.parseInt(parentId));
					bbs.setGroup_id(Integer.parseInt(groupId));
					bbs.setOrder_no(Integer.parseInt(orderNo));
					//������ȣ(order_no)�� �ٲ۴�.(����Ŭ����)
					dao.updateOrderNo(bbs);
				}
				////////////////��ۿ��θ� �˻�/��////
				bbs.setTitle(multipart.getParameter("TITLE"));
				bbs.setPassword(multipart.getParameter("PWD"));
				bbs.setContent(multipart.getParameter("CONTENT"));
				bbs.setImage_name(fileName);
				boolean r = dao.putImageBBS(bbs);//insert����
				if(r == false) result = "N";
			}
		}catch(Exception e) {
			result = "N";
			e.printStackTrace();
		}
		response.sendRedirect(
			"template.jsp?BODY=uploadResult.jsp?R="+result);
	}

}







