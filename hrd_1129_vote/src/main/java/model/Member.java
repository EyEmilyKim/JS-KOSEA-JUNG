package model;

public class Member {
	private String m_no; //후보번호
	private String m_name; //후보성명
	private String p_code; //소속정당(코드)
	private String p_school_num; //최종학력(숫자) (1:고졸,2:학사,3:석사,4:박사)
	private String m_jumin_full; //주민번호(전체13자리)
	private String m_city; //지역구
	
	private String p_name; //소속정당(이름)
	private String p_school_str; //최종학력(문자) (1:고졸,2:학사,3:석사,4:박사)
	private String m_jumin_first; //주민번호(앞6자리)
	private String m_jumin_last; //주민번호(뒤7자리)
	private String p_tel1; //소속당 대표번호1
	private String p_tel2; //소속당 대표번호2
	private String p_tel3; //소속당 대표번호3
	private String p_tel_full; //소속당 대표번호(전체)
	
	public String getM_no() {
		return m_no;
	}
	public void setM_no(String m_no) {
		this.m_no = m_no;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public String getP_school_num() {
		return p_school_num;
	}
	public void setP_school_num(String p_school_num) {
		this.p_school_num = p_school_num;
	}
	public String getM_jumin_full() {
		return m_jumin_full;
	}
	public void setM_jumin_full(String m_jumin_full) {
		this.m_jumin_full = m_jumin_full;
	}
	public String getM_city() {
		return m_city;
	}
	public void setM_city(String m_city) {
		this.m_city = m_city;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_school_str() {
		return p_school_str;
	}
	public void setP_school_str(String p_school_str) {
		this.p_school_str = p_school_str;
	}
	public String getM_jumin_first() {
		return m_jumin_first;
	}
	public void setM_jumin_first(String m_jumin_first) {
		this.m_jumin_first = m_jumin_first;
	}
	public String getM_jumin_last() {
		return m_jumin_last;
	}
	public void setM_jumin_last(String m_jumin_last) {
		this.m_jumin_last = m_jumin_last;
	}
	public String getP_tel1() {
		return p_tel1;
	}
	public void setP_tel1(String p_tel1) {
		this.p_tel1 = p_tel1;
	}
	public String getP_tel2() {
		return p_tel2;
	}
	public void setP_tel2(String p_tel2) {
		this.p_tel2 = p_tel2;
	}
	public String getP_tel3() {
		return p_tel3;
	}
	public void setP_tel3(String p_tel3) {
		this.p_tel3 = p_tel3;
	}
	public String getP_tel_full() {
		return p_tel_full;
	}
	public void setP_tel_full(String p_tel_full) {
		this.p_tel_full = p_tel_full;
	}
	
}
