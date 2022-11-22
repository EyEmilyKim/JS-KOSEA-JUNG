package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
