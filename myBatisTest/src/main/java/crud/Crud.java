package crud;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Test;

public class Crud {
//매퍼를 호출하는 객체(SqlSession)를 생성한다.
//SqlSession을 사용해서 매퍼 안의 쿼리를 호출하는 메소드를 작성한다.
	
	public Integer putData(Test test){
		SqlSession ss = getSession();
		Integer result = -1;
		String name = "mapper.test.putDate"; //매퍼이름.쿼리이름
		try {
			result = ss.insert(name, test); //매핑할 쿼리, 매개변수
			if(result > 0) ss.commit(); //양수 나오면 성공 -> 커밋
			else ss.rollback(); //음수 나오면 실패 -> 롤백
		}finally {
			ss.close();
		}
		return result;
	}
	
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
