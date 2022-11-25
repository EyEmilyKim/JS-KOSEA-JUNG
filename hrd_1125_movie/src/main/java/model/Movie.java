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
	public String getStartHr() {
		return startHr;
	}
	public void setStartHr(String start_hour) {
		this.startHr = start_hour;
	}
	public String getEndHr() {
		return endHr;
	}
	public void setEndHr(String end_hour) {
		this.endHr = end_hour;
	}
	
}
