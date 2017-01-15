package com.icss.oa.expatriate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.card.pojo.Card;
import com.icss.oa.common.DbUtil;
import com.icss.oa.common.Pager;
import com.icss.oa.expatriate.pojo.CooperateCompany;
import com.icss.oa.expatriate.pojo.ExpatriateRecord;

public class CooperateCompanyDao {
	public void insert(CooperateCompany cooperateCompany) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "insert into cooperateCompany values (cooperateCompany_seq.nextval,?,?,?,?)";
        
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, cooperateCompany.getCooperateCompanyName());
		pstmt.setString(2, cooperateCompany.getCooperateCompanyPerson());
		pstmt.setString(3, cooperateCompany.getCooperateCompanyAddress());
		pstmt.setString(4, cooperateCompany.getCooperateCompanyTel());
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
	public void delete(int cooperateCompanyId) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "delete from cooperateCompany where cooperateCompany_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cooperateCompanyId);
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
	public void update(CooperateCompany cooperateCompany) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "update cooperateCompany set  cooperatecompany_name=?,cooperatecompany_person=?,cooperateCompany_tel=?" +
				", cooperatecompany_address=? where cooperateCompany_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, cooperateCompany.getCooperateCompanyName());
		pstmt.setString(2, cooperateCompany.getCooperateCompanyPerson());
		pstmt.setString(3, cooperateCompany.getCooperateCompanyTel());
		pstmt.setString(4, cooperateCompany.getCooperateCompanyAddress());
		pstmt.setInt(5, cooperateCompany.getCooperateCompanyId());

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
	public CooperateCompany queryById(int cooperateCompanyId) throws SQLException {

		CooperateCompany cooperateCompany = null;

		Connection conn = DbUtil.getConnection();

		String sql = "select * from cooperateCompany where cooperateCompany_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, cooperateCompanyId);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			cooperateCompany = new CooperateCompany(rs.getInt(1), rs.getString(2),
					rs.getString(3),rs.getString(4),rs.getString(5));
		}

		rs.close();
		pstmt.close();
		conn.close();

		return cooperateCompany;
	}
	public ArrayList<CooperateCompany> queryAll() throws SQLException {

		CooperateCompany cooperateCompany = null;

		Connection conn = DbUtil.getConnection();

		String sql = "select * from cooperateCompany ";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ArrayList<CooperateCompany> list=new ArrayList<CooperateCompany>();

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			cooperateCompany = new CooperateCompany(rs.getInt(1), rs.getString(2),
					rs.getString(3),rs.getString(4),rs.getString(5));
			list.add(cooperateCompany);
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
	public int getCount() throws SQLException {
		
		

		Connection conn = DbUtil.getConnection();

		String sql = "select count(*) from cooperateCompany";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		int num=0;
		if(rs.next()) num=rs.getInt(1); 
	
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return num;
	}
	
	 public ArrayList<CooperateCompany> queryAll(Pager pager) throws SQLException {
			
			ArrayList<CooperateCompany> list = new ArrayList<CooperateCompany>();

			Connection conn = DbUtil.getConnection();

			String sql ="select * from (select rownum rnum,cooperateCompany_Id,cooperateCompany_Name,cooperateCompany_Person," +
					"cooperateCompany_Address," +
					"cooperateCompany_Tel from CooperateCompany) where rnum between ? and ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pager.getStart());
			pstmt.setInt(2, pager.getEnd());
			ResultSet rs = pstmt.executeQuery();	
			
			while(rs.next()) {
				
				CooperateCompany cooperateCompany=new CooperateCompany(rs.getInt(2),rs.getString(3),
						rs.getString(4),
						rs.getString(5),rs.getString(6));
				
				list.add(cooperateCompany);
				
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
			return list;
		}
}
