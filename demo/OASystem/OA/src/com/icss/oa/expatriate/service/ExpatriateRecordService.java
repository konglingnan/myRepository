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
 * ���ɼ�¼
 */
public class ExpatriateRecordService {

	private ExpatriateRecordDao dao = new ExpatriateRecordDao();
	
	/**
	 * ���Ӳ���
	 * @throws SQLException 
	 */
	public void addExpatriateRecord(ExpatriateRecord expatriateRecord) throws SQLException {
		dao.insert(expatriateRecord);
	}
	
	/**
	 * �޸Ĳ���
	 */
	public void updateExpatriateRecord(ExpatriateRecord expatriateRecord) throws SQLException {
		dao.update(expatriateRecord);
	}
	
	/**
	 * ɾ������
	 */
	public void deleteExpatriateRecord(int expatriateRecordId) throws SQLException {
		dao.delete(expatriateRecordId);
	}
	
	/**
	 * ��ѯ�����Ĳ���
	 */
	public ExpatriateRecord queryExpatriateRecordById(int expatriateRecordId) throws SQLException {
		
		return dao.queryById(expatriateRecordId);
	}
	
	/**
	 * ��ѯ���в���
	 * @throws SQLException 
	 */
	public ArrayList<ExpatriateRecord> queryAllExpatriateRecord(Pager pager) throws SQLException {
		
		return dao.queryAll(pager);
	}
	public int getCount() throws SQLException {
		
		return dao.getCount();
	}
}
