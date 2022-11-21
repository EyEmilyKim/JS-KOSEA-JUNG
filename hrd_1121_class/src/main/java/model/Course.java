package model;

public class Course {
	private String id; //과목코드
	private String name; //과목명
	private Integer credit; //학점
	private String lecturer_name; //담당강사(이름)
	private String week; //요일(문자)
	private Integer week_n; //요일(숫자)
	private String start_hour; //시작시간
	private String end_hour; //종료시간
	
	private String lecturer_idx; //담당강사(번호)
	public String getLecturer_idx() {
		return lecturer_idx;
	}
	public void setLecturer_idx(String lecturer_idx) {
		this.lecturer_idx = lecturer_idx;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public String getLecturer_name() {
		return lecturer_name;
	}
	public void setLecturer_name(String lecturer) {
		this.lecturer_name = lecturer;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public Integer getWeek_n() {
		return week_n;
	}
	public void setWeek_n(Integer week_n) {
		this.week_n = week_n;
	}
	public String getStart_hour() {
		return start_hour;
	}
	public void setStart_hour(String start_hour) {
		this.start_hour = start_hour;
	}
	public String getEnd_hour() {
		return end_hour;
	}
	public void setEnd_hour(String end_hour) {
		this.end_hour = end_hour;
	}
	
}
