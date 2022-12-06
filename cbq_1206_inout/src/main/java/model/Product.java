package model;

public class Product {
	private String p_code;
	private String p_name;
	private Integer p_size;
	private Integer p_incost;
	private Integer p_outcost;
	
	private String p_incost_str;
	private String p_outcost_str;
	
	
	public String getP_incost_str() {
		return p_incost_str;
	}
	public void setP_incost_str(String p_incost_str) {
		this.p_incost_str = p_incost_str;
	}
	public String getP_outcost_str() {
		return p_outcost_str;
	}
	public void setP_outcost_str(String p_outcost_str) {
		this.p_outcost_str = p_outcost_str;
	}
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public Integer getP_size() {
		return p_size;
	}
	public void setP_size(Integer p_size) {
		this.p_size = p_size;
	}
	public Integer getP_incost() {
		return p_incost;
	}
	public void setP_incost(Integer p_incost) {
		this.p_incost = p_incost;
	}
	public Integer getP_outcost() {
		return p_outcost;
	}
	public void setP_outcost(Integer p_outcost) {
		this.p_outcost = p_outcost;
	}
	
}
