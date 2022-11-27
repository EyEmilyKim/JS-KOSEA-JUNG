package model;

public class Movie {
	String id; //영화번호
	String title; //영화제목
	String open_date; //상영일
	String startHr; //시작시간
	String endHr; //종료시간
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOpen_date() {
		return open_date;
	}
	public void setOpen_date(String open_date) {
		this.open_date = open_date;
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
