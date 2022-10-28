package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.ImageBBS;

public class ImageDAO {
	private String driver="oracle.jdbc.OracleDriver";
	private String url=
		"jdbc:oracle:thin:@//localhost:1521/XE";
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	//�۹�ȣ�� �Ϸù�ȣ�� ã�� �޼��� 
	public Integer getRownumBySeqno(Integer page) {
		String select="select rn "
				+ "from  (select seqno, rownum rn "
				+ "  from (select seqno, group_id, order_no from mysweet_imagebbs "
				+ "        order by group_id desc, order_no asc)"
				+ "  ) "
				+ "where seqno = ?";
		Integer rownum = 1;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setInt(1, page);
			rs = pstmt.executeQuery();
			if(rs.next()) rownum = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return rownum;
	}
	
	//�̹��� �Խñ��� ����� ������ update�ϴ� �޼���
	public boolean updateOrderNo(ImageBBS bbs) {
		String update="update mysweet_imagebbs "
				+ "set order_no = order_no + 1 "
				+ "where group_id = ? and"
				+ "	order_no >= ?";
		boolean result = false;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(update);
			pstmt.setInt(1, bbs.getGroup_id());
			pstmt.setInt(2, bbs.getOrder_no());
			pstmt.executeUpdate();//update����
			con.commit();
			result = true;
		}catch(Exception e) {e.printStackTrace();
		}finally {
			try {pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	//�̹��� �Խñ� ����(����,����,�����̸�) �޼���
	public boolean updateImage(ImageBBS bbs) {
		String update="update mysweet_imagebbs set title=?,"
			+ "content=?,image_name=? where seqno = ?";
		boolean result = false;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(update);
			pstmt.setString(1, bbs.getTitle());//������
			pstmt.setString(2, bbs.getContent());//���뼳��
			pstmt.setString(3, bbs.getImage_name());//���ϸ�
			pstmt.setInt(4, bbs.getSeqno());//�۹�ȣ ����
			pstmt.executeUpdate();//update����
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	//�۹�ȣ�� �̹��� �Խñ��� �����ϴ� �޼���
	public boolean deleteImage(Integer seqno) {
		String delete="delete from mysweet_imagebbs where seqno = ?";
		boolean result = false;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(delete);
			pstmt.setInt(1, seqno);
			pstmt.executeUpdate();//delete����
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	//번호로 이미지 게시글을 조회하는 메서드
	public ImageBBS getImageDetail(Integer seqno) {
		String select="select seqno,group_id,parent_id,order_no,"
			+ "   title,id,to_char(reg_date,'YYYY/MM/DD HH24:MI:SS'),"
			+ "   image_name, content, password"
			+ " from mysweet_imagebbs where seqno = ?";
		ImageBBS bbs = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setInt(1, seqno);
			rs = pstmt.executeQuery();
			if(rs.next()) {//��ȸ����� �����ϴ� ���
				bbs = new ImageBBS();
				bbs.setSeqno(rs.getInt(1));//�۹�ȣ����
				bbs.setGroup_id(rs.getInt(2));//�׷��ȣ
				bbs.setParent_id(rs.getInt(3));//�θ�۹�ȣ
				bbs.setOrder_no(rs.getInt(4));//������ȣ
				bbs.setTitle(rs.getString(5));//����
				bbs.setId(rs.getString(6));//�ۼ���(����)
				bbs.setReg_date(rs.getString(7));//�ۼ���
				bbs.setImage_name(rs.getString(8));//�����̸�
				bbs.setContent(rs.getString(9));//�۳���
				bbs.setPassword(rs.getString(10));//��ȣ����
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return bbs;
	}
	
	//�̹��� �Խñ��� ������ select�ϴ� �޼���
	public Integer getImageCount() {
		String select="select count(*) from mysweet_imagebbs";
		Integer count = 0;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {rs.close(); pstmt.close(); con.close();}
			catch(Exception e) {}
		}
		return count;
	}
	//�̹��� �Խñ� ����� select�ϴ� �޼���
	public ArrayList<ImageBBS> getAllImages(
			int start, int end){
		String select = "select seqno, group_id, parent_id, order_no, title, id,"
			+ " to_char(reg_date,'YYYY/MM/DD HH24:MI:SS'), "
			+ " image_name, content, password "
			+ "from (select img.*, rownum rn"
			+ "      from (select * from mysweet_imagebbs order by group_id desc, order_no asc) img "
			+ "       ) where rn between ? and ?";
		ArrayList<ImageBBS> list = new ArrayList<ImageBBS>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setInt(1, start); pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ImageBBS bbs = new ImageBBS();
				bbs.setSeqno(rs.getInt(1));//�۹�ȣ ����
				bbs.setGroup_id(rs.getInt(2));//�׷��ȣ ����
				bbs.setParent_id(rs.getInt(3));//�θ�۹�ȣ ����
				bbs.setOrder_no(rs.getInt(4));//������ȣ ����
				bbs.setTitle(rs.getString(5));//���� ����
				bbs.setId(rs.getString(6));//�ۼ���(����)����
				bbs.setReg_date(rs.getString(7));//�ۼ��ϼ���
				bbs.setImage_name(rs.getString(8));//�̹�����
				bbs.setContent(rs.getString(9));//�۳��뼳��
				bbs.setPassword(rs.getString(10));//��ȣ����
				list.add(bbs);//ArrayList�� DTO ����
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
	//�̹��� �Խñ��� insert�ϴ� �޼���
	public boolean putImageBBS(ImageBBS bbs) {
		String insert="insert into mysweet_imagebbs "
			+ "values(?,?,?,?,?,?,sysdate,?,?,?)";
		boolean result = false;//������ ����� ���� ����
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(insert);
			pstmt.setInt(1, bbs.getSeqno());
			pstmt.setInt(2, bbs.getGroup_id());
			pstmt.setInt(3, bbs.getParent_id());
			pstmt.setInt(4, bbs.getOrder_no());
			pstmt.setString(5, bbs.getTitle());
			pstmt.setString(6, bbs.getId());
			pstmt.setString(7, bbs.getImage_name());
			pstmt.setString(8, bbs.getContent());
			pstmt.setString(9, bbs.getPassword());
			pstmt.executeUpdate();//insert����
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {pstmt.close(); con.close();}
			catch(Exception e) {}
		}
		return result;
	}
	
	//�ִ� �۹�ȣ�� select�ϴ� �޼���
	public Integer getMaxSeqno() {
		String select="select max(seqno) from mysweet_imagebbs";
		Integer max = 0;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) max = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {rs.close(); pstmt.close(); con.close();}
			catch(Exception e) {}
		}
		return max;
	}
}






