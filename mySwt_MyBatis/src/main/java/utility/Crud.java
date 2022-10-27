package utility;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.BBS;
import model.FromTo;
import model.Item;
import model.Member;
import model.Notice;

public class Crud {
	private final String name = "mapper.home";
	
	//가입자 등록 메서드
	public Integer putMember(Member m) {
		SqlSession ss = this.getSession();
		Integer result = -1;
		try {
			String sql = name+".putMember";
			result = ss.delete(sql, m);
			if(result > 0) ss.commit();
			else ss.rollback();
		}finally {
			ss.close();
		}
		return result;
	}
	
	//계정으로 계정을 검색하는 메서드(중복검사용)
	public String getId(String id) {
		SqlSession ss = this.getSession();
		String result = null; //조회결과를 저장할 변수 선언
		try {
			String sql = name+".getId";
			result = ss.selectOne(sql, id);
		}finally {
			ss.close();
		}
		return result;
	}
	
	//장바구니 정보를 삭제하는 메서드
	public Integer deleteCart(Item item) {
		SqlSession ss = this.getSession();
		Integer result = -1; //삽입결과를 저장할 변수 선언
		try {
			String sql = name+".deleteCart";
			result = ss.delete(sql, item);
			if(result > 0) ss.commit();
			else ss.rollback();
		}finally {
			ss.close();
		}
		return result;
	}
	
	//장바구니 정보를 수정하는 메서드
	public Integer updateCart(Item item) {
		SqlSession ss = this.getSession();
		Integer result = -1; //삽입결과를 저장할 변수
		try {
			String sql = name+".updateCart";
			result = ss.update(sql, item);
			if(result > 0) ss.commit();
			else ss.rollback();
		}finally {
			ss.close();
		}
		return result;
	}
	
	//장바구니 정보를 삽입하는 메서드
	public Integer putCart(Item item) {
		SqlSession ss = this.getSession();
		Integer result = -1; //검색결과를 저장할 변수 선언
		try {
			String sql = name+".putCart";
			result = ss.selectOne(sql);
			if(result > 0) ss.commit();
			else ss.rollback();
		}finally {
			ss.close();
		}
		return result;
	}
	
	//가장 큰 장바구니 번호를 검색하는 메서드
	public Integer getMaxCartSeqno() {
		SqlSession ss = this.getSession();
		Integer max = 0; //검색결과를 저장할 변수 선언
		try {
			String sql = name+".getMaxCartSeqno";
			max = ss.selectOne(sql);
			if(max == null) max = 0;
		}finally {
			ss.close();
		}
		return max;
	}
	
	///////////////////////////
	//상품 목록 , 수정, 삭제  self 로 MyBatis 적용해보기
	///////////////////////////
	
	//상품 등록하는 메서드
	public Integer putItem(Item item) {
		SqlSession ss = this.getSession();
		Integer result = -1;
		try {
			String sql = name+".putItem";
			result = ss.insert(sql, item);
			if(result > 0) ss.commit();
			else ss.rollback();
		}finally {
			ss.close();
		}
		return result;
	}
	
	//상품번호로 상품번호를 검색하는 메서드(중복검사용)
	public String getCode(String no) {
		SqlSession ss = this.getSession();
		String code = null; //조회결과를 저장할 변수 선언
		try {
			String sql = name+".getCode";
			code = ss.selectOne(sql, no);
		}finally {
			ss.close();
		}
		return code;
	}
	
	//공지글 번호로 공지글 수정하는 메서드
	public Integer updateNotice(Notice notice) {
		SqlSession ss = this.getSession();
		Integer result = -1;
		try {
			String sql = name+".updateNotice";
			result = ss.update(sql, notice);
			if(result > 0) ss.commit();
			else ss.rollback();
		}finally {
			ss.close();
		}
		return result;
	}
	
	//공지글 번호로 공지글 삭제하는 메서드
	public Integer deleteNotice(Integer no) {
		SqlSession ss = this.getSession();
		Integer result = -1;
		try {
			String sql = name+".deleteNotice";
			result = ss.delete(sql, no);
			if(result > 0) ss.commit();
			else ss.rollback();
		}finally{
			ss.close();
		}
		return result;
	}
	
