package model;

public class Goods {
	private String id; //상품번호
	private String name; //상품명
	private Integer price; //상품가격
	private String Made; //원산지
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getMade() {
		return Made;
	}
	public void setMade(String made) {
		Made = made;
	}

}
