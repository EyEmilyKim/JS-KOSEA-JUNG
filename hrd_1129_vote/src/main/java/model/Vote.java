package model;

public class Vote {
	private String v_jumin; //유권자 주민번호(13자리)
	private String v_name; //유권자 성명
	private String m_no; //후보번호
	private String v_time; //투표시간(hhmm)
	private String v_area; //투표장소
	private String v_confirm; //유권자확인 
	
	private String v_jumin_11; //유권자 주민번호(11자리)
	
	private String yy; //탄생연도2자리(from주민번호)
	private String mm; //탄생월2자리(from주민번호)
	private String dd; //탄생일2자리(from주민번호)
	private String v_birth_str; //생년월일(yyyy년mm월dd일생)
	private Integer v_age; //만나이
	private String v_gender; //성별(1,2 ..)
	private String v_gender_str; //성별(짝수:남, 홀수:여)
	private String v_time_str; //투표시간(hh:mm)
	
	public String getV_jumin() {
		return v_jumin;
	}
	public void setV_jumin(String v_jumin) {
		this.v_jumin = v_jumin;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public String getM_no() {
		return m_no;
	}
	public void setM_no(String m_no) {
		this.m_no = m_no;
	}
	public String getV_time() {
		return v_time;
	}
	public void setV_time(String v_time) {
		this.v_time = v_time;
	}
	public String getV_area() {
		return v_area;
	}
	public void setV_area(String v_area) {
		this.v_area = v_area;
	}
	public String getV_confirm() {
		return v_confirm;
	}
	public void setV_confirm(String v_confirm) {
		this.v_confirm = v_confirm;
	}
	public String getV_jumin_11() {
		return v_jumin_11;
	}
	public void setV_jumin_11(String v_jumin_11) {
		this.v_jumin_11 = v_jumin_11;
	}
	public String getYy() {
		return yy;
	}
	public void setYy(String yy) {
		this.yy = yy;
	}
	public String getMm() {
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
	public String getDd() {
		return dd;
	}
	public void setDd(String dd) {
		this.dd = dd;
	}
	public String getV_birth_str() {
		return v_birth_str;
	}
	public void setV_birth_str(String v_birth_str) {
		this.v_birth_str = v_birth_str;
	}
	public Integer getV_age() {
		return v_age;
	}
	public void setV_age(Integer v_age) {
		this.v_age = v_age;
	}
	public String getV_gender() {
		return v_gender;
	}
	public void setV_gender(String v_gender) {
		this.v_gender = v_gender;
	}
	public String getV_gender_str() {
		return v_gender_str;
	}
	public void setV_gender_str(String v_gender_str) {
		this.v_gender_str = v_gender_str;
	}
	public String getV_time_str() {
		return v_time_str;
	}
	public void setV_time_str(String v_time_str) {
		this.v_time_str = v_time_str;
	}
	
}
