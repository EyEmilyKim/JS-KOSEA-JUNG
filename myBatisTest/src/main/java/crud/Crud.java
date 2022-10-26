package crud;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Test;

public class Crud {
//매퍼를 호출하는 객체(SqlSession)를 생성한다.
//SqlSession을 사용해서 매퍼 안의 쿼리를 호출하는 메소드를 작성한다.
	private final String mapperName = "mapper.test";
	
	public ArrayList<Test> getAll(){
		SqlSession ss = this.getSession();
		ArrayList<Test> result = null; //조회결과 저장용 변수
		try {
			String name = mapperName+".getAll";
			result = (ArrayList)ss.selectList(name);
		}finally {
			ss.close();
		}
		return result;
	}
	
	//번호와 이름으로 번호, 이름, 주소, 날짜 찾는 메서드
	public Test getAllByNoName(Test test) {
		SqlSession ss = this.getSession();
		Test result = null; //조회결과를 저장할 변수
		try {
			String name = this.mapperName+".getAllByNoName";
			result = ss.selectOne(name, test);
		}finally {
			ss.close();
		}
		return result;
	}
	
	//번호로 이름, 주소, 날짜 찾는 메서드
	public Test getNameAddrDate(Integer no) {
		SqlSession ss = this.getSession();
		Test test = null; //조회결과를 저장할 변수 선언
		try {
			String name = this.mapperName+".getNameAddrDate";
			test = ss.selectOne(name, no);
		}finally {
			ss.close();
		}
		return test;
	}
	
	//번호로 날짜 조회하는 메서드
	public String getDate(Integer no) {
		SqlSession ss = this.getSession();
		String date = null;
		try {
			String name = this.mapperName+".getDate";
			date = ss.selectOne(name, no);
		}finally {
			ss.close();
		}
		return date;
	}
	
	//번호로 이름 조회하는 메서드
	public String getName(Integer no) {
		SqlSession ss = this.getSession();
		String name = null; //조회결과를 저장할 변수 선언
		try {
			String sql = this.mapperName+".getName";
			name = ss.selectOne(sql, no);
			//조회결과가 1건인 경우 사용하는 메서드 : selectOne()		
		}finally {
			ss.close();
		}
		return name;
	}
	
	//수정하는 메서드
	public Integer updateData(Test test) {
		SqlSession ss = this.getSession();
		Integer result = -1;
		try {
			String name = this.mapperName+".updateData";
			result = ss.update(name, test);
			if(result > 0) ss.commit();
			else ss.rollback();
		}finally {
			ss.close();
		}
		return result;
	}
	
	//삭제하는 메서드
	public Integer deleteData(Integer no) {
		SqlSession ss = this.getSession();
		Integer result = -1;
		try {
			String name = mapperName+".deleteData"; //매퍼이름.쿼리이름
			result = ss.delete(name, no);
			if(result > 0) ss.commit();
			else ss.rollback();
		}finally {
			ss.close(); //세션 반납
		}
		return result;
	}
	
	//삽입하는 메서드
	public Integer putData(Test test){
		SqlSession ss = getSession();
		Integer result = -1;
		String name = mapperName+".putDate"; //매퍼이름.쿼리이름(매퍼의 namespace, 쿼리의 id)
		try {
			result = ss.insert(name, test); //매핑할 쿼리, 매개변수
			if(result > 0) ss.commit(); //양수 나오면 성공 -> 커밋
			else ss.rollback(); //음수 나오면 실패 -> 롤백
		}finally {
			ss.close();
		}
		return result;
	}
	
	//SqlSession 만드는 메서드
	private SqlSession getSession() {
		String config = "mybatisConfig.xml"; //환경설정파일명
		InputStream is = null;
		try {
			is=Resources.getResourceAsStream(config);
		}catch(Exception e) {}
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(is);
		SqlSession session = factory.openSession();
		return session;
	}
}
