package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.BBS;
import model.Item;
import model.Member;
import model.Notice;

public class DAO {
	private String driver="oracle.jdbc.OracleDriver";
	private String url=
		"jdbc:oracle:thin:@//localhost:1521/XE";
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	//�α����� �������� ��ٱ��� ���̺��� �˻��ϴ� �޼���
	public ArrayList<Item> getCartById(String id){
		String select="select code,num from mysweet_cart "
				+ "where id = ?";
		ArrayList<Item> itemList = new ArrayList<Item>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Item item = new Item();
				item.setCode(rs.getString(1));
				item.setNum(rs.getInt(2));
				itemList.add(item);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return itemList;
	}
	
	//��ٱ��� ���̺��� ��ǰ�� �����ϴ� �޼���
	public boolean deleteCart(String code,String id) {
		String delete="delete from mysweet_cart "
				+ "where code = ? and id = ?";
		boolean result = false;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(delete);
			pstmt.setString(1, code);
			pstmt.setString(2, id);
			pstmt.executeUpdate();//delete ����
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
	//��ٱ��� ���̺��� ������ �����ϴ� �޼���
	public boolean updateCart(Item item) {
		String update="update mysweet_cart set num = ? "
				+ "where id=? and code=?";
		boolean result = false;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(update);
			pstmt.setInt(1, item.getNum());
			pstmt.setString(2, item.getId());
			pstmt.setString(3, item.getCode());
			pstmt.executeUpdate();//update ����
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
	//��ٱ��� ���̺� �����ϴ� �޼���
	public boolean putCart(Item item) {
		String input="insert into mysweet_cart "
				+ "values(?,?,?,?)";
		boolean result = false;//���԰���� ���� ���� ����
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(input);
			pstmt.setInt(1, item.getSeqno());
			pstmt.setString(2, item.getId());
			pstmt.setString(3, item.getCode());
			pstmt.setInt(4, item.getNum());
			pstmt.executeUpdate();//insert ����
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
	//��ٱ��� ���̺��� ���� ū �Ϸù�ȣ �˻� �޼���
	public Integer getMaxCartSeqno() {
		String select="select max(seqno) from mysweet_cart";
		Integer max = 0;//����� ������ ���� ����
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs = pstmt.executeQuery();//select ����
			if(rs.next()) max = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return max;
	}
	
	//��ǰ���� ����(�̸�,����,����) �޼���
	public boolean updateItem(Item item) {
		String update="update mysweet_items "
			+ "set name=?,price=?,info=? where code=?";
		boolean result = false;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(update);
			pstmt.setString(1, item.getName());
			pstmt.setInt(2, item.getPrice());
			pstmt.setString(3, item.getInfo());
			pstmt.setString(4, item.getCode());
			pstmt.executeUpdate();//update ����
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
	//��ǰ��ȣ�� ��ǰ������ �����ϴ� �޼���
	public boolean deleteItem(String code) {
		String delete="delete from mysweet_items "
				+ "where code = ?";
		boolean result = false;//�۾������ ���� ���� ����
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(delete);
			pstmt.setString(1, code);
			pstmt.executeUpdate();//delete ����
			con.commit();
			result = true;//�۾� ������ �ǹ�
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	//��ǰ��ȣ�� ��ǰ������ �˻��ϴ� �޼���
	public Item getItemDetail(String code) {
		String select="select code,name,price,info,"
			+ "to_char(reg_date,'YYYY/MM/DD HH24:MI:SS')"
			+ " from mysweet_items where code = ?";
		Item item = null;//��ȸ����� ������ ���� ����
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();//select ����
			if(rs.next()) {
				item = new Item();
				item.setCode(rs.getString(1));//��ǰ��ȣ
				item.setName(rs.getString(2));//��ǰ�̸�
				item.setPrice(rs.getInt(3));//��ǰ����
				item.setInfo(rs.getString(4));//��ǰ����
				item.setReg_date(rs.getString(5));//�����
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return item;
	}
	
	//��ü ��ǰ�� ������ �˻��ϴ� �޼���
	public Integer getTotalItemCount() {
		String select="select count(*) from mysweet_items";
		Integer total = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs=pstmt.executeQuery();//select ����
			if(rs.next()) total = rs.getInt(1);
			else total = 0;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {rs.close(); pstmt.close(); con.close();}
			catch(Exception e) {}
		}
		return total;
	}
	
	//�������� �ش��ϴ� ��ǰ������ �˻��ϴ� �޼���
	public ArrayList<Item> getAllItems(int start,int end){
		String select="select code, name, price, r_date "
			+ "from	(select rownum rn, code, name, price, r_date"
			+ "	from (select code,name,price,"
			+ "		to_char(reg_date,'YYYY/MM/DD') r_date"
			+ "		from mysweet_items)"
			+ "	)"
			+ "where rn > ? and rn < ?";
		ArrayList<Item> list=new ArrayList<Item>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setInt(1, start);	pstmt.setInt(2, end);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Item item = new Item();
				item.setCode(rs.getString(1));//��ǰ��ȣ
				item.setName(rs.getString(2));//��ǰ�̸�
				item.setPrice(rs.getInt(3));//��ǰ����
				item.setReg_date(rs.getString(4));//�����
				list.add(item);//ArrayList�� ��ȸ�������
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
	
	//��ǰ������ �����ϴ� �޼���
	public boolean putItem(Item item) {
		String input="insert into mysweet_items "
				+ "values(?,?,?,?,sysdate)";
		boolean result = false;//���� ����� ���� ���� ����
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(input);
			pstmt.setString(1, item.getCode());
			pstmt.setString(2, item.getName());
			pstmt.setInt(3, item.getPrice());
			pstmt.setString(4, item.getInfo());
			pstmt.executeUpdate();//insert ����
			con.commit();
			result = true;//���� ������ �ǹ�
		}catch(Exception e) {	e.printStackTrace();
		}finally {
			try {pstmt.close(); con.close();}
			catch(Exception e) {}
		}
		return result;
	}
	
	//��ǰ��ȣ�� ��ǰ��ȣ�� �˻��ϴ� �޼���
	public String getCode(String id) {
		String select="select code from mysweet_items "
				+ "where code = ?";
		String selectedId = null;//��ȸ����� ������ ����
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();//select����
			if(rs.next()) 
				selectedId = rs.getString(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return selectedId;
	}
	
	//�������� �����ϴ� �޼���
	public boolean putMember(Member mem) {
		String insert="insert into mysweet_users "
				+ "values(?,?,?,?,?,?,?,?)";
		boolean result = false;//���� ����� ���� ���� ����
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(insert);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPwd());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getAddr());
			pstmt.setString(5, mem.getTel());
			pstmt.setString(6, mem.getGender());
			pstmt.setString(7, mem.getEmail());
			pstmt.setString(8, mem.getJob());
			pstmt.executeUpdate();//insert ����
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
	
	//�Էµ� �������� ������ �˻��ϴ� �޼���(���� �ߺ��˻��)
	public String getId(String id) {
		String select="select id from mysweet_users "
				+ "where id = ?";
		String selectedId = null;//��ȸ����� ������ ����
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();//select����
			if(rs.next()) 
				selectedId = rs.getString(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return selectedId;
	}
	
	//������ ��ȣ�� �������� �����ϴ� �޼���
	public boolean modifyNotice(Notice n) {
		String update="update mysweet_notice set content=?,"
				+ " title=? where seqno = ?";
		boolean result = false;//�۾��� ����� ���� ���� ����
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(update);
			pstmt.setString(1, n.getContent());//�۳��뼳��
			pstmt.setString(2, n.getTitle());//���� ����
			pstmt.setInt(3, n.getSeqno());//�۹�ȣ ����
			pstmt.executeUpdate();//update����
			con.commit();
			result = true;//update ���� ������ �ǹ�
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	//������ ��ȣ�� �������� �����ϴ� �޼���
	public boolean deleteNotice(int seqno) {
		String delete="delete from mysweet_notice "
				+ "where seqno = ?";
		boolean result = false;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(delete);
			pstmt.setInt(1, seqno);
			pstmt.executeUpdate();//delete����
			con.commit();
			result = true;//���� ���� ����
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {pstmt.close();con.close();}
			catch(Exception e) {}
		}
		return result;
	}
	
	//������ ��ȣ�� �������� �˻��ϴ� �޼���
	public Notice getNoticeDetail(int seqno) {
		String select="select seqno,title,writer,"
			+ "to_char(reg_date,'YYYY/MM/DD HH24:MI:SS'),"
			+ "content from mysweet_notice where seqno = ?";
		Notice notice = null;//��ȸ����� ������ ���� ����
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setInt(1, seqno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				notice = new Notice();
				notice.setSeqno(rs.getInt(1));//�۹�ȣ
				notice.setTitle(rs.getString(2));//����
				notice.setWriter(rs.getString(3));//�ۼ���
				notice.setReg_date(rs.getString(4));//�ۼ���
				notice.setContent(rs.getString(5));//�۳���
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return notice;
	}
	//��ü �������� ������ �˻��ϴ� �޼���
	public Integer getNoticeCount() {
		String select="select count(*) from mysweet_notice";
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
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return count;
	}
	//�ش� �������� ��µ� ������ �˻� �޼���
	public ArrayList<Notice> getAllNotice(int start,int end){
		String select="select seqno, title, writer, r_date "
			+ "	from (select rownum rn, seqno,title,writer, r_date from "
			+ "		(select seqno, title, writer,"
			+ "		to_char(reg_date,'YYYY-MM-DD HH24:MI:SS') r_date"
			+ "	        	from mysweet_notice"
			+ "	        	order by seqno desc)"
			+ "	       ) "
			+ "where rn > ? and rn < ?";
		ArrayList<Notice> list = new ArrayList<Notice>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Notice notice = new Notice();
				notice.setSeqno(rs.getInt(1));//�۹�ȣ
				notice.setTitle(rs.getString(2));//����
				notice.setWriter(rs.getString(3));//�ۼ���
				notice.setReg_date(rs.getString(4));//�ۼ���
				list.add(notice);
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
	
	//���� ū ������ ��ȣ�� �˻��ϴ� �޼���
	public Integer getMaxNotice() {
		String select="select max(seqno) from mysweet_notice";
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
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return max;
	}
	
	//������ ���� �޼���
	public boolean putNotice(Notice n) {
		String insert="insert into mysweet_notice "
			+ "values(?,?,?,sysdate,?)";
		boolean result = false;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(insert);
			pstmt.setInt(1, n.getSeqno());
			pstmt.setString(2, n.getTitle());
			pstmt.setString(3, n.getWriter());
			pstmt.setString(4, n.getContent());
			pstmt.executeUpdate();//insert����
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
	
	//�۹�ȣ�� �Խñ��� �˻��ϴ� �޼���
	public BBS getBBSDetail(int seqno) {
		String select = "select seqno,title,writer,"
			+ "to_char(reg_date,'YYYY-MM-DD HH24:MI:SS'),"
			+ "content from mysweet_bbs"
			+ " where seqno = ?";
		BBS bbs = null;//��ȸ ����� ������ ���� ����
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setInt(1, seqno);
			rs = pstmt.executeQuery();
			if(rs.next()) {//��ȸ ����� �����ϴ� ���
				bbs = new BBS();
				bbs.setSeqno(rs.getInt(1));//�۹�ȣ ����
				bbs.setTitle(rs.getString(2));//������ ����
				bbs.setWriter(rs.getString(3));//�ۼ��� ����
				bbs.setReg_date(rs.getString(4));//�ۼ���
				bbs.setContent(rs.getString(5));//�۳��� ����
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
	
	//��ü �Խñ��� ������ ã�� �޼���
	public Integer getTotalCount() {
		String select="select count(*) from mysweet_bbs";
		Integer totalCount = 0;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) {//��ȸ����� �����ϴ� ���
				totalCount = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return totalCount;
	}
	
	//�Խñ� ��ȸ �޼���(������ �� 5���� �۸� �˻�)
	public ArrayList<BBS> getPageBBS(int start, int end){
		String select="select seqno, title, writer, r_date "
		+ "from (select rownum rn, seqno,title,writer, r_date from "
		+ "	(select seqno, title, writer,"
		+ "	to_char(reg_date,'YYYY-MM-DD HH24:MI:SS') r_date"
		+ "        	from mysweet_bbs"
		+ "        	order by seqno desc)"
		+ "       ) "
		+ "where rn > ? and rn < ?";

		ArrayList<BBS> list = new ArrayList<BBS>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BBS bbs = new BBS();
				bbs.setSeqno(rs.getInt(1));//�۹�ȣ
				bbs.setTitle(rs.getString(2));//����
				bbs.setWriter(rs.getString(3));//�ۼ���
				bbs.setReg_date(rs.getString(4));//�ۼ���
				list.add(bbs);
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
	//�Խñ� ���� �޼���
	public boolean putBBS(BBS bbs) {
		String insert="insert into mysweet_bbs "
			+ "values(?,?,?,sysdate,?)";
		boolean result = false;//���� ���������� ���� ����
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(insert);
			pstmt.setInt(1, bbs.getSeqno());//�۹�ȣ
			pstmt.setString(2, bbs.getTitle());//����
			pstmt.setString(3, bbs.getWriter());//�ۼ���
			pstmt.setString(4, bbs.getContent());//�۳���
			pstmt.executeUpdate();//insert����
			con.commit();
			result = true;//���� ������ �ǹ�
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	//���� ū �۹�ȣ�� ã�� �޼���
	public Integer getMaxSeqno() {
		String select=
			"select max(seqno) from mysweet_bbs";
		Integer max = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) {//��ȸ����� �����ϴ� ���
				max = rs.getInt(1);
			}else {//��ȸ����� �������� �ʴ� ���
				max = 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return max;
	}
	
	public String getPwd(String id) {
		String select="select pwd from mysweet_users "
				+ "where id = ?";
		String pwd=null;//�˻��� ��ȣ�� ������ ��������
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pwd = rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return pwd;
	}//�������� ��ȣ�� �˻��ϴ� �޼���
}











