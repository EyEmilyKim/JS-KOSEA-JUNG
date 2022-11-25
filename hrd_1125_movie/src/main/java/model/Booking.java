package model;

public class Booking {
	String m_id; //영화번호
	String w_no; //고객번호
	Integer tickets; //예매 수
	String r_date; //예매일
	
	String w_name; //예매자
	String w_phone; //연락처
	String m_title; //영화제목
	String startHr; //시작시간
	String endHr; //종료시간
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getW_no() {
		return w_no;
	}
	public void setW_no(String w_no) {
		this.w_no = w_no;
	}
	public Integer getTickets() {
		return tickets;
	}
	public void setTickets(Integer tickets) {
		this.tickets = tickets;
	}
	public String getR_date() {
		return r_date;
	}
	public void setR_date(String r_date) {
		this.r_date = r_date;
	}
	public String getW_name() {
		return w_name;
	}
	public void setW_name(String w_name) {
		this.w_name = w_name;
	}
	public String getW_phone() {
		return w_phone;
	}
	public void setW_phone(String w_phone) {
		this.w_phone = w_phone;
	}
	public String getM_title() {
		return m_title;
	}
	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
	public String getStartHr() {
		return startHr;
	}
	public void setStartHr(String startHr) {
		this.startHr = startHr;
	}
	public String getEndHr() {
		return endHr;
	}
	public void setEndHr(String endHr) {
		this.endHr = endHr;
	}

}
