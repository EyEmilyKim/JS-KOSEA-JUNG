package aug10;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BusProcessDoServlet
 */
@WebServlet("/busProcess.do")
public class BusProcessDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusProcessDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = (String)request.getParameter("DESTINATION");//목적지
		String price = (String)request.getParameter("PRICE");//운임
		String num = (String)request.getParameter("NUM");//인원수
		String seat = (String)request.getParameter("SEAT");//좌석종류
		int priceInt = Integer.parseInt(price);//문자열->정수
		int numInt = Integer.parseInt(num);//문자열->정수
		double totalDouble = 0;//최종요금을 위한 변수 선언
		if(seat.equals("1")){//일반석
			totalDouble = priceInt * 1 * numInt;//오차 발생
//		 	BigDecimal priceD = new BigDecimal(price);
//		 	BigDecimal numD = new BigDecimal(num);
//		 	BigDecimal totalD = priceD.multiply(numD);
//		 	System.out.println("총계 : "+totalD+" 원입니다.");
		}else if(seat.equals("2")){//우등석
			totalDouble = priceInt * 1.1 * numInt;
//		 	BigDecimal priceD = new BigDecimal(price);
//		 	BigDecimal numD = new BigDecimal(num);
//		 	BigDecimal totalD = priceD.multiply(numD);
//		 	BigDecimal seatD = new BigDecimal("1.1");
//		 	BigDecimal TotalD_ = totalD.multiply(seatD);
//		 	System.out.println("총계 : "+ TotalD_ +" 원입니다.");
		}
		int total = (int)totalDouble;

		//1.Redirect
		response.sendRedirect("template.jsp?BODY=703.busResult.jsp?SUM="+total+"&D="+destination+"&S="+seat+"&N="+num);

		//2.Forward
		// RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=703.busResult.jsp?SUM="+total);
		// rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
