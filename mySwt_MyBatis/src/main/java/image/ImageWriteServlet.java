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
		String uploadPath = "/upload";//파일을 저장할 폴더이름
		int maxLimit = 5*1024*1024;//업로드 최대 크기 설정(5M)
		String encType="euc-kr";//언어코드
		String fileName="";//업로드가 성공하면 파일명을 저장할변수
		//서블릿에서 업로드될 폴더를 찾아야 한다.
		//이때 필요한 객체가 ServletContext
		ServletContext ctx = this.getServletContext();
		String realPath = ctx.getRealPath(uploadPath);
		System.out.println("upload폴더의 절대경로:"+realPath);
		String result = "";//게시글 등록 성공유무를 위한 변수 선언
		try {
			MultipartRequest multipart = new MultipartRequest(
				request,realPath,maxLimit,encType,
				new DefaultFileRenamePolicy());
			fileName = multipart.getFilesystemName("IMAGENAME");
			System.out.println("업로드된 파일명:"+fileName);
			if(fileName.equals("")) {//업로드 실패
				result = "N";
			}else {//업로드 성공
				String parentId=multipart.getParameter("parentid");
				String groupId=multipart.getParameter("groupid");
				String orderNo=multipart.getParameter("orderno");
				result = "Y";
				ImageDAO dao = new ImageDAO();
				ImageBBS bbs = new ImageBBS();
				int seqno = dao.getMaxSeqno() + 1;//글번호
				bbs.setSeqno(seqno);//글번호 설정
				HttpSession session = request.getSession();
				String id = 
					(String)session.getAttribute("USERID");
				bbs.setId(id);//작성자 설정
				////////////////답글여부를 검사/시작///
				if(parentId == null || parentId.equals("")) {//원글인 경우
					bbs.setGroup_id(seqno);//그룹번호 설정
					bbs.setParent_id(0);
					bbs.setOrder_no(0);
				}else {//답글인 경우
					bbs.setParent_id(Integer.parseInt(parentId));
					bbs.setGroup_id(Integer.parseInt(groupId));
					bbs.setOrder_no(Integer.parseInt(orderNo));
					//순서번호(order_no)를 바꾼다.(오라클쿼리)
					dao.updateOrderNo(bbs);
				}
				////////////////답글여부를 검사/끝////
				bbs.setTitle(multipart.getParameter("TITLE"));
				bbs.setPassword(multipart.getParameter("PWD"));
				bbs.setContent(multipart.getParameter("CONTENT"));
				bbs.setImage_name(fileName);
				boolean r = dao.putImageBBS(bbs);//insert실행
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







