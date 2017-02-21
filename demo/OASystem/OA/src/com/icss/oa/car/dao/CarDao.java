package com.icss.oa.car.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.car.pojo.Car;
import com.icss.oa.common.DbUtil;
import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Department;

/**
 * 汽车照片DAO类
 * @author Administrator
 *
 */

public class CarDao {

	/**
	 * 插入汽车
	 * @param car
	 * @throws SQLException 
	 */
	public void insert(Car car) throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "insert into car values (car_seq.nextval,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, car.getCarType());
		pstmt.setString(2, car.getCarTag());
		pstmt.setBinaryStream(3, car.getCarPic());
		
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();		
	}

	/**
	 * 删除汽车
	 * @param car
	 * @throws SQLException 
	 */
	public void delete(int carId) throws SQLException {

		System.out.println("Dao:"+carId);
		
		Connection conn = DbUtil.getConnection();
		String sql1 = "delete from distributecar where car_id=?";
		String sql = "delete from car where car_id=?";

		PreparedStatement pstmt1 = conn.prepareStatement(sql1);
		pstmt1.setInt(1, carId);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, carId);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	

	/**
	 * 修改汽车
	 * 
	 * @param car
	 * @throws SQLException
	 */
	public void update(Car car) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "update car set car_type=?, car_tag=? where car_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, car.getCarType());
		pstmt.setString(2, car.getCarTag());
		pstmt.setInt(3, car.getCarId());

		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	

	/**
	 * 根据id查询单条数据
	 * 
	 * @param 
	 * @return
	 * @throws SQLException
	 */
	public Car queryById(int carId) throws SQLException {

		Car car = null;

		Connection conn = DbUtil.getConnection();

		String sql = "select * from car where car_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, carId);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			car = new Car(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getBinaryStream(4));
		}

		rs.close();
		pstmt.close();
		

		return car;
	}
	/**
	 * 根据id查询单条数据
	 * 
	 * @param 
	 * @return
	 * @throws SQLException
	 */
	public Car queryTById(int carId) throws SQLException {

		Car car = null;

		Connection conn = DbUtil.getConnection();

		String sql = "select * from car where car_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, carId);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			car = new Car(rs.getInt(1), rs.getString(2), rs.getString(3),null);
		}

		rs.close();
		pstmt.close();
		

		return car;
	}
	/**
	 * 根据汽车照片id，查询汽车数据
	 * 
	 * @throws SQLException
	 */
	public Car queryPic(int carId) throws SQLException {
		
		Car car = null;

		Connection conn = DbUtil.getConnection();

		String sql = "select * from car where car_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, carId);

		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			car = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBinaryStream(4));
		}
		
		rs.close();
		pstmt.close();
//		conn.close();
		
		return car;
	}


	/**
	 * 返回总记录数
	 * @throws SQLException 
	 */
	public int getCarCount() throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "SELECT COUNT(*) FROM car";
		
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
	 * 查询所有数据
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Car> queryAll() throws SQLException {
		
		ArrayList<Car> list = new ArrayList<Car>();

		Connection conn = DbUtil.getConnection();

		String sql = "select car_id, car_type, car_tag from Car where car_id not in (select car_id from distributecar where  state = '派发中')";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Car car = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), null);
			list.add(car);
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
	public ArrayList<Car> excelQueryAll() throws SQLException {
		
		ArrayList<Car> list = new ArrayList<Car>();

		Connection conn = DbUtil.getConnection();

		String sql = "select car_id, car_type, car_tag from Car ";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Car car = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), null);
			list.add(car);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}

	public ArrayList<Car> queryAll(Pager pager) throws SQLException {

		ArrayList<Car> list = new ArrayList<Car>();

		Connection conn = DbUtil.getConnection();
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM (SELECT rownum rnum,cc.* ");
		sb.append("FROM   (SELECT car_id, car_type, car_tag");
		sb.append("        FROM   car c ");
		sb.append("        ORDER BY c.car_id) cc) ");
		sb.append("WHERE  rnum BETWEEN ? AND ?");		
		
		String sql = sb.toString();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, pager.getStart());
		
		pstmt.setInt(2, pager.getEnd());

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Car car = new Car(rs.getInt(2), rs.getString(3), rs.getString(4), null);
			
			list.add(car);
		}

		rs.close();
		pstmt.close();
		conn.close();

		return list;
	}

}