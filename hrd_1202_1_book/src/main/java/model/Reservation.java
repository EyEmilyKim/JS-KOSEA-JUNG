package model;

public class Reservation {
	private Integer lentno;
	private String custname;
	private String bookno;
	private String outdate;
	private String indate;
	private String status;
	
	private String bookname;
	private String lentno_str;

	
	public String getLentno_str() {
		return lentno_str;
	}

	public void setLentno_str(String lentno_str) {
		this.lentno_str = lentno_str;
	}

	public Integer getLentno() {
		return lentno;
	}

	public void setLentno(Integer lentno) {
		this.lentno = lentno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getBookno() {
		return bookno;
	}

	public void setBookno(String bookno) {
		this.bookno = bookno;
	}

	public String getOutdate() {
		return outdate;
	}

	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

}
