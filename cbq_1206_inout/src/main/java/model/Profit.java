package model;

public class Profit {
	private String p_code;
	private String p_name;
	private Integer totalCnt;
	private Integer totlaProfit;
	private String totalProfit_str;
	
	public String getTotalProfit_str() {
		return totalProfit_str;
	}
	public void setTotalProfit_str(String totalProfit_str) {
		this.totalProfit_str = totalProfit_str;
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
	public Integer getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(Integer totalCnt) {
		this.totalCnt = totalCnt;
	}
	public Integer getTotlaProfit() {
		return totlaProfit;
	}
	public void setTotlaProfit(Integer totlaProfit) {
		this.totlaProfit = totlaProfit;
	}
	
}
