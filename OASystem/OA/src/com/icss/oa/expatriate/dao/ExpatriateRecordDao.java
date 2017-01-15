package com.icss.oa.expatriate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.common.DbUtil;
import com.icss.oa.common.Pager;
import com.icss.oa.expatriate.pojo.CooperateCompany;
import com.icss.oa.expatriate.pojo.Expatriate;
import com.icss.oa.expatriate.pojo.ExpatriateRecord;
import com.icss.oa.expatriate.service.CooperateCompanyService;
import com.icss.oa.expatriate.service.ExpatriateService;

/*
 * 外派记录
 */
public class ExpatriateRecordDao {
	public void insert(ExpatriateRecord expatriateRecord) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "insert into ExpatriateRecord values (ExpatriateRecord_seq.nextval,?,?)";
        
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, expatriateRecord.getExpatriate().getExpatriateId());
		pstmt.setInt(2, expatriateRecord.getCooperateCompany().getCooperateCompanyId());

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
	public void delete(int expatriateRecordId) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "delete from ExpatriateRecord where ExpatriateRecord_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, expatriateRecordId);
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
	public void update(ExpatriateRecord expatriateRecord) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "update expatriateRecord set expatriate_id=?,cooperatecompany_id=? where expatriateRecord_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, expatriateRecord.getExpatriate().getExpatriateId());
		pstmt.setInt(2, expatriateRecord.getCooperateCompany().getCooperateCompanyId());
		
		pstmt.setInt(3, expatriateRecord.getExpatriateRecordId());

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
	public ExpatriateRecord queryById(int expatriateRecordId) throws SQLException {

		ExpatriateRecord expatriateRecord = null;

		Connection conn = DbUtil.getConnection();

		String sql = "select * from expatriateRecord where expatriateRecord_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, expatriateRecordId);

		ResultSet rs = pstmt.executeQuery();
		Expatriate expatriate=new Expatriate();
		CooperateCompany cooperateCompany=new CooperateCompany();
		if(rs.next()) {
			cooperateCompany.setCooperateCompanyId(rs.getInt(3));
			expatriate.setExpatriateId(rs.getInt(2));
			expatriateRecord = new ExpatriateRecord(rs.getInt(1), 
					expatriate,
					cooperateCompany);
			
		}
		rs.close();
		pstmt.close();
		conn.close();

		return expatriateRecord;
	}

	/**
	 * 查询所有数据
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ExpatriateRecord> queryAll(Pager pager) throws SQLException {
		
		ArrayList<ExpatriateRecord> list = new ArrayList<ExpatriateRecord>();

		Connection conn = DbUtil.getConnection();

	/*	String sql = "select * from " +
				"ExpatriateRecord," +
				"Expatriate,cooperatecompany where Expatriate.Expatriate_Id=ExpatriateRecord.Expatriate_Id " +
				"and cooperatecompany.cooperatecompany_id=ExpatriateRecord.cooperatecompany_id";
*/
		String sql="select * from ( select rownum rnum,CooperateCompany.COOPERATECOMPANY_ID,cooperateCompany.COOPERATECOMPANY_NAME,"+
				 "cooperateCompany.COOPERATECOMPANY_PERSON,cooperateCompany.COOPERATECOMPANY_ADDRESS,"+
				 "COOPERATECOMPANY.COOPERATECOMPANY_TEL,"+
				 "expatriate.EXPATRIATE_NAME,expatriate.EXPATRIATE_SKILL,expatriate.EXPATRIATE_SALARY,"+
				 "expatriateRecord.EXPATRIATERECORD_ID,expatriate.EXPATRIATE_STATE "+
				 "from "+
				 "ExpatriateRecord,Expatriate,cooperatecompany " +
				 "where Expatriate.Expatriate_Id=ExpatriateRecord.Expatriate_Id "+ 
				 "and cooperatecompany.cooperatecompany_id=ExpatriateRecord.cooperatecompany_id) "+
				 "where rnum between ? and ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pager.getStart());
		pstmt.setInt(2, pager.getEnd());
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			CooperateCompany cooperateCompany=new CooperateCompany(rs.getInt("COOPERATECOMPANY_ID"),
					rs.getString("COOPERATECOMPANY_NAME"),rs.getString("COOPERATECOMPANY_PERSON"),
					rs.getString("COOPERATECOMPANY_ADDRESS"),rs.getString("COOPERATECOMPANY_TEL")); 
			
			Expatriate expatriate=new Expatriate(rs.getInt(2),rs.getString("EXPATRIATE_NAME"),
					rs.getString("EXPATRIATE_SKILL"),rs.getFloat("EXPATRIATE_SALARY"),rs.getString("EXPATRIATE_STATE"));
			ExpatriateRecord expatriateRecord = new ExpatriateRecord(rs.getInt("EXPATRIATERECORD_ID"), 
					expatriate,
					cooperateCompany);
			System.out.print(expatriate);
			list.add(expatriateRecord);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}
	public int getCount() throws SQLException {
		
		

		Connection conn = DbUtil.getConnection();

		String sql = "select count(*) from expatriateRecord";

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
