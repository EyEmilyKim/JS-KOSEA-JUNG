package notice;

public class DBExpert {
	/* 공지글 insert를 위한 쿼리를 만드는 메서드 */
	public void putNotice(Notice n) {
		String insert = "insert into notice values("+
				n.seq+",'"+n.title+"','"+n.writer+"',sysdate,'"
				+n.content+"')";//프로그램을 통한 쿼리에는 ;를 붙이지 않는다.
//		System.out.println(insert);//쿼리가 정상적으로 작성되는지 확인
				
	}
	
	public void getAllNotice() {
		String select = "select * from notice order by seq desc";
		System.out.println(select);
	}
}
