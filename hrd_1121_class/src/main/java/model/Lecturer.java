package model;

public class Lecturer {
	private Integer idx; //번호
	private String name; //강사명
	private String major; //전공
	private String Field; //연구분야
	
	public Integer getIdx() {
		return idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getField() {
		return Field;
	}
	public void setField(String field) {
		Field = field;
	}
	
}
