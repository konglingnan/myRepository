package notice.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import notice.Pojo.Notice;

import com.icss.oa.common.DbUtil;
import com.icss.oa.common.Pager;

public class NoticeDao {

	/**
	 * 插入数据
	 * 
	 * @param job
	 * @throws SQLException
	 */
	public void insert(Notice notice) throws SQLException {
		Connection conn = DbUtil.getConnection(); 
		String sql = "INSERT INTO notice values(notice_seq.nextval,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, notice.getTitle());
		pstmt.setString(2, notice.getContent());
		pstmt.setDate(3, notice.getNotice_time());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 删除数据
	 * 
	 * @param jobId
	 * @throws SQLException
	 */
	public void delete(int notice_id) throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "DELETE FROM notice WHERE notice_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, notice_id);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 修改数据
	 * 
	 * @param job
	 * @throws SQLException
	 */
	public void update(Notice notice) throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "UPDATE notice SET title=?,content=?,notice_time=? where notice_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, notice.getTitle());
		pstmt.setString(2, notice.getContent());
		pstmt.setDate(3, notice.getNotice_time());
		pstmt.setInt(4, notice.getNotice_id());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close(); 
	}

	/**
	 * 按ID查询数据
	 * 
	 * @param jobId
	 * @return
	 * @throws SQLException
	 */
	public Notice queryById(int notice_id) throws SQLException {
		Notice notice= null;
		Connection conn = DbUtil.getConnection();
		String sql = "SELECT * FROM notice WHERE notice_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, notice_id);                       /*!*/
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			notice = new Notice(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getDate(4));
		}
		rs.close();
		pstmt.close();
		conn.close();
		return notice;
	}
	
	/**
	 * 分页查询所有数据
	 * 
	 * @return
	 * @throws SQLException
	 */
	
	public ArrayList<Notice> queryAll(Pager pager) throws SQLException {
		//Notice notice = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		Connection conn = DbUtil.getConnection();
		
		String sql="SELECT * FROM (select rownum rnum,notice_id,title,content,notice_time from notice ) where rnum between ? and ?";
		//System.out.println(sql);
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1,pager.getStart());
		pstmt.setInt(2,pager.getEnd());
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Notice notice = new Notice();
		
			notice = new Notice(rs.getInt(2), rs.getString(3), rs.getString(4),rs.getDate(5));
			list.add(notice);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
	
	/**
	 * 返回总记录数
	 * @throws SQLException 
	 */
	
	public int getCount() throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "SELECT COUNT(*) FROM notice";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		
		int count = rs.getInt(1);
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return count;		
	}

}

