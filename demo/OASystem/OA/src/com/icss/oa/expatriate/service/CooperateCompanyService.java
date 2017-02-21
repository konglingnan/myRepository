package com.icss.oa.expatriate.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.common.Pager;
import com.icss.oa.expatriate.dao.CooperateCompanyDao;
import com.icss.oa.expatriate.dao.ExpatriateRecordDao;
import com.icss.oa.expatriate.pojo.CooperateCompany;
import com.icss.oa.expatriate.pojo.ExpatriateRecord;

public class CooperateCompanyService {
	private CooperateCompanyDao dao = new CooperateCompanyDao();
	
	/**
	 * ���Ӳ���
	 * @throws SQLException 
	 */
	public void addCooperateCompany(CooperateCompany cooperateCompany) throws SQLException {
		dao.insert(cooperateCompany);
	}
	
	/**
	 * �޸Ĳ���
	 */
	public void updateCooperateCompany(CooperateCompany cooperateCompany) throws SQLException {
		dao.update(cooperateCompany);
	}
	
	/**
	 * ɾ������
	 */
	public void deleteCooperateCompany(int cooperateCompanyId) throws SQLException {
		dao.delete(cooperateCompanyId);
	}
	
	/**
	 * ��ѯ�����Ĳ���
	 */
	public CooperateCompany queryCooperateCompanyById(int cooperateCompanyId) throws SQLException {
		
		return dao.queryById(cooperateCompanyId);
	}
	public int getCount() throws SQLException {
		
		return dao.getCount();
	}
	
	/**
	 * ��ѯ���в���
	 * @throws SQLException 
	 */
	public ArrayList<CooperateCompany> queryAllCooperateCompany(Pager pager) throws SQLException {
		
		return dao.queryAll(pager);
	}
	public ArrayList<CooperateCompany> queryAllCooperateCompany() throws SQLException {
		
		return dao.queryAll();
	}
	
}
