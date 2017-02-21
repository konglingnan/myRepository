package com.icss.oa.system.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.oa.system.dao.DepartmentDao;
import com.icss.oa.system.dao.JobDao;
import com.icss.oa.system.pojo.Department;
import com.icss.oa.system.pojo.Job;

/**
 * ְ��ҵ��
 * @author Administrator
 *
 */
public class JobService {
	
	private JobDao dao = new JobDao();
	
	/**
	 * ����ְ��
	 * @throws SQLException 
	 */
	public void addJob(Job job) throws SQLException {
		dao.insert(job);
	}
	
	/**
	 * �޸�ְ��
	 */
	public void updateJob(Job job) throws SQLException {
		dao.update(job);
	}
	
	/**
	 * ɾ��ְ��
	 */
	public void deleteJob(int jobId) throws SQLException {
		dao.delete(jobId);
	}
	
	/**
	 * ��ѯ������ְ��
	 */
	public Job queryJobById(int jobId) throws SQLException {
		
		return dao.queryById(jobId);
	}
	
	/**
	 * ��ѯ����ְ��
	 * @throws SQLException 
	 */
	public ArrayList<Job> queryAllJob() throws SQLException {
		
		return dao.queryAll();
	}

}