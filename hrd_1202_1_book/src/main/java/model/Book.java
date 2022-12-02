package model;

public class Book {
	private Integer bookno;
	private String author;
	private String bookname;
	
	private String status;
	private String status_str;
	
	
	public String getStatus_str() {
		return status_str;
	}
	public void setStatus_str(String status_str) {
		this.status_str = status_str;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getBookno() {
		return bookno;
	}
	public void setBookno(Integer bookno) {
		this.bookno = bookno;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
}
