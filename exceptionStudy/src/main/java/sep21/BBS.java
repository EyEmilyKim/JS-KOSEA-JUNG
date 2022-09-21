package sep21;

public class BBS {
	private int seqno; //글번호
	private String id; //작성자
	private String title; //제목
	private String content; //글내용
	//은닉된 변수의 값을 넣어주는 메서드(setter) 필요
	//은닉된 변수의 값을 읽어내는 메서드(getter) 필요
	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
