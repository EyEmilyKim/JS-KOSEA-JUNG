package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Player;
import model.Team;

public class DBExpert {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private String uid = "hr";
	private String upw = "hr";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	//선수 번호로 야구선수 정보 변경
	public boolean updatePlayer(Player pl) {
		System.out.println("updatePlayer() called");
		String sql1 = "update baseball_player_tbl set "
				+ "name=?, addr=?, birth=to_date(?, 'yyyy-mm-dd') "
				+ "where seqno=? ";
		String sql2 = "update player_team_tbl set "
				+ "t_id=?, ann_sal=?, b_num=? "
				+ "where seqno=? ";
		int flag1 = -1;
		int flag2 = -1;
		boolean flag = false;
		try {
			System.out.println("updatePlayer() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(4, pl.getSeqno());
			pstmt.setString(1, pl.getName());
			pstmt.setString(2, pl.getAddr());
			pstmt.setString(3, pl.getBirth());
			flag1 = pstmt.executeUpdate();
			System.out.println("flag1 :"+flag1);
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(4, pl.getSeqno());
			pstmt.setInt(1, pl.getT_id());
			pstmt.setInt(2, pl.getAnn_sal());
			pstmt.setInt(3, pl.getB_num());
			flag2 = pstmt.executeUpdate();
			System.out.println("flag2 :"+flag2);
			if(flag1 > 0 && flag2 > 0) {
				conn.commit();
				System.out.println("commit() done");
				flag = true;
			}else {
				conn.rollback();
			}
		}catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("rollback() done");
		}finally {
			try { pstmt.close(); conn.close();}
			catch(Exception e) {}
		}
		System.out.println("updatePlayer() end");
		return flag;
	}
	
	//선수 번호로 야구선수 정보 검색
	public Player getPlayer(Integer seqno) {
		System.out.println("getPlayer() called");
		String sql = "select p.seqno, p.name, addr, to_char(birth, 'yyyy-mm-dd'), "
				+ "t_id, b_num, ann_sal "
				+ "from baseball_player_tbl p, player_team_tbl pt "
				+ "where p.seqno = ? "
				+ "and p.seqno = pt.seqno ";
		Player pl = null;
		try {
			System.out.println("getPlayer() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seqno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("getPlayer() true");
				pl = new Player();
				pl.setSeqno(rs.getInt(1));
				pl.setName(rs.getString(2));
				pl.setAddr(rs.getString(3));
				pl.setBirth(rs.getString(4));
				pl.setT_id(rs.getInt(5));
				pl.setB_num(rs.getInt(6));
				pl.setAnn_sal(rs.getInt(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close();}
			catch(Exception e) {}
		}
		System.out.println("getPlayer() end");
		return pl;
	}
	
	//야구선수 정보 삽입
	public boolean insertPlayer(Player pl) {
		System.out.println("insertPlayer() called");
		String sql1 = "insert into baseball_player_tbl values ("
				+ "?, ?, ?, to_date(?, 'yyyy-mm-dd') ) ";
		String sql2 = "insert into player_team_tbl values ("
				+ "?, ?, ?, to_date(sysdate, 'yyyy-mm-dd'), ? )";
		boolean flag1 = false;
		int flag2 = -1;
		boolean flag = false;
		try {
			System.out.println("insertPlayer() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, pl.getSeqno());
			pstmt.setString(2, pl.getName());
			pstmt.setString(3, pl.getAddr());
			pstmt.setString(4, pl.getBirth());
			pstmt.executeQuery();
			flag1 = true;
			System.out.println("flag1 :"+flag1);
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, pl.getSeqno());
			pstmt.setInt(2, pl.getT_id());
			pstmt.setInt(3, pl.getAnn_sal());
			pstmt.setInt(4, pl.getB_num());
			flag2 = pstmt.executeUpdate();
			System.out.println("flag2 :"+flag2);
			if(flag1 == true && flag2 > 0) {
				conn.commit();
				System.out.println("commit() done");
				flag = true;
			}else {
				conn.rollback();
			}
		}catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("rollback() done");
		}finally {
			try { ; pstmt.close(); conn.close();}
			catch(Exception e) {}
		}
		System.out.println("insertPlayer() end");
		return flag;
	}
	
	//최대 야구선수 번호 검색
	public Integer getMaxSeqno() {
		System.out.println("getMaxSeqno() called");
		String sql = "select max(seqno) from baseball_player_tbl ";
		Integer max = 0;
		try {
			System.out.println("getMaxSeqno() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) max = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close();}
			catch(Exception e) {}
		}
		System.out.println("getMaxSeqno() end");
		return max;
	}
	
	//전체 팀 번호,이름 검색
	public ArrayList<Team> getTeams(){
		System.out.println("getTeams() called");
		String sql = "select t_id, title from baseball_team_tbl ";
		ArrayList<Team> list = new ArrayList<Team>();
		try {
			System.out.println("getTeams() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("getTeams() true");
				Team tm = new Team();
				tm.setT_id(rs.getInt(1));
				tm.setTitle(rs.getString(2));
				list.add(tm);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close();}
			catch(Exception e) {}
		}
		System.out.println("getTeams() end");
		return list;
	}
	
	//전체 선수 목록 검색
	public ArrayList<Player> listPlayers(){
		System.out.println("listPlayers() called");
		String sql = "select p.seqno, p.name, p.addr, "
				+ "to_char(p.birth, 'yyyy-mm-dd'), t.title, pt.ann_sal, pt.b_num "
				+ "from baseball_player_tbl p, baseball_team_tbl t, player_team_tbl pt "
				+ "where p.seqno = pt.seqno "
				+ "and t.t_id = pt.t_id "
				+ "order by p.seqno ";
		ArrayList<Player> list = new ArrayList<Player>();
		try {
			System.out.println("listPlayers() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("listPlayers() true");
				Player pl = new Player();
				pl.setSeqno(rs.getInt(1));
				pl.setName(rs.getString(2));
				pl.setAddr(rs.getString(3));
				pl.setBirth(rs.getString(4));
				pl.setT_title(rs.getString(5));
				pl.setAnn_sal(rs.getInt(6));
				pl.setB_num(rs.getInt(7));
				list.add(pl);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close();}
			catch(Exception e) {}
		}
		System.out.println("listPlayers() end");
		return list;
	}
	
	//전체 팀 목록 검색
	public ArrayList<Team> listTeams(){
		System.out.println("listTeams() called");
		String sql = "select t.t_id, title, town, o.name, to_char(founding, 'yyyy-mm-dd') "
				+ "from baseball_team_tbl t, team_owner_tbl o "
				+ "where t.t_id = o.t_id "
				+ "order by t_id ";
		ArrayList<Team> list = new ArrayList<Team>();
		try {
			System.out.println("listTeams() tried");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("listTeams() true");
				Team tm = new Team();
				tm.setT_id(rs.getInt(1));
				tm.setTitle(rs.getString(2));
				tm.setTown(rs.getString(3));
				tm.setOwner(rs.getString(4));
				tm.setFounding(rs.getString(5));
				list.add(tm);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { rs.close(); pstmt.close(); conn.close();}
			catch(Exception e) {}
		}
		System.out.println("listTeams() end");
		return list;
	}
}
