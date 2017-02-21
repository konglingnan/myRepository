package com.icss.oa.car.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.car.pojo.Car;
import com.icss.oa.car.pojo.DistributeCar;
import com.icss.oa.common.DbUtil;
import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Department;
import com.icss.oa.system.pojo.Employee;
import com.icss.oa.system.pojo.Job;
/*
 * distributecar

		   route VARCHAR2(30),
		   start_date DATE,
		   end_date DATE,
		   state VARCHAR2(10),
		   employee_id NUMBER(6)REFERENCES employee(employee_id),
		   car_id NUMBER(6)REFERENCES car(car_id)
		   
 */
public class DistributeCarDao {

	/**
	 * 申请派发
	 * @param car
	 * @throws SQLException 
	 */
	public void insert(DistributeCar distributeCar) throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "insert into distributecar values (distributecar_seq.nextval,?,?,?,?,?,null)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, distributeCar.getRoute());
		pstmt.setDate(2, distributeCar.getStartDate());
		pstmt.setDate(3, distributeCar.getEndDate());
		pstmt.setString(4, "等待");
		pstmt.setInt(5, distributeCar.getEmployee().getEmpId());
		
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();		
	}
	
	public void delete(int distributeCarId) throws SQLException{
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "delete from distributecar where distributecar_id = ? ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, distributeCarId);

		pstmt.executeUpdate();
		pstmt.close();
		conn.close();		
	}

	/**
	 * 修改数据
	 * 
	 * @param distr
	 * @throws SQLException
	 */
	public void update(DistributeCar distributeCar) throws SQLException {

		Connection conn = DbUtil.getConnection();
		
		String sql = "update distributecar set route=?, start_date=?, end_date=? ,state=? ,employee_id=? ,car_id=? where distributecar_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, distributeCar.getRoute());
		pstmt.setDate(2, distributeCar.getStartDate());
		pstmt.setDate(3, distributeCar.getEndDate());
		pstmt.setString(4, "派发中");
		pstmt.setInt(5, distributeCar.getEmployee().getEmpId());
		pstmt.setInt(6, distributeCar.getCar().getCarId());
		pstmt.setInt(7, distributeCar.getdistributeCarId());
		
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}


	/**
	 * 根据id查询单条数据
	 * 
	 * @param distributeCarId
	 * @return
	 * @throws SQLExceptionc
	 */
	public DistributeCar queryById(int distributeCarId) throws SQLException {

		DistributeCar distributeCar = null;
		
		Connection conn = DbUtil.getConnection();

		String sql = "select * from distributecar where distributecar_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, distributeCarId);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {

			Employee employee = new Employee();
			employee.setEmpId(rs.getInt(6));
			
			Car car = new Car();
			car.setCarId(rs.getInt(7));

			distributeCar = new DistributeCar(rs.getInt(1), rs.getString(2), rs.getDate(3),
					rs.getDate(4), rs.getString(5), employee, car);
		}

		rs.close();
		pstmt.close();
		conn.close();

		return distributeCar;
	}

	/**
	 * 分页查询所有数据
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<DistributeCar> queryAll(Pager pager) throws SQLException {

		ArrayList<DistributeCar> list = new ArrayList<DistributeCar>();

		Connection conn = DbUtil.getConnection();

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM (SELECT rownum rnum,dd.* ");
		sb.append("FROM   (SELECT d.distributecar_id,");		
		sb.append("               d.route,");
		sb.append("               d.start_date,");
		sb.append("               d.end_date,");
		sb.append("               d.state,");
		sb.append("               e.employee_id,");
		sb.append("               c.car_id,");
		sb.append("               e.employee_name,");
		sb.append("               c.car_type");
		sb.append("        FROM   distributecar d ");
		sb.append("        INNER  JOIN employee e ON d.employee_id = e.employee_id ");
		sb.append("        INNER  JOIN car c ON d.car_id = c.car_id ");
		sb.append("        ORDER BY d.distributecar_id) dd) ");
		sb.append("WHERE  rnum BETWEEN ? AND ?");
		
		String sql = sb.toString();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, pager.getStart());
		pstmt.setInt(2, pager.getEnd());

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Employee employee = new Employee();
			employee.setEmpId(rs.getInt(7));
			employee.setEmpName(rs.getString(9)); 

			Car car = new Car();
			car.setCarId(rs.getInt(8));
			car.setCarType(rs.getString(10));

			DistributeCar distributeCar = new DistributeCar(rs.getInt(2), rs.getString(3), rs.getDate(4),
					rs.getDate(5), rs.getString(6), employee, car);
			
			list.add(distributeCar);
		}

		rs.close();
		pstmt.close();
		conn.close();

		return list;
	}	

	/**
	 * 分页查询所有未派
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<DistributeCar> queryAllDising(Pager pager) throws SQLException {

		ArrayList<DistributeCar> list = new ArrayList<DistributeCar>();

		Connection conn = DbUtil.getConnection();

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM (SELECT dd.* ");
		sb.append("FROM   (SELECT rownum rnum,d.distributecar_id, ");		
		sb.append("               d.route,");
		sb.append("               d.start_date,");
		sb.append("               d.end_date,");
		sb.append("               d.state,");
		sb.append("               e.employee_id,");
		sb.append("               e.employee_name");
		sb.append("        FROM   distributecar d , employee e ");
		sb.append("        where  state='等待' and d.employee_id = e.employee_id) dd) ");
		sb.append("WHERE  rnum BETWEEN ? AND ? ");

		String sql = sb.toString();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, pager.getStart());
		pstmt.setInt(2, pager.getEnd());

		ResultSet rs = pstmt.executeQuery();
		System.out.print("dddddddddddd"+pager.getStart()+pager.getEnd());
		while (rs.next()) {
			Employee employee = new Employee();
			employee.setEmpId(rs.getInt(7));
			employee.setEmpName(rs.getString(8)); 

			DistributeCar distributeCar = new DistributeCar(rs.getInt(2), rs.getString(3), rs.getDate(4),
					rs.getDate(5), rs.getString(6), employee, null);
			System.out.print("dddddddddddd"+distributeCar.toString());	
			list.add(distributeCar);
		}

		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}	
	
	public ArrayList<DistributeCar> queryAll() throws SQLException {

		ArrayList<DistributeCar> list = new ArrayList<DistributeCar>();

		Connection conn = DbUtil.getConnection();

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM (SELECT rownum rnum,dd.* ");
		sb.append("FROM   (SELECT d.distributecar_id,");		
		sb.append("               d.route,");
		sb.append("               d.start_date,");
		sb.append("               d.end_date,");
		sb.append("               d.state,");
		sb.append("               e.employee_id,");
		sb.append("               c.car_id,");
		sb.append("               e.employee_name,");
		sb.append("               c.car_type");
		sb.append("        FROM   distributecar d ");
		sb.append("        INNER  JOIN employee e ON d.employee_id = e.employee_id ");
		sb.append("        INNER  JOIN car c ON d.car_id = c.car_id ");
		sb.append("        ORDER BY d.distributecar_id) dd) ");
		
		String sql = sb.toString();
		

		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Employee employee = new Employee();
			employee.setEmpId(rs.getInt(7));
			employee.setEmpName(rs.getString(9)); 

			Car car = new Car();
			car.setCarId(rs.getInt(8));
			car.setCarType(rs.getString(10));

			DistributeCar distributeCar = new DistributeCar(rs.getInt(2), rs.getString(3), rs.getDate(4),
					rs.getDate(5), rs.getString(6), employee, car);
			
			list.add(distributeCar);
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
	public int getDisCount() throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "SELECT COUNT(*) FROM distributecar";
		
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
