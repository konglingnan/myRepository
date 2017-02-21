package com.icss.oa.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.common.DbUtil;
import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Department;
import com.icss.oa.system.pojo.Employee;
import com.icss.oa.system.pojo.Job;

/**
 * 部门DAO
 * 
 * @author Administrator
 * 
 */
public class DepartmentDao {

	/**
	 * 插入数据
	 * 
	 * @param dept
	 * @throws SQLException
	 */
	public void insert(Department dept) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "insert into department values (dept_seq.nextval,?,?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dept.getDeptName());
		pstmt.setString(2, dept.getDeptDesc());
		pstmt.setString(3, dept.getDeptTel());

		pstmt.executeUpdate();
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
	public void delete(int deptId) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "delete from department where department_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, deptId);
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
	public void update(Department dept) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "update department set department_name=?,department_desc=? ,department_Tel=? where department_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, dept.getDeptName());
		pstmt.setString(2, dept.getDeptDesc());
		pstmt.setString(3, dept.getDeptTel());
		pstmt.setInt(4, dept.getDeptId());

		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 返回总记录数
	 * @throws SQLException 
	 */
	public int getDeptCount() throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "SELECT COUNT(*) FROM department";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		
		int count = rs.getInt(1);
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return count;	
	}
	
	/**
	 * 根据id查询单条数据
	 * 
	 * @param deptId
	 * @return
	 * @throws SQLException
	 */
	public Department queryById(int deptId) throws SQLException {

		Department dept = null;

		Connection conn = DbUtil.getConnection();

		String sql = "select * from department where department_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, deptId);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			dept = new Department(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));
		}

		rs.close();
		pstmt.close();
		conn.close();

		return dept;
	}

	/**
	 * 查询所有数据
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Department> queryAll() throws SQLException {
		
		ArrayList<Department> list = new ArrayList<Department>();

		Connection conn = DbUtil.getConnection();

		String sql = "select * from department";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Department dept = new Department(rs.getInt(1), rs.getString(2),
					rs.getString(3),rs.getString(4));
			list.add(dept);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}

	public ArrayList<Department> queryAll(Pager pager) throws SQLException {

		ArrayList<Department> list = new ArrayList<Department>();

		Connection conn = DbUtil.getConnection();
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM (SELECT rownum rnum,dd.* ");
		sb.append("FROM   (SELECT *");
		sb.append("        FROM   department d ");
		sb.append("        ORDER BY d.department_id) dd) ");
		sb.append("WHERE  rnum BETWEEN ? AND ?");		
		
		String sql = sb.toString();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, pager.getStart());
		
		pstmt.setInt(2, pager.getEnd());

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Department dept = new Department(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
			
			list.add(dept);
		}

		rs.close();
		pstmt.close();
		conn.close();

		return list;
	}

}
