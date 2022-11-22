package model;

public class Player {
	private Integer seqno; //번호
	private String name; //이름
	private String addr; //주소
	private String birth; //생년월일
	
	private Integer t_id; //소속팀(번호)
	private String t_title; //소속팀(이름)
	private Integer ann_sal; //연봉
	private Integer b_num; //등번호
	
	public Integer getSeqno() {
		return seqno;
	}
	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Integer getT_id() {
		return t_id;
	}
	public void setT_id(Integer t_id) {
		this.t_id = t_id;
	}
	public String getT_title() {
		return t_title;
	}
	public void setT_title(String t_title) {
		this.t_title = t_title;
	}
	public Integer getAnn_sal() {
		return ann_sal;
	}
	public void setAnn_sal(Integer ann_sal) {
		this.ann_sal = ann_sal;
	}
	public Integer getB_num() {
		return b_num;
	}
	public void setB_num(Integer b_num) {
		this.b_num = b_num;
	}
	
}
