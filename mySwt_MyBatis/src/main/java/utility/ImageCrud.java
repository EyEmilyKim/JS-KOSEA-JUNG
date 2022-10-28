package utility;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.ImageBBS;

public class ImageCrud {
	private final String name = "mapper.image";
	
	//글번호로 이미지 게시글을 수정하는 메서드
	public Integer updateImage(ImageBBS bbs) {
		SqlSession ss = getSession();
		Integer result = -1;
		try {
			String sql = name+".updateImage";
			result = ss.update(sql, bbs);
			if(result > 0) ss.commit();
			else ss.rollback();
		}finally {
			ss.close();
		}
		return result;
	}
	
	//글번호로 이미지 게시글을 삭제하는 메서드
	public Integer deleteImage(Integer no) {
		SqlSession ss = getSession();
		Integer result = -1;
		try {
			String sql = name+"deleteImage";
			result = ss.delete(sql, no);
			if(result > 0) ss.commit();
			else ss.rollback();
		}finally {
			ss.close();
		}
		return result;
	}
	
	//글번호로 이미지 게시글을 검색하는 메서드
	public ImageBBS getImageDetail(Integer no) {
		SqlSession ss = getSession();
		ImageBBS bbs = null; //검색결과가 저장될 변수 선언
		try {
			String sql = name + ".getImageDetail";
			bbs = ss.selectOne(sql, no);
		}finally {
			ss.close();
		}
		return bbs;
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
