package utility;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.tomcat.util.modeler.modules.ModelerSource;

import model.BBS;
import model.FromTo;

public class Crud {
	private final String name = "mapper.home";
	
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
