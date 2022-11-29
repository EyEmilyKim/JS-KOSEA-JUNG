package model;

public class Vote {
	private String v_jumin; //유권자 주민번호(13자리)
	private String v_name; //유권자 성명
	private String m_no; //후보번호
	private String v_time; //투표시간 
	private String v_area; //투표장소
	private String v_confirm; //유권자확인 
	
	private String v_jumin_11; //유권자 주민번호(11자리)

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
	
}
