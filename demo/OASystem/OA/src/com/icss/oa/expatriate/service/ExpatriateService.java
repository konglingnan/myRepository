package com.icss.oa.expatriate.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.common.DbUtil;
import com.icss.oa.common.Pager;
import com.icss.oa.expatriate.dao.ExpatriateDao;
import com.icss.oa.expatriate.dao.ExpatriateRecordDao;
import com.icss.oa.expatriate.pojo.Expatriate;
import com.icss.oa.expatriate.pojo.ExpatriateRecord;


public class ExpatriateService {
	private ExpatriateDao dao = new ExpatriateDao();
	
	/**
	 * 增加部门
	 * @throws SQLException 
	 */
	public void addExpatriate(Expatriate expatriate) throws SQLException {
		dao.insert(expatriate);
	}
	
	/**
	 * 修改部门
	 */
	public void updateExpatriate(Expatriate expatriate) throws SQLException {
		dao.update(expatriate);
	}
	public void updateExpatriate(int expatriateId) throws SQLException {
		dao.update(expatriateId);
	}
	
	/**
	 * 删除部门
	 */
	public void deleteExpatriate(int expatriateId) throws SQLException {
		dao.delete(expatriateId);
	}
	
	/**
	 * 查询单独的部门
	 */
	public Expatriate queryExpatriateById(int expatriateId) throws SQLException {
		
		return dao.queryById(expatriateId);
	}
	
	/**
	 * 查询所有部门
	 * @throws SQLException 
	 */
	public ArrayList<Expatriate> queryAllExpatriate(Pager pager) throws SQLException {
		
		return dao.queryAll(pager);
	}
	public int getCount() throws SQLException {
		
		return dao.getCount();
	}
	public ArrayList<Expatriate> queryAll() throws SQLException {
		
		return dao.queryAll();
	}

}
