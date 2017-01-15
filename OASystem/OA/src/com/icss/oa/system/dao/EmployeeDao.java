package com.icss.oa.system.dao;

import java.sql.Connection;
import java.sql.Date;
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
 * 员工DAO
 * @author Administrator
 *
 */
public class EmployeeDao {
	
	/**
	 * 插入数据
	 * @param emp
	 * @throws SQLException 
	 * 
	 */
	public void insert(Employee emp) throws SQLException {
		
		Connection conn = DbUtil.getConnection();

		String sql = "INSERT INTO employee VALUES (emp_seq.nextval,?,?,?,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, emp.getEmpName());
		pstmt.setString(2, emp.getEmpSex());
		pstmt.setDate(3, emp.getEmpBirth());
		pstmt.setString(4, emp.getEmpPasswd());
		pstmt.setInt(5, emp.getJob().getJobId());
		pstmt.setInt(6, emp.getDept().getDeptId());

		pstmt.executeUpdate();
		pstmt.close();
		conn.close();		
	}
	
	/**
	 * 
	 * 删除数据
	 * 
	 * @param empId
	 * @throws SQLException
	 */
	public void delete(int empId) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql0 = "delete from card where cardtype_id in (select cardtype_id from cardtype where employee_id=?)";
		String sql1 = "delete from manager where employee_id=?";
		String sql2 = "delete from cardtype where employee_id=?";
		String sql3 = "delete from distributecar where employee_id=?";
		String sql = "delete from employee where employee_id=?";

		PreparedStatement pstmt0 = conn.prepareStatement(sql0);
		pstmt0.setInt(1, empId);
		PreparedStatement pstmt1 = conn.prepareStatement(sql1);
		pstmt1.setInt(1, empId);
		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		pstmt2.setInt(1, empId);
		PreparedStatement pstmt3 = conn.prepareStatement(sql3);
		pstmt3.setInt(1, empId);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, empId);

		pstmt0.executeUpdate();
		pstmt1.executeUpdate();
		pstmt2.executeUpdate();
		pstmt3.executeUpdate();
		pstmt.executeUpdate();

		pstmt0.close();
		pstmt1.close();
		pstmt2.close();
		pstmt3.close();
		pstmt.close();
		conn.close();
	}

	/**
	 * 修改数据
	 * 
	 * @param emp
	 * @throws SQLException
	 */
	public void update(Employee emp) throws SQLException {

		Connection conn = DbUtil.getConnection();
		
		String sql = "update employee set employee_name=?,sex=?,birth=?, passwd=?, department_id=?,job_id=? where employee_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, emp.getEmpName());
		pstmt.setString(2, emp.getEmpSex());
		pstmt.setDate(3, emp.getEmpBirth());
		pstmt.setString(4, emp.getEmpPasswd());
		pstmt.setInt(5, emp.getDept().getDeptId());
		pstmt.setInt(6, emp.getJob().getJobId());
		pstmt.setInt(7, emp.getEmpId());

		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 根据id查询单条数据
	 * 
	 * @param empId
	 * @return
	 * @throws SQLExceptionc
	 */
	public Employee queryById(int empId) throws SQLException {

		Employee emp = null;
		
		
		Connection conn = DbUtil.getConnection();

		String sql = "select * from employee where employee_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, empId);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {

			Department dept = new Department();
			dept.setDeptId(rs.getInt(6));
			
			Job job = new Job();
			job.setJobId(rs.getInt(7));

			emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getDate(4), rs.getString(5), dept,job);
		}

		rs.close();
		pstmt.close();
		conn.close();

		return emp;
	}
	

	/**
	 * 分页查询所有数据
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Employee> query() throws SQLException {

		ArrayList<Employee> list = new ArrayList<Employee>();

		Connection conn = DbUtil.getConnection();

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT  employee_id,");		
		sb.append("               e.employee_name,");
		sb.append("               e.sex,");
		sb.append("               e.birth,");
		sb.append("               e.passwd,");
		sb.append("               e.department_id,");
		sb.append("               e.job_id,");
		sb.append("               d.department_name,");
		sb.append("               j.job_name");
		sb.append("        FROM   employee e ");
		sb.append("        INNER  JOIN department d ON e.department_id = d.department_id ");
		sb.append("        INNER  JOIN job j ON e.job_id = j.job_id ");
		sb.append("        ORDER BY e.employee_id ");

		String sql = sb.toString();

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Department dept = new Department();
			dept.setDeptId(rs.getInt(6));
			dept.setDeptName(rs.getString(8)); 
			
			Job job = new Job();
			job.setJobId(rs.getInt(7));
			job.setJobName(rs.getString(9));

			Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getDate(4), rs.getString(5), dept, job);
			
			list.add(emp);
		}

		rs.close();
		pstmt.close();
		conn.close();

		return list;
	}	
	

	/**
	 * 查询所有数据
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Employee> queryAll() throws SQLException {

		ArrayList<Employee> list = new ArrayList<Employee>();

		Connection conn = DbUtil.getConnection();

		String sql = "select * from employee";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Department dept = new Department();
			dept.setDeptId(rs.getInt(6));
			
			Job job = new Job();
			job.setJobId(rs.getInt(7));


			Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getDate(4), rs.getString(5), null, null);
			
			list.add(emp);
		}

		rs.close();
		pstmt.close();
		conn.close();

		return list;
	}	
	
	public ArrayList<Employee> queryAll(Pager pager) throws SQLException {

		ArrayList<Employee> list = new ArrayList<Employee>();

		Connection conn = DbUtil.getConnection();

		StringBuffer sb = new StringBuffer();
		
				
		sb.append("SELECT * FROM (SELECT rownum rnum,ee.* ");		
		sb.append("FROM   (SELECT e.employee_id,");	
		sb.append("               e.employee_name,");
		sb.append("               e.sex,");
		sb.append("               e.birth,");
		sb.append("               e.passwd,");
		sb.append("               e.department_id,");
		sb.append("               e.job_id,");
		sb.append("               d.department_name,");
		sb.append("               j.job_name");
		sb.append("        FROM   employee e ");
		sb.append("        INNER  JOIN department d ON e.department_id = d.department_id ");
		sb.append("        INNER  JOIN job j ON e.job_id = j.job_id ");
		sb.append("        ORDER BY e.employee_id) ee) ");
		sb.append("WHERE  rnum BETWEEN ? AND ?");
		
		String sql = sb.toString();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, pager.getStart());
		
		pstmt.setInt(2, pager.getEnd());

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Department dept = new Department();
			dept.setDeptId(rs.getInt(7));
			dept.setDeptName(rs.getString(9)); 
			
			Job job = new Job();
			job.setJobId(rs.getInt(8));
			job.setJobName(rs.getString(10));

			Employee emp = new Employee(rs.getInt(2), rs.getString(3), rs.getString(4),
					rs.getDate(5), rs.getString(6), dept, job);
			
			list.add(emp);
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
	public int getEmpCount() throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "SELECT COUNT(*) FROM employee";
		
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