	//공지글 번호로 공지글을 검색하는 메서드
	public Notice getNoticeDetail(Integer no) {
		SqlSession ss = this.getSession();
		Notice result = null; //조회결과를 저장할 변수 선언
		try {
			String sql = name+".getNoticeDetail";
			result = ss.selectOne(sql, no);
		}finally {
			ss.close();
		}
		return result;

	}
	
	//전체 공지글을 검색하는 메서드
	public ArrayList<Notice> getAllNotice(FromTo ft) {
		SqlSession ss = this.getSession();
		ArrayList<Notice> list = null;
		try {
			String sql = name+".getAllNotice";
			list = (ArrayList)ss.selectList(sql, ft);
		}finally {
			ss.close();
		}
		return list;
	}
	
	//전체 공지글 갯수를 검색하는 메서드
	public Integer getNoticeCount() {
		SqlSession ss = this.getSession();
		Integer count = 0;
		try {
			String sql = name+".getNoticeCount";
			count = ss.selectOne(sql);
			if(count == null) count = 0;
		}finally {
			ss.close();
		}
		return count;
	}
	
	//공지글을 등록하는 메서드
	public Integer putNotice(Notice notice) {
		SqlSession ss = this.getSession();
		Integer result = -1;
		try {
			String sql = name+".putNotice";
			result = ss.insert(sql, notice);
			if(result > 0) ss.commit();
			else ss.rollback();
		}finally {
			ss.close();
		}
		return result;
	}
	//최대 공지글 번호를 검색하는 메서드
	public Integer getMaxNotice() {
		SqlSession ss = this.getSession();
		Integer result = 0;
		try {
			String sql = name+".getMaxNotice";
			result = ss.selectOne(sql);
			if(result == null) result = 0;
		}finally {
			ss.close();
		}
		return result;
	}
	
	//글번호로 글정보를 검색하는 메서드
	public BBS getBBSDetail(Integer id) {
		SqlSession ss = this.getSession();
		BBS bbs = null;
		try {
			String sql = name+".getBBSDetail";
			bbs = ss.selectOne(sql, id);
		}finally {
			ss.close();
		}
		return bbs;
	}
	
	//전체 게시글의 갯수를 검색하는 메서드
	public Integer getBBSCount() {
		SqlSession ss = this.getSession();
		Integer count = 0;
		try {
			String sql = name+".getBBSCount";
			count = ss.selectOne(sql);
			if(count == null) count = 0;
		}finally {
			ss.close();
		}
		return count;
	}
	
	//게시글 5개를 검색하는 메서드
	public ArrayList<BBS> getPageBBS(FromTo ft) {
		SqlSession ss = this.getSession();
		ArrayList<BBS> list = null;
		try {
			String sql = name+".getPageBBS";
			list = (ArrayList)ss.selectList(sql,ft);
		}finally {
			ss.close();
		}
		return list;
	}
	
	//게시글을 삽입하는 메서드
	public Integer putBBS(BBS bbs) {
		SqlSession ss = this.getSession();
		Integer result = -1;
		try {
			String sql = name+".putBBS";
			result = ss.insert(sql, bbs);
			if(result > 0) ss.commit();
			else ss.rollback();
		}finally {
			ss.close();
		}
		return result;
	}
	
	//가장 큰 게시글번호를 검색하는 메서드
	public Integer getMaxSeqno() {
		SqlSession ss = this.getSession();
		Integer max = 0;
		try {
			String sql = name+".getMaxSeqno";
			max = ss.selectOne(sql);
			if(max == null) max = 0;
		}finally {
			ss.close();
		}
		return max;
	}
	
	//계정으로 암호를 검색하는 메서드
	public String getPwd(String id) {
		SqlSession ss = this.getSession();
		String pwd = null; //조회결과를 저장할 변수 선언
		try {
			String sql = name+".getPwd";
			pwd = ss.selectOne(sql, id);
		}finally{
			ss.close();
		}
		return pwd;
	}
	
	//SqlSession 만드는 메서드
	private SqlSession getSession() {
		String config = "myBatisConfig.xml"; //환경설정파일명
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(config);
		}catch(Exception e) {}
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(is);
		SqlSession session = factory.openSession();
		return session;
	}
}
