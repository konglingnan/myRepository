package com.icss.oa.expatriate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.common.DbUtil;
import com.icss.oa.common.Pager;
import com.icss.oa.expatriate.pojo.Expatriate;

public class ExpatriateDao {
	public void insert(Expatriate expatriate) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "insert into Expatriate values (Expatriate_seq.nextval,?,?,?,'空闲')";
        
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, expatriate.getExpatriateName());
		pstmt.setString(2, expatriate.getExpatriateSkill());
		pstmt.setFloat(3, expatriate.getExpatriateSalary());
		pstmt.executeUpdate();
	    conn.commit();
		pstmt.close();
		
		conn.close();
	}

	/**
	 * 
	 * 删除数据
	 * 
	 * @param deptId
	 * @throws SQLException
	 */
	public void delete(int expatriateId) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "delete from Expatriate where Expatriate_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, expatriateId);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 修改数据
	 * 
	 * @param dept
	 * @throws SQLException
	 */
	public void update(Expatriate expatriate) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "update expatriate set expatriate_name=?,expatriate_skill=?,expatriate_salary=? ,expatriate_state=? where expatriate_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, expatriate.getExpatriateName());
		pstmt.setString(2, expatriate.getExpatriateSkill());
		pstmt.setFloat(3, expatriate.getExpatriateSalary());
		pstmt.setString(4,expatriate.getExpatriateState());
		pstmt.setInt(5, expatriate.getExpatriateId());
		conn.commit();
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	public void update(int expatriateId) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "update expatriate set expatriate_State='外派' where expatriate_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,expatriateId );
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 根据id查询单条数据
	 * 
	 * @param deptId
	 * @return
	 * @throws SQLException
	 */
	public Expatriate queryById(int expatriateId) throws SQLException {

		Expatriate expatriate = null;

		Connection conn = DbUtil.getConnection();

		String sql = "select * from expatriate where expatriate_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, expatriateId);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			expatriate = new Expatriate(rs.getInt(1), rs.getString(2),
					rs.getString(3),rs.getFloat(4),rs.getString(5));
		}

		rs.close();
		pstmt.close();
		conn.close();

		return expatriate;
	}
	public ArrayList<Expatriate> queryAll() throws SQLException {

		Expatriate expatriate = null;

		Connection conn = DbUtil.getConnection();

		String sql = "select * from expatriate where expatriate_state='空闲'";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ArrayList<Expatriate> list=new ArrayList<Expatriate>();

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			expatriate = new Expatriate(rs.getInt(1), rs.getString(2),
					rs.getString(3),rs.getFloat(4),rs.getString(5));
			list.add(expatriate);
		}

		rs.close();
		pstmt.close();
		conn.close();

		return list;
	}

	/**
	 * 查询所有数据
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Expatriate> queryAll(Pager pager) throws SQLException {
		
		ArrayList<Expatriate> list = new ArrayList<Expatriate>();

		Connection conn = DbUtil.getConnection();

		String sql = "select * from" +
				" (select rownum rnum,expatriate_Id,expatriate_Name," +
				"expatriate_Skill," +
				"expatriate_Salary,expatriate_State from expatriate)" +
				" where rnum between ? and ? ";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pager.getStart());
		pstmt.setInt(2, pager.getEnd());
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Expatriate expatriate = new Expatriate(rs.getInt(2), rs.getString(3),
					rs.getString(4),rs.getFloat(5),rs.getString(6));	
			list.add(expatriate);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}
	public int getCount() throws SQLException {
		
		

		Connection conn = DbUtil.getConnection();

		String sql = "select count(*) from expatriate";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		int num=0;
		if(rs.next()) num=rs.getInt(1); 
	
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return num;
	}
	
}
