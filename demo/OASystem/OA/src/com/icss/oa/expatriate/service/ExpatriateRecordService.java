package com.icss.oa.expatriate.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.common.DbUtil;
import com.icss.oa.common.Pager;
import com.icss.oa.expatriate.dao.ExpatriateRecordDao;
import com.icss.oa.expatriate.pojo.Expatriate;
import com.icss.oa.expatriate.pojo.ExpatriateRecord;
import com.icss.oa.system.dao.DepartmentDao;
import com.icss.oa.system.pojo.Department;

/*
 * 外派记录
 */
public class ExpatriateRecordService {

	private ExpatriateRecordDao dao = new ExpatriateRecordDao();
	
	/**
	 * 增加部门
	 * @throws SQLException 
	 */
	public void addExpatriateRecord(ExpatriateRecord expatriateRecord) throws SQLException {
		dao.insert(expatriateRecord);
	}
	
	/**
	 * 修改部门
	 */
	public void updateExpatriateRecord(ExpatriateRecord expatriateRecord) throws SQLException {
		dao.update(expatriateRecord);
	}
	
	/**
	 * 删除部门
	 */
	public void deleteExpatriateRecord(int expatriateRecordId) throws SQLException {
		dao.delete(expatriateRecordId);
	}
	
	/**
	 * 查询单独的部门
	 */
	public ExpatriateRecord queryExpatriateRecordById(int expatriateRecordId) throws SQLException {
		
		return dao.queryById(expatriateRecordId);
	}
	
	/**
	 * 查询所有部门
	 * @throws SQLException 
	 */
	public ArrayList<ExpatriateRecord> queryAllExpatriateRecord(Pager pager) throws SQLException {
		
		return dao.queryAll(pager);
	}
	public int getCount() throws SQLException {
		
		return dao.getCount();
	}
}
